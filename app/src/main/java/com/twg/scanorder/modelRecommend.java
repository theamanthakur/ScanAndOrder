package com.twg.scanorder;

public class modelRecommend {
    public String imageName;
    public String imageURL;
    public  String rating;

    public modelRecommend() {
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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

    public modelRecommend(String imageName, String imageURL, String rating) {
        this.imageName = imageName;
        this.imageURL = imageURL;
        this.rating = rating;
    }
}
