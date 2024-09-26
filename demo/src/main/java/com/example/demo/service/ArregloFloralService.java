package com.example.demo.service;

import com.example.demo.model.ArregloFloral;
import com.example.demo.repository.ArregloFloralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArregloFloralService {

    @Autowired
    private ArregloFloralRepository arregloFloralRepository;

    /* metodo para obtener todos los arreglos */
    public List<ArregloFloral> getAllArreglos() {
        return arregloFloralRepository.findAll();
    }
    /* metodo para crear nuevos arreglos */
    public ArregloFloral createArregloFloral(ArregloFloral arregloFloral) {
        return arregloFloralRepository.save(arregloFloral);
    }
    /* metodo para obtener todos los arreglos por id  */
    public ArregloFloral getArregloById(Long id) {
        return arregloFloralRepository.findById(id).orElse(null);
    }
    /* metodo para borrar arreglos por id  */
    public void deleteArreglo(Long id) {
        arregloFloralRepository.deleteById(id);
    }
}


