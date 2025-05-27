
package com.concesionaria.concesionaria.controller;

import com.concesionaria.concesionaria.model.Auto;
import com.concesionaria.concesionaria.service.AutoService;
import com.concesionaria.concesionaria.service.VendedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private AutoService autoService;

    @Autowired
    private VendedorService vendedorService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("autos", autoService.findAll());
        model.addAttribute("vendedores", vendedorService.findAll());
        return "index"; // Nombre de la vista (index.html)
    }

    @GetMapping("/autos")
    public String listarAutos(Model model) {
        model.addAttribute("autos", autoService.findAll());
        return "autos"; // Nombre de la vista (autos.html)
    }

    @GetMapping("/autos/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("auto", new Auto());
        return "formulario_auto"; // Nombre de la vista (formulario_auto.html)
    }

    @PostMapping("/autos")
    public String guardarAuto(@ModelAttribute Auto auto) {
        autoService.save(auto);
        return "redirect:/autos";
    }

    @GetMapping("/autos/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("auto", autoService.findById(id));
        return "formulario_auto";
    }

    @GetMapping("/autos/eliminar/{id}")
    public String eliminarAuto(@PathVariable Long id) {
        autoService.deleteById(id);
        return "redirect:/autos";
    }
}