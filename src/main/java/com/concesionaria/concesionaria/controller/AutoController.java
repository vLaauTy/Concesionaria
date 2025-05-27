package com.concesionaria.concesionaria.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.concesionaria.concesionaria.model.Auto;
import com.concesionaria.concesionaria.service.AutoService;

@RestController
@RequestMapping("/api/autos")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public List<Auto> getAll() {
        return autoService.findAll();
    }

    @GetMapping("/{id}")
    public Auto getById(@PathVariable Long id) {
        return autoService.findById(id);
    }

    @PostMapping
    public Auto create(@RequestBody Auto auto) {
        return autoService.save(auto);
    }

    @PutMapping("/{id}")
    public Auto update(@PathVariable Long id, @RequestBody Auto auto) {
        auto.setId(id);
        return autoService.save(auto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        autoService.deleteById(id);
    }
}
