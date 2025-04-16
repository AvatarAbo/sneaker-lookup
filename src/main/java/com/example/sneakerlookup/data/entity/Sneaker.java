package com.example.sneakerlookup.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sneaker")
public class Sneaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sneakerId")
    private Integer sneakerId;

    @Column(name = "year")
    private Integer year;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "colorWay")
    private String colorWay;

    @Column(name = "type")
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