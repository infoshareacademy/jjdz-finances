package com.infoshareacademy.finances.web;

import javax.annotation.PostConstruct;
import javax.ejb.*;

import com.infoshareacademy.finances.model.LstList;
import com.infoshareacademy.finances.service.LstLoad;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Singleton
@Startup
@Lock(LockType.READ)
public class mainFinances {
    @Override
    public String toString() {
        return "mainFinances{" +
                "allFunds=" + allFunds +
                '}';
    }

    private List<LstList> allFunds;

    public List<LstList> getAllFunds() {
        return allFunds;
    }

    @PostConstruct
    public void initialize() {
        System.out.println("setup: Loading data ...");

        // Load Funds from resources lst funds
        LstLoad menuInstance = new LstLoad();

        int FundsCount = 0;
        try {
            FundsCount = menuInstance.loadFunds("/omegafun.lst");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Funds loaded from file: %s%n", FundsCount);

        // load lst
        List<LstList> FundList = menuInstance.LstList();

        Collections.sort(FundList, new Comparator<LstList>() {
            @Override
            public int compare(LstList o1, LstList o2) {
                return o1.getFundName().compareTo(o2.getFundName());
            }
        });

        allFunds = FundList;
    }

}
