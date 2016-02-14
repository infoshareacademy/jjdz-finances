package com.infoshareacademy.finances;


import com.infoshareacademy.finances.model.Fund;
import com.infoshareacademy.finances.service.FundDataLoader;
import com.infoshareacademy.finances.service.Unziper;

import java.util.Optional;

public class App
{
    public static void main( String[] args ) throws Exception {
        System.out.println("Financial analyser 1.0");
        if (args.length != 0) {
            String zipPath = args[0];
            String extractionPath = args[1];
            String fundCode = args[3];

            Unziper unziper = new Unziper();
            unziper.UnzipToFolder(zipPath,extractionPath);

            Fund fund = new Fund();

            fund.setName(fundCode);
            fund.setCode(fundCode);

            FundDataLoader loader = new FundDataLoader();
            loader.loadDataFromFile(extractionPath, Optional.of(fund));


        } else {
            System.out.println("Enter arguments:");
            System.out.println("<program_name> <path to fund zip file> <path extract files> <fund ID>");
            System.out.println("example: path_to/omefafun.zip path/ AGI001");
            System.exit(0);
        }

    }
}
