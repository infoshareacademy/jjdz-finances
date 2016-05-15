package com.infoshareacademy.finances.model;

public class LstList {

    private String FundName;
    private String FundFile;

    @Override
    public String toString() {
        return "LstList{" +
                "FundName='" + FundName + '\'' +
                ", FundFile='" + FundFile + '\'' +
                '}';
    }

    public LstList(String FundName, String FundFile) {
        this.FundName = FundName;
        this.FundFile = FundFile;
    }

    public String getFundName() {
        return FundName;
    }

    public void setFundName(String fundName) {
        FundName = fundName;
    }

    public String getFundFile() {
        return FundFile;
    }

    public void setFundFile(String fundFile) {
        FundFile = fundFile;
    }


}
