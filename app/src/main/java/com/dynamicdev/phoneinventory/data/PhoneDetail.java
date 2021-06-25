package com.dynamicdev.phoneinventory.data;

public class PhoneDetail {
    public enum Manufacture {
        APPLE,
        SAMSUNG,
        GOOGLE


    }
    private String model;
    private int year;
    private int price;
    private Manufacture manufacture;
    private int phone_id;

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public int getPhone_id() {
        return phone_id;
    }

    public PhoneDetail(String model, int year, int price, Manufacture manufacture) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.manufacture = manufacture;
    }

    public PhoneDetail(String model, int year, int price, Manufacture manufacture, int phone_id) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.manufacture = manufacture;
        this.phone_id = phone_id;
    }
}
