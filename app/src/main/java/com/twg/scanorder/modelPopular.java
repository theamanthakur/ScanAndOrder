package com.twg.scanorder;

public class modelPopular {
    public String imageName;
    public String resName;

    public String imageURL;
    public  String rating;

    public modelPopular() {
    }

    public  String price;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public modelPopular(String imageName, String resName, String imageURL, String rating, String price) {
        this.imageName = imageName;
        this.resName = resName;
        this.imageURL = imageURL;
        this.rating = rating;
        this.price = price;
    }
}
