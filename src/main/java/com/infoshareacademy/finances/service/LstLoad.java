package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.LstList;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LstLoad {
    private List<String> fundsList = new ArrayList();
    private List<String> fundsFile = new ArrayList();


    public List<String> getFundsList() {
        return fundsList;
    }

    public List<String> getFundsFile() {
        return fundsFile;
    }

    public int loadFunds(String ResourceFile) throws IOException {
        int count = 1;
        String line = "";

        String patternString = "(?<date>^\\S+)(\\s{2,})(?<time>\\S+)(\\s{2,})(?<size>\\S+{2,}).(?<unit>\\S+)(\\s{2,})(?<file>\\S+)(\\s{2,})(?<fund>.*$)";
        Pattern pattern = Pattern.compile(patternString);

        System.out.println("Loading: " + ResourceFile);

        LstLoad obj = new LstLoad();
        String StringBlock = (obj.getResourceFile("/omegafun.lst"));

        try (BufferedReader reader = new BufferedReader(new StringReader(StringBlock))) {
            for (int skip = 0; skip < 3; skip++) {
                line = reader.readLine();
            }

            line = reader.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String file = matcher.group("file");
                    String fund = matcher.group("fund");
                    fundsList.add(fund);
                    fundsFile.add(file);
                    count++;
                }
                line = reader.readLine();
            }
        } catch (IOException exc) {
            // quit
        }
        return count - 1;
    }


    private String getResourceFile(String fileName) {

        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<LstList> LstList() {
        int sizeFundList = fundsList.size();
        List<LstList> FundLists = new ArrayList<LstList>();

        for (int i = 0; i < sizeFundList; i++) {
            LstList obj = new LstList(fundsList.get(i), fundsFile.get(i));
            FundLists.add(obj);
        }
        System.out.println("LstLoad: Loaded rows:" + FundLists.size());
        return FundLists;
    }

    public String getFundName(Integer FundIndex) {
        return fundsList.get(FundIndex);
    }

    public String getFundFileName(Integer FundIndex) {
        return fundsFile.get(FundIndex);
    }

    public LocalDate askForDate() throws ParseException {
        int year, month;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter year Asset to calculations (YYYY): ");
        year = input.nextInt();
        System.out.print("Enter month Asset to calculations (MM): ");
        month = input.nextInt();

        // DateFormat format = new SimpleDateFormat("YYYY-MM");
        // LocalDate localDate = LocalDate.parse(answer, DateTimeFormatter.BASIC_ISO_DATE);

        LocalDate localDate = LocalDate.now().withYear(year).withMonth(month);
        return localDate;
    }


}
