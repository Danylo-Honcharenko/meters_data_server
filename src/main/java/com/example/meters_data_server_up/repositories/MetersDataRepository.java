package com.example.meters_data_server_up.repositories;

import com.example.meters_data_server_up.models.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetersDataRepository extends JpaRepository<Data, Integer> {
}
