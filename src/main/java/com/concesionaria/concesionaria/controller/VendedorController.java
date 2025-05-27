package com.concesionaria.concesionaria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concesionaria.concesionaria.model.Vendedor;
import com.concesionaria.concesionaria.service.VendedorService;

@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping
    public List<Vendedor> getAll() {
        return vendedorService.findAll();
    }

    @GetMapping("/{id}")
    public Vendedor getById(@PathVariable Long id) {
        return vendedorService.findById(id);
    }

    @PostMapping
    public Vendedor create(@RequestBody Vendedor vendedor) {
        return vendedorService.save(vendedor);
    }

    @PutMapping("/{id}")
    public Vendedor update(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        vendedor.setId(id);
        return vendedorService.save(vendedor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vendedorService.deleteById(id);
    }

}
