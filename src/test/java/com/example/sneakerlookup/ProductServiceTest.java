package com.example.sneakerlookup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;
import java.sql.Date;

import com.example.sneakerlookup.data.entity.Product;
import com.example.sneakerlookup.data.repository.ProductRepository;
import com.example.sneakerlookup.dto.ProductDto;
import com.example.sneakerlookup.dto.UpdateResponseDto;
import com.example.sneakerlookup.service.ProductService;
import com.example.sneakerlookup.service.ProductServiceIntf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductServiceTest {

    private ProductRepository _productRepositoryMock;
    private Product _entity;
    private ProductDto _dto;
    public static final int PRODUCT_ID = 21;
    public static final int STORE_ID = 2345;

    @BeforeEach
    public void setup() {
        _entity = new Product();
        _entity.setProductId(PRODUCT_ID);
        _entity.setStoreId(STORE_ID);
        _entity.setStoreName("Nike");
        _entity.setWebsite("www.nike.com");
        _entity.setAddress("123 Trainer Ave Stupidville, Oregon, USA 98765");
        _entity.setSneakerId(420);
        _entity.setShoeSize("8.5");
        _entity.setQuantity(10000);
        _entity.setPrice(new BigDecimal("160.00"));
        _entity.setReleaseDate(Date.valueOf("2016-09-03").toLocalDate());

        _dto = new ProductDto();
        _dto.setProductId(PRODUCT_ID);
        _dto.setStoreId(STORE_ID);
        _dto.setStoreName("Nike");
        _dto.setWebsite("www.nike.com");
        _dto.setAddress("123 Trainer Ave Stupidville, Oregon, USA 98765");
        _dto.setSneakerId(420);
        _dto.setShoeSize("8.5");
        _dto.setQuantity(10000);
        _dto.setPrice(new BigDecimal("160.00"));
        _dto.setReleaseDate(Date.valueOf("2016-09-03").toLocalDate());

        _productRepositoryMock = mock(ProductRepository.class);
        when(_productRepositoryMock.save(isA(Product.class))).thenReturn(_entity);
    }

    @Test
    public void updateQuantity_Test() {
        when(_productRepositoryMock.findByStoreIdAndSneakerIdAndShoeSize(STORE_ID, 420, "8.5"))
                .thenReturn(Optional.ofNullable(_entity));

        _dto.setQuantity(6999);

        ProductServiceIntf service = new ProductService(_productRepositoryMock);
        UpdateResponseDto<ProductDto> result = service.updateQuantity(STORE_ID, 420,"8.5", 6999);
        assertEquals(_dto.getProductId(), result.getData().getProductId());
        assertEquals(_dto.getStoreId(), result.getData().getStoreId());
        assertEquals(_dto.getStoreName(), result.getData().getStoreName());
        assertEquals(_dto.getWebsite(), result.getData().getWebsite());
        assertEquals(_dto.getAddress(), result.getData().getAddress());
        assertEquals(_dto.getSneakerId(), result.getData().getSneakerId());
        assertEquals(_dto.getShoeSize(), result.getData().getShoeSize());
        assertEquals(_dto.getQuantity(), result.getData().getQuantity());
        assertEquals(_dto.getPrice(), result.getData().getPrice());
        assertEquals(_dto.getReleaseDate(), result.getData().getReleaseDate());

    }

    @Test
    public void updatePrice_Test() {
        when(_productRepositoryMock.findByStoreIdAndSneakerIdAndShoeSize(STORE_ID, 420, "8.5"))
                .thenReturn(Optional.ofNullable(_entity));

        _dto.setPrice(new BigDecimal("349.99"));

        ProductServiceIntf service = new ProductService(_productRepositoryMock);
        UpdateResponseDto<ProductDto> result = service.updatePrice(STORE_ID, 420,"8.5", new BigDecimal("349.99"));
        assertEquals(_dto.getProductId(), result.getData().getProductId());
        assertEquals(_dto.getStoreId(), result.getData().getStoreId());
        assertEquals(_dto.getStoreName(), result.getData().getStoreName());
        assertEquals(_dto.getWebsite(), result.getData().getWebsite());
        assertEquals(_dto.getAddress(), result.getData().getAddress());
        assertEquals(_dto.getSneakerId(), result.getData().getSneakerId());
        assertEquals(_dto.getShoeSize(), result.getData().getShoeSize());
        assertEquals(_dto.getQuantity(), result.getData().getQuantity());
        assertEquals(_dto.getPrice(), result.getData().getPrice());
        assertEquals(_dto.getReleaseDate(), result.getData().getReleaseDate());

    }

}

