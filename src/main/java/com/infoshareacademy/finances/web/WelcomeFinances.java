package com.infoshareacademy.finances.web;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.infoshareacademy.finances.service.LstLoad;

import java.io.*;


@Stateless
public class WelcomeFinances {
    // Load Funds from resources lst funds
    LstLoad menuInstance = new LstLoad();

    @PostConstruct
    public void setup() {

        System.out.println("setup: Loading data ...");

        int FundsCount = 0;
        try {
            FundsCount = menuInstance.loadFunds("/omegafun.lst");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Funds loaded: %s%n", FundsCount);

    }


    public String welcome() {

        // display Funds
//        Integer menuItem = menuInstance.drawMenu();
//        System.out.println("Asset choosed: " + menuItem);

        return "Tri Finences ver. -1 ;)";
    }

}
