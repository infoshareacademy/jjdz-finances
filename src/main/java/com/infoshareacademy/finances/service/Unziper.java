package com.infoshareacademy.finances.service;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Do App.java wrzucić
 *
 *         Unziper unziper = new Unziper();
 *         unziper.UnzipToFolder(zipFileName, outputFolderName);
 *
 */

public class Unziper {

   // private static final String zipFileName = "Data/omegafun.zip";
   // private static final String outputFolderName = "Data/Unziped";

   // public static void main(String[] args) throws IOException {
   //    Unziper unziper = new Unziper();
   //    unziper.UnzipToFolder(zipFileName, outputFolderName);
   // }

    public void UnzipToFolder(String zipFilePath, String outputFolderPath) throws IOException {

        byte[] buffer = new byte[2048];

        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry zipWorking = zipInput.getNextEntry();

        while(zipWorking != null) {
            String outputFileName = zipWorking.getName();
            File outputFileFinal = new File(outputFolderPath + File.separator + outputFileName);
            // System.out.println("Unzipped file: " + outputFileName);

            FileOutputStream fileOutputStream = new FileOutputStream(outputFileFinal);

            for (int bufferSize = zipInput.read(buffer); bufferSize > 0; bufferSize = zipInput.read(buffer)) {
                fileOutputStream.write(buffer, 0, bufferSize);
            }

            fileOutputStream.close();
            zipWorking = zipInput.getNextEntry();
        }

        zipInput.closeEntry();
        zipInput.close();

        // System.out.println("Tadaaa");

    }
}



