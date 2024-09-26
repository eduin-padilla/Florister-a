package com.example.demo.service;

import com.example.demo.model.Flor;
import com.example.demo.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlorService {

    @Autowired
    private FlorRepository florRepository;

    /* obtener las flores  */
    public List<Flor> getAllFlores() {
        return florRepository.findAll();
    }

    /* crear nuevas flores */
    public Flor createFlor(Flor flor) {
        return florRepository.save(flor);
    }

    /* obtener flores por id */
    public Flor getFlorById(Long id) {
        return florRepository.findById(id).orElse(null);/* en tal caso que no exista 
                                                            sera igual a nulo */
    }

    /* eliminar floes por id */
    public void deleteFlor(Long id) {
        florRepository.deleteById(id);
    }
}

