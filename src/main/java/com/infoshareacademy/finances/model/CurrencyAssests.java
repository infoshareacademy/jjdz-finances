package com.infoshareacademy.finances.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CURRENCY")
public class CurrencyAssests extends AssetEntity {

    public CurrencyAssests() {
    }

    public CurrencyAssests(Asset asset) {
        super.setAsset(asset);
    }
}
