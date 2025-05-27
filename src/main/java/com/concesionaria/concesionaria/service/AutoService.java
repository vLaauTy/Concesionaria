package com.concesionaria.concesionaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionaria.concesionaria.Repository.AutoRepository;
import com.concesionaria.concesionaria.model.Auto;

@Service
public class AutoService {
    @Autowired
    private final AutoRepository repo;

    public AutoService(AutoRepository repo) {
        this.repo = repo;

    }

    public List<Auto> findAll() {
        return repo.findAll();
    }

    public Auto findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Auto save(Auto auto) {
        return repo.save(auto);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
