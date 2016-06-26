package com.infoshareacademy.finances.service.fileOperations;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unziper {

    public void UnzipToFolder(String zipFilePath, String outputFolderPath) throws IOException {

        byte[] buffer = new byte[2048];

        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry zipWorking = zipInput.getNextEntry();

        while(zipWorking != null) {
            String outputFileName = zipWorking.getName();
            File outputFileFinal = new File(outputFolderPath + File.separator + outputFileName);

            FileOutputStream fileOutputStream = new FileOutputStream(outputFileFinal);

            for (int bufferSize = zipInput.read(buffer); bufferSize > 0; bufferSize = zipInput.read(buffer)) {
                fileOutputStream.write(buffer, 0, bufferSize);
            }

            fileOutputStream.close();
            zipWorking = zipInput.getNextEntry();
        }

        zipInput.closeEntry();
        zipInput.close();

    }
}



