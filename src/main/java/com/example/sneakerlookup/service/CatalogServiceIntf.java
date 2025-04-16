package com.example.sneakerlookup.service;

import java.util.List;

import com.example.sneakerlookup.dto.*;

public interface CatalogServiceIntf {
    CatalogDto getById(int id);
    List<CatalogDto> get();
    List<CatalogDto> getBySneakerId(int sneakerId);
    PostResponseDto<CatalogDto> add(RequestDto<CatalogDto> requestDto);
    UpdateResponseDto<CatalogDto> update(RequestDto<CatalogDto> requestDto);
    DeleteResponseDto<CatalogDto> delete(int catalogId);
}

