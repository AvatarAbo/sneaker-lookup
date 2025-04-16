package com.example.sneakerlookup.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.sneakerlookup.dto.PostResponseDto;
import com.example.sneakerlookup.dto.SneakerDto;
import com.example.sneakerlookup.dto.RequestDto;

public interface SneakerServiceIntf {
    //async methods used for educational purposes
    CompletableFuture<SneakerDto> getById(int id);
    CompletableFuture<List<SneakerDto>> get();
    List<SneakerDto> getByBrand(String brand);
    List<SneakerDto> getByBrandAndModel(String brand, String model);
    List<SneakerDto> getByBrandAndModelAndColorWay(String brand, String model, String colorWay);
    SneakerDto getByYearAndBrandAndModelAndColorWay(int year, String brand, String model, String colorWay);
    PostResponseDto<SneakerDto> add(RequestDto<SneakerDto> requestDto);
}
