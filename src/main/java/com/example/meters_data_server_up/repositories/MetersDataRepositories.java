package com.example.meters_data_server_up.repositories;

import com.example.meters_data_server_up.models.MetersDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetersDataRepositories extends JpaRepository<MetersDataModel, Integer> {
}
