package com.infoshareacademy.finances;


import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import com.infoshareacademy.finances.service.*;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //todo remove parametry:
        // /home/$user/workspace/jjdz-finances/Data/omegafun.zip  /home/$user/workspace/jjdz-finances/Data/omegafun.lst /tmp/Data

        System.out.println("Financial analyser 1.0");
        if ((args != null) && (args.length == 3)) {

            String zipPath = args[0];
            String extractionPath = args[2];

            Menu menuInstance = new Menu();

            // Load Funds from lst
            Integer FundsCount = menuInstance.loadFunds(args[1]);

            // display Funds
            Integer menuItem = menuInstance.drawMenu();
            System.out.println("Fund choosed: " + menuItem);

            // get fund name
            String menuName = menuInstance.getFundName(menuItem);
            System.out.println("Fund name: " + menuName);


            //get fund filename
            String filename = menuInstance.getFundFileName(menuItem);
            System.out.println("Filename choosed: " + filename);
            String fundCode = extractionPath + "/" + filename;
            System.out.println("FundCode: " + fundCode);

            List<DailyValue> dailyValues;

            Unziper unziper = new Unziper();
            unziper.UnzipToFolder(zipPath, extractionPath);

            FundDataLoader loader = new FundDataLoader();
            dailyValues = loader.loadDataFromFile(fundCode);

            Fund fund = new Fund(dailyValues, menuName, filename);
            FundMonthViewer fundMonthViewer = new FundMonthViewer(System.out);
            fundMonthViewer.showAvailableMonths(fund);

            LocalDate localDate = menuInstance.askForDate();
            MonthlyExtremeFinder monthlyExtremeFinder = new MonthlyExtremeFinder(localDate,fund.getDailyValues());

            FundYearDataViewer fundYearDataViewer = new FundYearDataViewer();
            System.out.println("Year Max values: " + fundYearDataViewer.yearMaxValues(fund.getDailyValues(),localDate.getYear()));
            System.out.println("Year Min values: " + fundYearDataViewer.yearMinValues(fund.getDailyValues(),localDate.getYear()));

            System.out.println("Max value was: " + monthlyExtremeFinder.findMaxDailyValues());
            System.out.println("Min value was: " + monthlyExtremeFinder.findMinDailyValues());


        } else {
            System.out.println("Enter arguments:");
            System.out.println("<program_name> <zip file> <lst file> <path to extract files>");
            System.out.println("example: path_to/omefafun.zip path_to/omegafun.lst /tmp/Data");
            System.exit(0);
        }

    }
}
