package com.example.sneakerlookup.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.sneakerlookup.dto.*;

public interface ProductServiceIntf {
    ProductDto getById(int id);
    List<ProductDto> get();
    List<ProductDto> getSneakersBySneakerId(int sneakerId);
    AverageMarketValueDto getMarketPrice(int sneakerId);
    PostResponseDto<ProductDto> add(RequestDto<ProductDto> requestDto);
    UpdateResponseDto<ProductDto> updateQuantity(int storeId, int sneakerId, String shoeSize, int quantity);
    UpdateResponseDto<ProductDto> updatePrice(int storeId, int sneakerId, String shoeSize, BigDecimal price);

}