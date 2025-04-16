package com.example.sneakerlookup.data.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalogId")
    private Integer catalogId;

    @Column(name = "sneakerId")
    private Integer sneakerId;

    @Column(name = "shoeSize")
    private String shoeSize;

    @Column(name = "yearAcquired")
    private Integer yearAcquired;

    @Column(name = "condition")
    private String condition;

    @Column(name = "marketValue")
    private BigDecimal marketValue;



    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getSneakerId() {
        return sneakerId;
    }

    public void setSneakerId(Integer sneakerId) {
        this.sneakerId = sneakerId;
    }

    public String getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(String shoeSize) {
        this.shoeSize = shoeSize;
    }

    public Integer getYearAcquired() {
        return yearAcquired;
    }

    public void setYearAcquired(Integer yearAcquired) {
        this.yearAcquired = yearAcquired;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

}

