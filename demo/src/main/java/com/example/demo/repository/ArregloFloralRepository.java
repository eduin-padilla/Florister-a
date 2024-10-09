package com.example.demo.repository;

import com.example.demo.model.ArregloFloral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArregloFloralRepository extends JpaRepository<ArregloFloral, Long> {
    
}
