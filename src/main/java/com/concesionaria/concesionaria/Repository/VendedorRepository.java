package com.concesionaria.concesionaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concesionaria.concesionaria.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

}
