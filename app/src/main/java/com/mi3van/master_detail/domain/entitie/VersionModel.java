package com.mi3van.master_detail.domain.entitie;

/**
 * Created by Ivan Kuzmin on 2019-10-30;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public class VersionModel {
    private int id;
    private float version;
    private String name;
    private String released;
    private int api;
    private float distribution;
    private boolean isFavourite;
    private String description;

    public VersionModel(int id, float version, String name, String released, int api, float distribution, boolean isFavourite, String description) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.released = released;
        this.api = api;
        this.distribution = distribution;
        this.isFavourite = isFavourite;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public int getApi() {
        return api;
    }

    public void setApi(int api) {
        this.api = api;
    }

    public float getDistribution() {
        return distribution;
    }

    public void setDistribution(float distribution) {
        this.distribution = distribution;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
