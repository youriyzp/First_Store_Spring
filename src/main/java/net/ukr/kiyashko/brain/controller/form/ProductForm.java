package net.ukr.kiyashko.brain.controller.form;

import net.ukr.kiyashko.brain.model.enums.UnitEnum;

public class ProductForm {

    private Long id;
    private String name_product;
    private double price;
    private UnitEnum unit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }
}