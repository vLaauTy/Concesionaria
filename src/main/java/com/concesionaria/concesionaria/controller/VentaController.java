package com.concesionaria.concesionaria.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concesionaria.concesionaria.model.Venta;
import com.concesionaria.concesionaria.service.AutoService;
import com.concesionaria.concesionaria.service.VendedorService;
import com.concesionaria.concesionaria.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;
    private final AutoService autoService;
    private final VendedorService vendedorService;

    public VentaController(VentaService ventaService,
            AutoService autoService,
            VendedorService vendedorService) {
        this.ventaService = ventaService;
        this.autoService = autoService;
        this.vendedorService = vendedorService;
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioVenta(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("autos", autoService.findAll());
        model.addAttribute("vendedores", vendedorService.findAll());
        return "formulario_venta";
    }

    @PostMapping
    public String guardarVenta(@ModelAttribute Venta venta) {
        ventaService.guardarVenta(venta);

        return "redirect:/ventas";
    }

    @GetMapping("/{id}")
    public Venta obtenerVentaPorId(@PathVariable Long id) {
        return ventaService.obtenerVentaPorId(id);
    }

    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }

    @PutMapping("/{id}")
    public Venta actualizarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        venta.setId(id);
        return ventaService.guardarVenta(venta);
    }

}
