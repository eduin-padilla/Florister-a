package com.example.demo.repository;


import com.example.demo.model.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<Flor, Long> {
    // Puedes agregar métodos personalizados aquí si lo necesitas
}
