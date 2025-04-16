package com.example.sneakerlookup;

import com.example.sneakerlookup.dto.RequestDto;
import com.example.sneakerlookup.service.CatalogService;
import com.example.sneakerlookup.service.CatalogServiceIntf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.sneakerlookup.data.entity.Catalog;
import com.example.sneakerlookup.data.repository.CatalogRepository;
import com.example.sneakerlookup.dto.CatalogDto;
import com.example.sneakerlookup.dto.UpdateResponseDto;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatalogServiceTest {
    private CatalogRepository _catalogRepositoryMock;
    private Catalog _entity;
    private CatalogDto _dto;
    public static final int CATALOG_ID = 69;

    @BeforeEach
    public void setup() {
        _entity = new Catalog();
        _entity.setCatalogId(CATALOG_ID);
        _entity.setSneakerId(420);
        _entity.setShoeSize("8.5");
        _entity.setYearAcquired(2017);
        _entity.setCondition("GOOD");
        _entity.setMarketValue(new BigDecimal("96.00"));

        _dto = new CatalogDto();
        _dto.setCatalogId(CATALOG_ID);
        _dto.setSneakerId(420);
        _dto.setShoeSize("8.5");
        _dto.setYearAcquired(2017);
        _dto.setCondition("GOOD");
        _dto.setMarketValue(new BigDecimal("96.00"));

        _catalogRepositoryMock = mock(CatalogRepository.class);
        when(_catalogRepositoryMock.save(isA(Catalog.class))).thenReturn(_entity);
    }

    @Test
    public void updateCondition_Test() {
        when(_catalogRepositoryMock.findById(CATALOG_ID)).thenReturn(Optional.ofNullable(_entity));
        CatalogServiceIntf service = new CatalogService(_catalogRepositoryMock);

        RequestDto<CatalogDto> dto = new RequestDto<>();
        _dto.setMarketValue(new BigDecimal("225.00"));
        dto.setData(_dto);

        UpdateResponseDto<CatalogDto> result = service.update(dto);

        assertEquals(_dto.getCatalogId(), result.getData().getCatalogId());
        assertEquals(_dto.getSneakerId(), result.getData().getSneakerId());
        assertEquals(_dto.getShoeSize(), result.getData().getShoeSize());
        assertEquals(_dto.getYearAcquired(), result.getData().getYearAcquired());
        assertEquals(_dto.getCondition(), result.getData().getCondition());
        assertEquals(_dto.getMarketValue(), result.getData().getMarketValue());
    }
}
