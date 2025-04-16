package com.example.sneakerlookup.dto;

public class AverageMarketValueDto {
    private double avgMarketValue;

    public AverageMarketValueDto(double avgMarketValue) {
        this.avgMarketValue = avgMarketValue;
    }

    public double getMarketValue() {
        return avgMarketValue;
    }

    public void setMarketValue(double avgMarketValue) {
        this.avgMarketValue = avgMarketValue;
    }
}
