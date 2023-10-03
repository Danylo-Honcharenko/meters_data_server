package com.example.meters_data_server_up.controllers;

import com.example.meters_data_server_up.models.MetersDataModel;
import com.example.meters_data_server_up.repositories.MetersDataRepositories;
import com.example.meters_data_server_up.resources.MeterDataResources;
import com.example.meters_data_server_up.utilits.RespInfo;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meters-data")
public class MetersDataController {

    private final MetersDataRepositories metersDataRepositories;

    public MetersDataController(final MetersDataRepositories metersDataRepositories) {
        this.metersDataRepositories = metersDataRepositories;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEntry(@Valid @RequestBody MeterDataResources meterDataResources) {

        MetersDataModel metersDataModel = new MetersDataModel();
        metersDataModel.setAnnotation(meterDataResources.annotation());
        metersDataModel.setGas(meterDataResources.gas());
        metersDataModel.setWater(meterDataResources.water());
        metersDataModel.setT11(meterDataResources.t11());
        metersDataModel.setT12(meterDataResources.t12());

        metersDataRepositories.save(metersDataModel);

        return new ResponseEntity<>(new RespInfo()
                .statusCode(HttpStatus.CREATED.value())
                .message("Data written successfully!"), HttpStatus.CREATED);
    }

    @CrossOrigin(maxAge = 3600)
    @GetMapping("/all-records")
    public Iterable<MetersDataModel> getAllRecords() {
        return metersDataRepositories.findAll();
    }

    @CrossOrigin(maxAge = 3600)
    @GetMapping("/reverse-record")
    public Iterable<MetersDataModel> getSpecificRecords() {
        return metersDataRepositories.findAll(Sort.by("id").descending());
    }
}
