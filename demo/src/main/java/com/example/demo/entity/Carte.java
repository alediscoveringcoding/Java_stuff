package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "carti")
public class Carte {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ISBN;
    private String titlul;
    private String autorul;

    public String getISBN() {
        return ISBN;
    }

    public String getTitlul() {
        return titlul;
    }

    public String getAutorul() {
        return autorul;
    }
}

