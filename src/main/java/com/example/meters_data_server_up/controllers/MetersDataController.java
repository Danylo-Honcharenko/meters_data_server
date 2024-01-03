package com.example.meters_data_server_up.controllers;

import com.example.meters_data_server_up.Routes;
import com.example.meters_data_server_up.models.Data;
import com.example.meters_data_server_up.repositories.MetersDataRepository;
import com.example.meters_data_server_up.service.ResponseHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Routes.MAIN)
@AllArgsConstructor
public class MetersDataController {

    private final MetersDataRepository metersDataRepositories;

    @PostMapping(Routes.CREATE_ENTRY)
    public ResponseEntity<?> createEntry(@Valid @RequestBody Data data) {
        metersDataRepositories.save(data);
        return ResponseHandler.response("Data written successfully!", HttpStatus.OK);
    }

    @CrossOrigin(maxAge = 3600)
    @GetMapping(Routes.GET_ALL_RECORDS)
    public Iterable<Data> getAllRecords() {
        return metersDataRepositories.findAll();
    }

    @CrossOrigin(maxAge = 3600)
    @GetMapping(Routes.FILTER_RECORDS)
    public Iterable<Data> getSpecificRecords() {
        return metersDataRepositories.findAll(Sort.by("id").descending());
    }
}
