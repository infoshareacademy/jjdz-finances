package com.infoshareacademy.finances.reports.services;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import com.google.gson.Gson;
import com.infoshareacademy.finances.reports.dto.AssetsSumDTO;
import com.infoshareacademy.finances.reports.entities.PlanActionType;
import com.infoshareacademy.finances.reports.entities.Report;
import com.infoshareacademy.finances.reports.repository.StatisticRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.reports.entities.ReportName;
import com.infoshareacademy.finances.reports.repository.ReportsRepository;

import java.util.List;


@Stateless
public class MaxSumStatisticService {
    private final static Logger LOGGER = LoggerFactory.getLogger(MaxSumStatisticService.class);
    public static final int NUMBER_OF_RETAINED_REPORTS = 10;

    @EJB
    StatisticRepository statisticRepository;

    @EJB
    ReportsRepository reportsRepository;


    @Schedule(hour = "*", minute = "*/5")
    public void generateMostPurchasedAssetsReport(){
        LOGGER.info("Genereting MostPurchasedAssetsReport started.");

        List<AssetsSumDTO> maxPurchasing = statisticRepository.findMostPurchasedOrSoldAssets(PlanActionType.BUY);

        Gson gson = new Gson();
        LOGGER.info("MostPurchasedAssetsReport: {} ", gson.toJson(maxPurchasing));

        Report report = new Report(ReportName.MOST_PURCHASED_ASSETS, gson.toJson(maxPurchasing));
        reportsRepository.save(report);

        LOGGER.info("Genereting MostPurchasedAssetsReport is over.");
    }


    @Schedule(hour = "*", minute = "*/5")
    public void generateMostSoldAssetsReport(){
        LOGGER.info("Genereting MostSoldAssetsReport started.");

        List<AssetsSumDTO> maxSelling = statisticRepository.findMostPurchasedOrSoldAssets(PlanActionType.SELL);

        Gson gson = new Gson();
        LOGGER.info("MostSoldAssetsReport: {} ", gson.toJson(maxSelling));

        Report report = new Report(ReportName.MOST_SOLD_ASSETS, gson.toJson(maxSelling));
        reportsRepository.save(report);

        LOGGER.info("Genereting MostSoldAssetsReport is over.");
    }

    @Schedule(hour = "*", minute = "*/10")
    public void removeOldReports(){
        LOGGER.info("Removing old reports.");

        Long idMostPurchasedAssets = reportsRepository.returnReportMaxId(ReportName.MOST_PURCHASED_ASSETS);
        Long borderIdBuy = idMostPurchasedAssets - NUMBER_OF_RETAINED_REPORTS;

        int removedBuy = reportsRepository.deleteOldReports(ReportName.MOST_PURCHASED_ASSETS, borderIdBuy);
        LOGGER.info("Removed {} MostPurchasedAssets reports.", removedBuy);


        Long idMostSoldAssets = reportsRepository.returnReportMaxId(ReportName.MOST_SOLD_ASSETS);
        Long borderIdSell = idMostSoldAssets - NUMBER_OF_RETAINED_REPORTS;

        int removedSell = reportsRepository.deleteOldReports(ReportName.MOST_SOLD_ASSETS, borderIdSell);

        LOGGER.info("Removed {} MostSoldAssets reports.", removedSell);

        LOGGER.info("Removing old reports ... is over.");
    }
}
