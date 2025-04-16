package com.example.sneakerlookup.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.example.sneakerlookup.data.entity.Sneaker;
import com.example.sneakerlookup.data.repository.SneakerRepository;
import com.example.sneakerlookup.dto.RequestDto;
import com.example.sneakerlookup.dto.SneakerDto;
import com.example.sneakerlookup.dto.PostResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SneakerService implements SneakerServiceIntf {

    private final SneakerRepository _repo;

    @Autowired
    public SneakerService(SneakerRepository repo) {
        _repo = repo;
    }

    private SneakerDto convertToDto(Sneaker entity) {
        if (entity == null) return null;

        SneakerDto dto = new SneakerDto();
        dto.setSneakerId(entity.getSneakerId());
        dto.setYear(entity.getYear());
        dto.setBrand(entity.getBrand());
        dto.setModel(entity.getModel());
        dto.setColorway(entity.getColorWay());
        dto.setType(entity.getType());

        return dto;
    }

    private Sneaker convertToEntity(SneakerDto dto) {
        if (dto == null) return null;

        Sneaker entity = new Sneaker();
        entity.setSneakerId(dto.getSneakerId());
        entity.setYear(dto.getYear());
        entity.setBrand(dto.getBrand());
        entity.setModel(dto.getModel());
        entity.setColorway(dto.getColorWay());
        entity.setType(dto.getType());

        return entity;
    }

    @Async
    public CompletableFuture<SneakerDto> getById(int id) {
        Sneaker entity = _repo.findById(id).orElseThrow();
        SneakerDto dto = convertToDto(entity);
        return CompletableFuture.completedFuture(dto);
    }

    @Async
    public CompletableFuture<List<SneakerDto>> get() {
        List<Sneaker> entityList = _repo.findAll();
        List<SneakerDto> dtoList = entityList.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
        return CompletableFuture.completedFuture(dtoList);
    }

    public List<SneakerDto> getByBrand(String brand) {
        List<Sneaker> entityList = _repo.findByBrand(brand);
        List<SneakerDto> dtoList = entityList.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
        return dtoList;
    }

    public List<SneakerDto> getByBrandAndModel(String brand, String model) {
        List<Sneaker> entityList = _repo.findByBrandAndModel(brand, model);
        List<SneakerDto> dtoList = entityList.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
        return dtoList;
    }

    public List<SneakerDto> getByBrandAndModelAndColorWay(String brand, String model, String colorWay) {
        List<Sneaker> entityList = _repo.findByBrandAndModelAndColorWay(brand, model, colorWay);
        List<SneakerDto> dtoList = entityList.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
        return dtoList;
    }

    public SneakerDto getByYearAndBrandAndModelAndColorWay(int year, String brand, String model, String colorWay) {
        Sneaker entity = _repo.findByYearAndBrandAndModelAndColorWay(year, brand, model, colorWay).orElseThrow();
        SneakerDto dto = convertToDto(entity);
        return dto;
    }

    public PostResponseDto<SneakerDto> add(RequestDto<SneakerDto> requestDto) {
        if (requestDto == null) {
            return new PostResponseDto<>();
        }

        SneakerDto sneakerDto = requestDto.getData();
        if (sneakerDto == null) {
            return new PostResponseDto<>();
        }

        Sneaker entity = convertToEntity(sneakerDto);
        if (entity == null) {
            return new PostResponseDto<>();
        }

        entity = _repo.save(entity);
        SneakerDto dto = convertToDto(entity);
        return new PostResponseDto<>(dto, 1);
    }
}
