package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.FundStatsDTO;
import com.infoshareacademy.finances.repository.MaxPurchasingFundsRepository;
import com.infoshareacademy.finances.repository.MaxSellingFundsRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StatisticsService {

    @EJB
    MaxPurchasingFundsRepository buyRepository;

    @EJB
    MaxSellingFundsRepository sellRepository;


    public List<FundStatsDTO> returnBuyStatistics(){
        List<FundStatsDTO> out = new ArrayList<>();

        buyRepository.findMaxPurchasingFunds()
                .forEach(s -> out.add(new FundStatsDTO(s.getAssetName(), s.getAssetId(), s.getSum())));
        return out;
    }

    public List<FundStatsDTO> returnSellStatistics(){
        List<FundStatsDTO> out = new ArrayList<>();
        sellRepository.findMaxSellingFunds()
                .forEach(s -> out.add(new FundStatsDTO(s.getAssetName(), s.getAssetId(), s.getSum())));
        return out;
    }
}
