package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "arreglo_floral")
@Data
public class ArregloFloral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "arreglo_floral_flor",
        joinColumns = @JoinColumn(name = "arreglo_floral_id"),
        inverseJoinColumns = @JoinColumn(name = "flor_id")
    )
    private List<Flor> flores;
}

