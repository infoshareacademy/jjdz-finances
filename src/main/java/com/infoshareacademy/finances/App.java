package com.infoshareacademy.finances;


public class App {
    public static void main(String[] args) throws Exception {
        //todo remove parametry:
        // /home/$user/workspace/jjdz-finances/Data/omegafun.zip  /home/$user/workspace/jjdz-finances/Data/omegafun.lst /tmp/Data
/*
        System.out.println("Financial analyser 1.0");
        if ((args != null) && (args.length == 3)) {

            String zipPath = args[0];
            String extractionPath = args[2];

            LstLoad menuInstance = new LstLoad(args[1]);

            // Load Funds from lst
            Integer FundsCount = menuInstance.loadFunds();

            // display Funds
            Integer menuItem = menuInstance.drawMenu();
            System.out.printf("Choosed asset: %d %n", menuItem);

            // get asset name
            String menuName = menuInstance.getFundName(menuItem);

            //get asset filename
            String filename = menuInstance.getFundFileName(menuItem);
            System.out.println("Asset name: " + menuName + " (" + filename + ")");



            String fundCode = extractionPath + "/" + filename;

            List<DailyValue> dailyValues;

            Unziper unziper = new Unziper();
            unziper.UnzipToFolder(zipPath, extractionPath);

            DataLoader loader = new DataLoader();
            dailyValues = loader.loadDataFromFile(fundCode);

            Asset asset = new Asset(dailyValues, menuName, filename);
            MonthViewer monthViewer = new MonthViewer(System.out);
            monthViewer.showAvailableMonths(asset);

            LocalDate localDate = menuInstance.askForDate();
            MonthlyExtremeFinder monthlyExtremeFinder = new MonthlyExtremeFinder(localDate, asset.getDailyValues());

            YearDataViewer yearDataViewer = new YearDataViewer();
            System.out.println("Yearly Max value: " + yearDataViewer.yearMaxValues(asset.getDailyValues(),localDate.getYear()));
            System.out.println("Yearly Min value: " + yearDataViewer.yearMinValues(asset.getDailyValues(),localDate.getYear()));

            System.out.println("Monthly Max value: " + monthlyExtremeFinder.findMaxDailyValues());
            System.out.println("Monthly Min value: " + monthlyExtremeFinder.findMinDailyValues());

            System.out.println("Done.");



        } else {
            System.out.println("Enter arguments:");
            System.out.println("<program_name> <zip file> <lst file> <path to extract files>");
            System.out.println("example: path_to/omefafun.zip path_to/omegafun.lst /tmp/Data");
            System.exit(0);
        }*/

    }
}
