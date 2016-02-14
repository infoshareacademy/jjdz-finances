package com.infoshareacademy.finances;


import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import com.infoshareacademy.finances.service.FundDataLoader;
import com.infoshareacademy.finances.service.Unziper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App
{
    public static void main( String[] args ) throws Exception {
        System.out.println("Financial analyser 1.0");
        if (args.length != 0) {
            String zipPath = args[0];
            String extractionPath = args[1];
            String fundCode = args[3];
            List<DailyValue> dailyValues;

            Unziper unziper = new Unziper();
            unziper.UnzipToFolder(zipPath,extractionPath);

            FundDataLoader loader = new FundDataLoader();
            dailyValues = loader.loadDataFromFile(extractionPath);

            Fund fund = new Fund(dailyValues,fundCode,fundCode);

        } else {
            System.out.println("Enter arguments:");
            System.out.println("<program_name> <path to fund zip file> <path extract files> <fund ID>");
            System.out.println("example: path_to/omefafun.zip path/ AGI001");
            System.exit(0);
        }

    }
}
