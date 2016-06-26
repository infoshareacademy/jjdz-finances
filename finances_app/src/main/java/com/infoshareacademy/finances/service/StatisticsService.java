package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.dto.FundStatsDTO;
import com.infoshareacademy.finances.repository.StatisticsRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StatisticsService {

    @EJB
    StatisticsRepository statisticsRepository;


    public List<FundStatsDTO> returnBuyStatistics(){
        List<FundStatsDTO> out = new ArrayList<>();

        statisticsRepository.findMaxPurchasingFunds()
                .forEach(s -> out.add(new FundStatsDTO(s.getAssetName(), s.getAssetId(), s.getSum())));
        return out;
    }

    public List<FundStatsDTO> returnSellStatistics(){
        List<FundStatsDTO> out = new ArrayList<>();
        statisticsRepository.findMaxSellingFunds()
                .forEach(s -> out.add(new FundStatsDTO(s.getAssetName(), s.getAssetId(), s.getSum())));
        return out;
    }
}
