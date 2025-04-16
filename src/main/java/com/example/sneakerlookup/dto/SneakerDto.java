package com.example.sneakerlookup.dto;

public class SneakerDto {

    private Integer sneakerId;

    private Integer year;

    private String brand;

    private String model;

    private String colorWay;

    private String type;



    public Integer getSneakerId() {
        return sneakerId;
    }

    public void setSneakerId(Integer sneakerId) {
        this.sneakerId = sneakerId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColorWay() {
        return colorWay;
    }

    public void setColorway(String colorWay) {
        this.colorWay = colorWay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
