package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.Asset;
import com.infoshareacademy.finances.model.AssetsName;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;


public class LstLoad {

    private final Map<Integer, Asset> mapAssetName;
    private AssetsName assetsName;
    private int size;

    public LstLoad(String lstFile) {
        AssetsName assetsName = new AssetsName();
        this.mapAssetName = assetsName.getAssetsName(lstFile);
        this.size = mapAssetName.size();
    }

    public int loadFunds() {
        return size;
    }


    public int drawMenu() {
        System.out.println("List of assets: ");

        Set<Map.Entry<Integer, Asset>> entrySet = mapAssetName.entrySet();
        for (Map.Entry<Integer, Asset> entry : entrySet){
            Asset asset = entry.getValue();
            System.out.printf("%d :\t %s (%s) %n",entry.getKey(), asset.getName(), asset.getCode());
        }

        Scanner input = new Scanner(System.in);
        System.out.printf("Enter number of the Asset (1-%d): ", size);
        int assetNumber = input.nextInt();

        return assetNumber;
    }


    public String getFundName(Integer fundIndex) {
        String value = (String)mapAssetName.get(fundIndex).getName();

        return value;
    }


    public String getFundFileName(Integer fundIndex) {
        String value = mapAssetName.get(fundIndex).getCode() + ".txt";

        return value;
    }


    public LocalDate askForDate() throws ParseException {
        int year, month;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter year (YYYY) to calculation: ");
        year = input.nextInt();

        System.out.println("Enter month (MM) to calculation: ");
        month = input.nextInt();

        LocalDate localDate = LocalDate.now().withYear(year).withMonth(month);

        return localDate;
    }

}
