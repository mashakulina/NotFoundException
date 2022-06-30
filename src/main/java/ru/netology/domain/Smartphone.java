package ru.netology.domain;

public class Smartphone extends Product {
    protected String manufacturer;

    public Smartphone(int id, String name, String manufacturer, int price) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
}
