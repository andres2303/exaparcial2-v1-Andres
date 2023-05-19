package com.example.demoandres.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoandres.Entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, String> {

}
