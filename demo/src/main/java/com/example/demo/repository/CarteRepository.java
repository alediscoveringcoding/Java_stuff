package com.example.demo.repository;

import com.example.demo.entity.Carte;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarteRepository  extends JpaRepository<Carte, String> {}


