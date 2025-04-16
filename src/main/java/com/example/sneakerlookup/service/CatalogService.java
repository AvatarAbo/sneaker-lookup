package com.example.sneakerlookup.service;

import com.example.sneakerlookup.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sneakerlookup.data.entity.Catalog;
import com.example.sneakerlookup.data.repository.CatalogRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogService implements CatalogServiceIntf{
    private final CatalogRepository _repo;

    @Autowired
    public CatalogService(CatalogRepository repo) {
        _repo = repo;
    }

    private CatalogDto convertToDto(Catalog entity) {
        if (entity == null) return null;

        CatalogDto dto = new CatalogDto();
        dto.setCatalogId(entity.getCatalogId());
        dto.setSneakerId(entity.getSneakerId());
        dto.setShoeSize(entity.getShoeSize());
        dto.setYearAcquired(entity.getYearAcquired());
        dto.setCondition(entity.getCondition());
        dto.setMarketValue(entity.getMarketValue());

        return dto;
    }

    private Catalog convertToEntity(CatalogDto dto) {
        if (dto == null) return null;

        Catalog entity = new Catalog();
        entity.setCatalogId(dto.getCatalogId());
        entity.setSneakerId(dto.getSneakerId());
        entity.setShoeSize(dto.getShoeSize());
        entity.setYearAcquired(dto.getYearAcquired());
        entity.setCondition(dto.getCondition());
        entity.setMarketValue(dto.getMarketValue());

        return entity;
    }

    public CatalogDto getById(int id) {
        Catalog entity = _repo.findById(id).orElseThrow();
        CatalogDto dto = convertToDto(entity);
        return dto;
    }

    public List<CatalogDto> get() {
        List<Catalog> entityList = _repo.findAll();
        List<CatalogDto> dtoList = entityList.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
        return dtoList;
    }

    public List<CatalogDto> getBySneakerId(int sneakerId) {
        List<Catalog> entityList = _repo.findBySneakerId(sneakerId);
        List<CatalogDto> dtoList = entityList.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
        return dtoList;
    }

    public PostResponseDto<CatalogDto> add(RequestDto<CatalogDto> requestDto) {
        if (requestDto == null) return new PostResponseDto<>();

        Catalog entity = convertToEntity(requestDto.getData());
        if (entity == null) return new PostResponseDto<>();

        entity = _repo.save(entity);
        CatalogDto dto = convertToDto(entity);
        return new PostResponseDto<>(dto, 1);
    }

    public UpdateResponseDto<CatalogDto> update(RequestDto<CatalogDto> requestDto) {
        Catalog entityFromFrontend = convertToEntity(requestDto.getData());
        Catalog entityInBackend = null;
        Optional<Catalog> optEntity = _repo.findById(entityFromFrontend.getCatalogId());

        if (optEntity.isPresent())
        {
            try {
                entityInBackend = optEntity.get();
                entityInBackend.setShoeSize(entityFromFrontend.getShoeSize());
                entityInBackend.setYearAcquired(entityFromFrontend.getYearAcquired());
                entityInBackend.setCondition(entityFromFrontend.getCondition().toUpperCase());
                entityInBackend.setMarketValue(entityFromFrontend.getMarketValue());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return new UpdateResponseDto<>();
            };
        }
        else
        {
            System.out.println("Did not find a Catalog entity in the database with an ID of " + entityFromFrontend.getCatalogId());
            return new UpdateResponseDto<>();
        }

        entityInBackend = _repo.save(entityInBackend);
        CatalogDto dto = convertToDto(entityInBackend);
        return new UpdateResponseDto<CatalogDto>(dto, 1);
    }

    public DeleteResponseDto<CatalogDto> delete(int catalogId) {
        Catalog entity = _repo.findById(catalogId).orElseThrow();
        _repo.delete(entity);
        CatalogDto dto = convertToDto(entity);
        return new DeleteResponseDto<>(dto, 1);
    }
}