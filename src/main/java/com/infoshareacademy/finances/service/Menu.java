package com.infoshareacademy.finances.service;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    private static String fundName;
    private static String fundFile;

    public static class Funds {
        private String fundname;
        private String filename;

        public Funds(String fundname, String filename) {

            this.fundname = fundname;
            this.filename = filename;
        }

        public String getFund() {
            return fundname;
        }

        public String getFile() {
            return filename;
        }


        @Override
        public String toString() {
            return fundname + ";" + filename;
        }

    }
// ########################### MAIN #############################################

    public static void main(String[] argv) throws Exception {
        // Open file from argument line (ex. Data/omegafun.lst)

        String lstFile = argv[0];
        // System.out.println("lstFile = [" + lstFile + "]");

        Integer FundsCount = LoadFunds(lstFile);
        Integer menuItem = drawMenu();
        String filename = getFundFileName(menuItem);
    }

// ########################### MAIN #############################################

    public static Integer LoadFunds(String lstFile) throws IOException {
        String line;
        int count = 1;
        int skip = 3;

        String patternString = "(?<date>(^\\S+))(\\s{2,})(?<time>(\\S+))(\\s{2,})(?<size>(\\S+{2,}))(.)(?<unit>(\\S+))(\\s{2,})(?<file>(\\S+))(\\s{2,})(?<fund>(.*$))";
        Pattern pattern = Pattern.compile(patternString);

        InputStream fis = new FileInputStream(lstFile);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        while (skip != 0) {
            line = br.readLine();
            //     System.out.println(skip + ": " + "skipping: " + line);
            skip = skip - 1;
        }
        while ((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {

                //todo load to list


/*                String date = matcher.group("date");
                String time = matcher.group("time");
                String size = matcher.group("size");
                String unit = matcher.group("unit");
                String file = matcher.group("file");
                String fund = matcher.group("fund");

                System.out.println(count + ": " + fund);*/

                count++;
            }
        }
        return count - 1;
    }


    private static Integer drawMenu() {
        //todo
        // sizefundList = List.size()
        int sizeFundList = 262;


        Scanner input = new Scanner(System.in);
        System.out.print("Enter Fund to calculations (1-" + sizeFundList + "): ");
        int fundNR = input.nextInt();
        System.out.println("Fund choosed: " + fundNR);
        return fundNR;
    }

    private static String getFundFileName(Integer FundIndex) {
        //todo serch list using index

        return "AAAA.txt";
    }

}




