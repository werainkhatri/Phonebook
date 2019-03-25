package com.applications.werainkhatri.phonebook;

public class Data {
    private String name;
    private String number;
    private String image;

    public Data(String name, String number, String image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getImage() {
        return image;
    }
}
