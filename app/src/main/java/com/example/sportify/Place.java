package com.example.sportify;

public class Place {
    private long id;
    private int imageResId;
    private String title;
    private String description;
    private String price;

    public Place(long id, int imageResId, String title, String description, String price) {
        this.id = id;
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
        this.price=price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}




