package com.example.meters_data_server_up.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@lombok.Data
@Entity
@Table(name = "meters_data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedDate
    private LocalDate date = LocalDate.now();

    @NotBlank(message = "'Annotation' field is empty!")
    private String annotation;

    @NotNull(message = "'Gas' field is null!")
    @Column(length = 6)
    private Integer gas;

    @NotNull(message = "'Water' field is null!")
    @Column(length = 6)
    private Integer water;

    @NotNull(message = "'T11' field is null!")
    @Column(length = 6)
    private Integer t11;

    @NotNull(message = "'T12' field is null!")
    @Column(length = 6)
    private Integer t12;
}
