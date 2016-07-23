package com.infoshareacademy.finances.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostnameDetector {

    public String getFinancesServerURL() {

        InetAddress ip;
        String hostname = "";

        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        if (hostname.toLowerCase().contains("rhcloud.com")) {
            return "http://www-jjdzfinances.rhcloud.com";
        } else {
            return "http://localhost:8080";
        }
    }

    public String getReportServerURL() {

        InetAddress ip;
        String hostname = "";

        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (hostname.toLowerCase().contains("rhcloud.com")) {
            return "http://report-jjdzfinances.rhcloud.com";
        } else {
            return "http://localhost:8082";
        }
    }
}
