package com.infoshareacademy.finances.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CURRENCY")
public class CurrencyAssets extends AssetEntity {

    public CurrencyAssets() {
    }

    public CurrencyAssets(Asset asset) {
        super.setAsset(asset);
    }
}
