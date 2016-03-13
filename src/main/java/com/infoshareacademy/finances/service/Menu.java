package com.infoshareacademy.finances.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    private List<String> fundsList = new ArrayList();
    private List<String> fundsFile = new ArrayList();

    public int loadFunds(String lstFile) throws IOException {
        int count = 1;

        String patternString = "(?<date>^\\S+)(\\s{2,})(?<time>\\S+)(\\s{2,})(?<size>\\S+{2,}).(?<unit>\\S+)(\\s{2,})(?<file>\\S+)(\\s{2,})(?<fund>.*$)";
        Pattern pattern = Pattern.compile(patternString);

        InputStream fis = new FileInputStream(lstFile);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        for (int skip = 0; skip < 3; skip++) {
            br.readLine();
        }

        String line;
        while ((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
/*                String date = matcher.group("date");
                String time = matcher.group("time");
                String size = matcher.group("size");
                String unit = matcher.group("unit"); */
                String file = matcher.group("file");
                String fund = matcher.group("fund");
                fundsList.add(fund);
                fundsFile.add(file);
                count++;
            }
        }
        return count - 1;
    }


    public int drawMenu() {
        int sizeFundList = fundsList.size();

        for (int i = 0; i < sizeFundList; i++) {
            System.out.println(fundsList.get(i));
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Fund to calculations (1-" + sizeFundList + "): ");
        int fundNR = input.nextInt();
        return fundNR;
    }

    public String getFundName(Integer FundIndex) {
        return fundsList.get(FundIndex);
    }

    public String getFundFileName(Integer FundIndex) {
        return fundsFile.get(FundIndex);
    }


    // ########################### MAIN #############################################

    public static void main(String[] argv) throws Exception {
        // Open file from argument line (ex. Data/omegafun.lst)

        String lstFile = argv[0];
        // System.out.println("lstFile = [" + lstFile + "]");
        Menu menuInstance = new Menu();
        Integer FundsCount = menuInstance.loadFunds(lstFile);

        Integer menuItem = menuInstance.drawMenu();
        System.out.println("Fund choosed: " + menuItem);

        String menuName = menuInstance.getFundName(menuItem);
        System.out.println("Fund name: " + menuName);

        String filename = menuInstance.getFundFileName(menuItem);
        System.out.println("Filename choosed: " + filename);
    }

// ########################### END MAIN ##########################################


}




