package com.concesionaria.concesionaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concesionaria.concesionaria.model.Auto;

public interface AutoRepository extends JpaRepository<Auto, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

}
