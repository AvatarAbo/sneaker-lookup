package com.example.sneakerlookup.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.sneakerlookup.dto.*;
import com.example.sneakerlookup.service.SneakerServiceIntf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api/sneaker")
public class SneakerController {

    private static final Logger logger = LoggerFactory.getLogger(SneakerController.class);

    private final SneakerServiceIntf _service;

    @Autowired
    public SneakerController(SneakerServiceIntf service) {
        _service = service;
    }

    @GetMapping("")
    public GetResponseDto<SneakerDto> get() throws Exception {
        CompletableFuture<List<SneakerDto>> future = _service.get();
        List<SneakerDto> dtoList = future.get();
        GetResponseDto<SneakerDto> responseDto = new GetResponseDto<>(dtoList);
        return responseDto;
    }

    @GetMapping("/getById/{id}")
    public SneakerDto getById(@PathVariable("id") int id) throws Exception {
        CompletableFuture<SneakerDto> future = _service.getById(id);
        SneakerDto responseDto = future.get();
        return responseDto;
    }

    @GetMapping("/search")
    public ResponseEntity<?> getBy(@RequestParam(value = "year", required = false) Integer year,
                                   @RequestParam(value = "brand", required = false) String brand,
                                   @RequestParam(value = "model", required = false) String model,
                                   @RequestParam(value = "colorWay", required = false) String colorWay)
            throws Exception {
        if (year != null && brand != null && model != null && colorWay != null) {
            SneakerDto responseDto = _service.getByYearAndBrandAndModelAndColorWay(year, brand, model, colorWay);
            return ResponseEntity.ok(responseDto);
        } else if (brand != null) {
            if (model == null && colorWay == null) {
                List<SneakerDto> dtoList = _service.getByBrand(brand);
                return ResponseEntity.ok(new GetResponseDto<>(dtoList));
            } else if (model != null && colorWay == null) {
                List<SneakerDto> dtoList = _service.getByBrandAndModel(brand, model);
                return ResponseEntity.ok(new GetResponseDto<>(dtoList));
            } else {
                List<SneakerDto> dtoList = _service.getByBrandAndModelAndColorWay(brand, model, colorWay);
                return ResponseEntity.ok(new GetResponseDto<>(dtoList));
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid parameters");
        }
    }

    @PostMapping("")
    public PostResponseDto<SneakerDto> add(@RequestBody RequestDto<SneakerDto> dto) {
        PostResponseDto<SneakerDto> responseDto = _service.add(dto);
        return responseDto;
    }

}
