package com.example.android.navigationpatternlistdetail.model;

import static android.R.attr.id;

/**
 * Created by Tanaskovic on 3/30/2018.
 */

public class Item {

    private String name;
    private String description;
    private String image;

    public Item() {
    }

    public Item( String name, String description, String image) {

        this.name = name;
        this.description = description;
        this.image = image;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
