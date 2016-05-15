package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.Asset;

import java.io.IOException;
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


public class AssetsLoader {
    public List<Asset> readAssetsFromFile(String filePath) {
        if (!filePath.contains("/"))
            filePath = "/" + filePath;

        List<Asset> codeAndAsset = new ArrayList<>();

        try {
            URL u = getClass().getResource(filePath);
            Path path = Paths.get(u.toURI());

            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

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
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return codeAndAsset;
    }


}