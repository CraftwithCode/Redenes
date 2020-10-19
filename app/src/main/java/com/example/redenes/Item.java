package com.example.redenes;

public class Item {
    int image;
    int alt_image;
    String text;

    Item(int image, int alt_image) {
        this.image = image;
        this.alt_image = alt_image;
    }
    Item(int image, int alt_image, String text) {
        this.image = image;
        this.alt_image = alt_image;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

    public int getAlt_image() {
        return alt_image;
    }
}
