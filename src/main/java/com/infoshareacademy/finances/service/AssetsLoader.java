package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.Asset;

import javax.ejb.Stateless;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.apache.commons.io.IOUtils;

public class AssetsLoader {
    public List<Asset> readAssetsFromFile(String filePath) {
        List<Asset> codeAndAsset = new ArrayList<>();

       try {
		   InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath);
		   List<String> lines = IOUtils.readLines(resourceAsStream, StandardCharsets.UTF_8);

            Predicate<String> predicate = (s) -> !s.contains("txt");
            lines.removeIf(predicate);

            for (String line : lines){
                String[] fields = line.split("\\s{2,}+");
                String code = fields[3].substring(0, fields[3].indexOf("."));
                String name = fields[4];

                codeAndAsset.add(new Asset(name, code));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return codeAndAsset;
    }
}