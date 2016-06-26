package com.infoshareacademy.finances.entity;

import javax.persistence.*;

import com.infoshareacademy.finances.entity.Asset;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Asset asset;

    public AssetEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

	@Override
	public String toString() {
		return "AssetEntity{" +
				"id=" + id +
				", asset=" + asset +
				'}';
	}
}

