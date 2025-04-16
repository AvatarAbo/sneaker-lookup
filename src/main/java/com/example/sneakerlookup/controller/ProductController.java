package com.example.sneakerlookup.controller;

import com.example.sneakerlookup.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.sneakerlookup.service.ProductServiceIntf;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api/product")
public class ProductController {
    private final ProductServiceIntf _service;

    @Autowired
    public ProductController(ProductServiceIntf service) {
        _service = service;
    }

    @GetMapping("")
    public GetResponseDto<ProductDto> get() throws Exception {
        List<ProductDto> dtoList = _service.get();
        GetResponseDto<ProductDto> responseDto = new GetResponseDto<>(dtoList);
        return responseDto;
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable("id") int id) throws Exception {
        ProductDto dto = _service.getById(id);
        return dto;
    }

    @GetMapping("/getProducts")
    public GetResponseDto<ProductDto> getProductsBySneakerId(@RequestParam(value = "sneakerId") int sneakerId)
            throws Exception {
        List<ProductDto> dtoList = _service.getSneakersBySneakerId(sneakerId);
        GetResponseDto<ProductDto> response = new GetResponseDto<>(dtoList);
        return response;
    }

    @PostMapping("")
    public PostResponseDto<ProductDto> add(@RequestBody RequestDto<ProductDto> dto) {
        PostResponseDto<ProductDto> responseDto = _service.add(dto);
        return responseDto;
    }

    @PatchMapping("/updateQuantity/{storeId}/{sneakerId}/{shoeSize}/{quantity}")
    public UpdateResponseDto<ProductDto> update(@PathVariable("storeId") int storeId,
                                                @PathVariable("sneakerId") int sneakerId,
                                                @PathVariable("shoeSize") String shoeSize,
                                                @PathVariable("quantity") int quantity) {
        UpdateResponseDto<ProductDto> responseDto = _service.updateQuantity(storeId, sneakerId, shoeSize, quantity);
        return responseDto;
    }

    @PatchMapping("/updatePrice/{storeId}/{sneakerId}/{shoeSize}/{price}")
    public UpdateResponseDto<ProductDto> update(@PathVariable("storeId") int storeId,
                                                @PathVariable("sneakerId") int sneakerId,
                                                @PathVariable("shoeSize") String shoeSize,
                                                @PathVariable("price") BigDecimal price) {
        UpdateResponseDto<ProductDto> responseDto = _service.updatePrice(storeId, sneakerId, shoeSize, price);
        return responseDto;
    }

    @GetMapping("/getMarketPrice/{sneakerId}")
    public AverageMarketValueDto getMarketPrice(@PathVariable(value = "sneakerId") int sneakerId)
            throws Exception {
        AverageMarketValueDto responseDto = _service.getMarketPrice(sneakerId);
        return responseDto;
    }
}

