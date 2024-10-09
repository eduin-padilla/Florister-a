package com.example.demo.controller;

import com.example.demo.model.Flor;
import com.example.demo.service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/flores")
public class florController{

    @Autowired
    private FlorService florService;

    // Método para obtener todas las flores y mostrarlas en la vista
    @GetMapping
    public String getAllFlores(Model model) {
        List<Flor> flores = florService.getAllFlores();
        model.addAttribute("flores", flores);
        return "flores"; // Retorna la vista 'flores.html'
    }

    // Método para mostrar el formulario de nueva flor
    @GetMapping("/nueva")
    public String mostrarFormularioFlor(Model model) {
        model.addAttribute("flor", new Flor());
        return "nuevaFlor"; // Retorna la vista 'nuevaFlor.html'
    }

    // Método para crear una nueva flor
    @PostMapping
    public String crearFlor(@ModelAttribute Flor flor) {
        florService.createFlor(flor);
        return "redirect:/flores"; // Redirige a la lista de flores
    }

    // Método para obtener una flor por ID
    @GetMapping("/{id}")
    public Flor getFlorById(@PathVariable Long id) {
        return florService.getFlorById(id);
    }

    // Método para eliminar una flor por ID
    @GetMapping("/eliminar/{id}")
    public String deleteFlor(@PathVariable Long id) {
        florService.deleteFlor(id);
        return "redirect:/flores";
    }
}

//probando cambios

