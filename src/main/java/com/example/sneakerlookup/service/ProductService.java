package com.example.sneakerlookup.service;

import com.example.sneakerlookup.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sneakerlookup.data.entity.Product;
import com.example.sneakerlookup.data.repository.ProductRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServiceIntf {
    private final ProductRepository _repo;

    @Autowired
    public ProductService(ProductRepository repo) {
        _repo = repo;
    }

    private ProductDto convertToDto(Product entity) {
        if (entity == null) return null;

        ProductDto dto = new ProductDto();
        dto.setProductId(entity.getProductId());
        dto.setStoreId(entity.getStoreId());
        dto.setStoreName(entity.getStoreName());
        dto.setWebsite(entity.getWebsite());
        dto.setAddress(entity.getAddress());
        dto.setSneakerId(entity.getSneakerId());
        dto.setShoeSize(entity.getShoeSize());
        dto.setQuantity(entity.getQuantity());
        dto.setPrice(entity.getPrice());
        dto.setReleaseDate(entity.getReleaseDate());

        return dto;
    }

    private Product convertToEntity(ProductDto dto) {
        if (dto == null) return null;

        Product entity = new Product();
        entity.setProductId(dto.getProductId());
        entity.setStoreId(dto.getStoreId());
        entity.setStoreName(dto.getStoreName());
        entity.setWebsite(dto.getWebsite());
        entity.setAddress(dto.getAddress());
        entity.setSneakerId(dto.getSneakerId());
        entity.setShoeSize(dto.getShoeSize());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        entity.setReleaseDate(dto.getReleaseDate());

        return entity;
    }

    public ProductDto getById(int id) {
        Product entity = _repo.findById(id).orElseThrow();
        ProductDto dto = convertToDto(entity);
        return dto;
    }

    public List<ProductDto> get() {
        List<Product> entityList = _repo.findAll();
        List<ProductDto> dtoList = entityList.stream().map(this::convertToDto).collect(Collectors.toList());
        return dtoList;
    }

    public List<ProductDto> getSneakersBySneakerId(int sneakerId) {
        List<Product> entityList = _repo.findBySneakerId(sneakerId);
        List<ProductDto> dtoList = entityList.stream().map(this::convertToDto).collect(Collectors.toList());
        return dtoList;
    }

    public AverageMarketValueDto getMarketPrice(int sneakerId) {
        List<Product> entityList = _repo.findBySneakerId(sneakerId);
        List<ProductDto> dtoList = entityList.stream().map(this::convertToDto).toList();

        List<BigDecimal> priceQuantityMultiplierList = dtoList.stream()
                .map(dto -> dto.getPrice().multiply(BigDecimal.valueOf(dto.getQuantity())))
                .map(value -> value.setScale(2, RoundingMode.HALF_UP))
                .toList();

        List<BigDecimal> quantityList = dtoList.stream()
                .map(dto -> BigDecimal.valueOf(dto.getQuantity()))
                .toList();

        BigDecimal sum = priceQuantityMultiplierList.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
        //System.out.println("sum for sneakerId " + sneakerId + " is calculated: " + sum);

        BigDecimal totalQuantity = quantityList.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
        //System.out.println("total quantity for sneakerId " + sneakerId + " is calculated: " + totalQuantity);

        //if sneaker isn't found in product table (which shouldn't happen), return a default market value of 200.00
        BigDecimal avg = totalQuantity.intValue() == 0 ? new BigDecimal("200.00") : sum.divide(totalQuantity, 2, RoundingMode.HALF_UP);
        //System.out.println("average market value for sneakerId " + sneakerId + " is calculated: " + avg);

        AverageMarketValueDto dto = new AverageMarketValueDto(avg.doubleValue());

        return dto;
    }

    public PostResponseDto<ProductDto> add(RequestDto<ProductDto> requestDto) {
        if (requestDto == null) return new PostResponseDto<>();

        Product entity = convertToEntity(requestDto.getData());
        if (entity == null) return new PostResponseDto<>();

        entity = _repo.save(entity);
        ProductDto dto = convertToDto(entity);

        return new PostResponseDto<>(dto, 1);
    }

    public UpdateResponseDto<ProductDto> updateQuantity(int storeId, int sneakerId, String shoeSize, int quantity) {
        System.out.printf("received store id of %s\n", storeId);
        System.out.printf("received sneaker id of %s\n", sneakerId);
        System.out.printf("received shoe size of %s\n", shoeSize);
        System.out.printf("received quantity of %s\n", quantity);

        Product entity = null;
        Optional<Product> optEntity = _repo.findByStoreIdAndSneakerIdAndShoeSize(storeId, sneakerId, shoeSize);

        if (optEntity.isPresent()) {
            entity = optEntity.get();
            entity.setQuantity(quantity);
        } else {
            entity = new Product();
            entity.setQuantity(quantity);
        }
        entity = _repo.save(entity);
        ProductDto dto = convertToDto(entity);
        return new UpdateResponseDto<>(dto, 1);
    }

    public UpdateResponseDto<ProductDto> updatePrice(int storeId, int sneakerId, String shoeSize, BigDecimal price) {
        Product entity = null;
        Optional<Product> optEntity = _repo.findByStoreIdAndSneakerIdAndShoeSize(storeId, sneakerId, shoeSize);

        if (optEntity.isPresent()) {
            entity = optEntity.get();
            entity.setPrice(price);
        } else {
            entity = new Product();
            entity.setPrice(price);
        }

        entity = _repo.save(entity);
        ProductDto dto = convertToDto(entity);
        return new UpdateResponseDto<>(dto, 1);
    }
}