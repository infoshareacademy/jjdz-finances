package com.infoshareacademy.finances.model;

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
