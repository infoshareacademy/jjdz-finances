package com.infoshareacademy.finances.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FUNDS")
public class FundsAssets extends AssetEntity {

    public FundsAssets() {
    }

    public FundsAssets(Asset asset) {
        super.setAsset(asset);
    }
}
