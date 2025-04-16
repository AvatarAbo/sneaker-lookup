package com.example.sneakerlookup.controller;

import java.util.List;

import com.example.sneakerlookup.dto.*;
import com.example.sneakerlookup.service.CatalogServiceIntf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api/catalog")
public class CatalogController {

    private final CatalogServiceIntf _service;

    @Autowired
    public CatalogController(CatalogServiceIntf service) {
        _service = service;
    }

    @GetMapping("")
    public GetResponseDto<CatalogDto> get() throws Exception {
        List<CatalogDto> dtoList = _service.get();
        GetResponseDto<CatalogDto> responseDto = new GetResponseDto<>(dtoList);
        return responseDto;
    }

    @GetMapping("/{id}")
    public CatalogDto getById(@PathVariable("id") int id) throws Exception {
        CatalogDto responseDto = _service.getById(id);
        return responseDto;
    }

    @GetMapping("/getCatalogs")
    public GetResponseDto<CatalogDto> getCatalogsBySneakerId(@RequestParam(value = "sneakerId") Integer sneakerId)
            throws Exception {
        List<CatalogDto> dtoList = _service.getBySneakerId(sneakerId);
        GetResponseDto<CatalogDto> responseDto = new GetResponseDto<>(dtoList);
        return responseDto;
    }

    @PostMapping("")
    public PostResponseDto<CatalogDto> add(@RequestBody RequestDto<CatalogDto> dto) {
        PostResponseDto<CatalogDto> responseDto = _service.add(dto);
        return responseDto;
    }

    @PutMapping("update")
    public UpdateResponseDto<CatalogDto> update(@RequestBody RequestDto<CatalogDto> dto) {
        UpdateResponseDto<CatalogDto> responseDto = _service.update(dto);
        return responseDto;
    }

    @DeleteMapping("remove/{id}")
    public DeleteResponseDto<CatalogDto> delete(@PathVariable("id") int id) {
        DeleteResponseDto<CatalogDto> responseDto = _service.delete(id);
        return responseDto;
    }

}
