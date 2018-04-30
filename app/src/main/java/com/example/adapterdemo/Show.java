package com.example.adapterdemo;

public class Show {
    String showName;
    String publisher;
    float rating;

    public Show(String showName, String publisher, float rating) {
        this.showName = showName;
        this.publisher = publisher;
        this.rating = rating;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
