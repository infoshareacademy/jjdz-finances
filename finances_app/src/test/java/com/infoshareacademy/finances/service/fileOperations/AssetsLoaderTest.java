package com.infoshareacademy.finances.service.fileOperations;


import com.infoshareacademy.finances.entity.Asset;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;


import static org.junit.Assert.*;

public class AssetsLoaderTest {

    @Test
    public void testLoadFundFromFile() throws Exception {
        //given
        String fileName = "omegafun.lst";
        String code = "SEB001";
        String name = "NOVO Zrownowazonego Wzrostu";
        Asset expected = new Asset(name,code);

        //when
        List<Asset> assets = new AssetsLoader().readAssetsFromFile(fileName);

        //then
        assertThat(assets.get(1).getCode(), Matchers.equalTo(expected.getCode()));
        assertThat(assets.get(1).getName(), Matchers.equalTo(expected.getName()));
    }

    @Test
    public void testLoadCurrencyFromFile() throws Exception {
        //given
        String fileName = "omeganbp.lst";
        String code = "CAD";
        String name = "dolar kanadyjski";
        Asset expected = new Asset(name,code);

        //when
        List<Asset> assets = new AssetsLoader().readAssetsFromFile(fileName);

        //then
        assertThat(assets.get(3).getCode(), Matchers.equalTo(expected.getCode()));
        assertThat(assets.get(3).getName(), Matchers.equalTo(expected.getName()));
    }

}
