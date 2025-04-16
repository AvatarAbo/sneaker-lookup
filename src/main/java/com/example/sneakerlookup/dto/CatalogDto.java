package com.example.sneakerlookup.dto;

import java.math.BigDecimal;

public class CatalogDto {

    private Integer catalogId;

    private Integer sneakerId;

    private String shoeSize;

    private Integer yearAcquired;

    private String condition;

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

