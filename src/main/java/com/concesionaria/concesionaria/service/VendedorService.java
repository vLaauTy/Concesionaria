package com.concesionaria.concesionaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionaria.concesionaria.Repository.VendedorRepository;
import com.concesionaria.concesionaria.model.Vendedor;

import jakarta.persistence.Entity;

@Service

public class VendedorService {

    @Autowired
    private final VendedorRepository repo;

    public VendedorService(VendedorRepository repo) {
        this.repo = repo;
    }

    public List<Vendedor> findAll() {
        return repo.findAll();
    }

    public Vendedor findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Vendedor save(Vendedor vendedor) {
        return repo.save(vendedor);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
