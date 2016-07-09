package com.infoshareacademy.finances.reports.services;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import com.google.gson.Gson;
import com.infoshareacademy.finances.reports.entities.AssetsSumDTO;
import com.infoshareacademy.finances.reports.entities.PlanActionType;
import com.infoshareacademy.finances.reports.entities.Report;
import com.infoshareacademy.finances.reports.entities.ReportName;
import com.infoshareacademy.finances.reports.repository.ReportsRepository;
import com.infoshareacademy.finances.reports.repository.StatisticRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Stateless
public class MaxSumStatisticService {
    private final static Logger LOGGER = LoggerFactory.getLogger(MaxSumStatisticService.class);

    @EJB
    StatisticRepository statisticRepository;

    @EJB
    ReportsRepository reportsRepository;


    @Schedule(hour = "*", minute = "*", second = "*/10")
    public void generateMostPurchasedAssetsReport(){
        LOGGER.info("Genereting MostPurchasedAssetsReport started.");

        List<AssetsSumDTO> maxPurchasing = statisticRepository.findMostPurchasedOrSoldAssets(PlanActionType.BUY);

        Gson gson = new Gson();
        LOGGER.info("MostPurchasedAssetsReport: {} ", gson.toJson(maxPurchasing));

        Report report = new Report(ReportName.MOST_PURCHASED_ASSETS, gson.toJson(maxPurchasing));
        reportsRepository.save(report);

        LOGGER.info("Genereting MostPurchasedAssetsReport ended.");
    }


    @Schedule(hour = "*", minute = "*", second = "*/10")
    public void generateMostSoldAssetsReport(){
        LOGGER.info("Genereting MostSoldAssetsReport started.");

        List<AssetsSumDTO> maxSelling = statisticRepository.findMostPurchasedOrSoldAssets(PlanActionType.SELL);

        Gson gson = new Gson();
        LOGGER.info("MostSoldAssetsReport: {} ", gson.toJson(maxSelling));

        Report report = new Report(ReportName.MOST_SOLD_ASSETS, gson.toJson(maxSelling));
        reportsRepository.save(report);

        LOGGER.info("Genereting MostSoldAssetsReport ended.");
    }

}
