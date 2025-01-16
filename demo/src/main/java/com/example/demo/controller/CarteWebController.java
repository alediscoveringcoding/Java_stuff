package com.example.demo.controller;

import com.example.demo.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarteWebController {
    @Autowired
    CarteRepository repository;

    @GetMapping("/lista-carti")
    public String getListaCarti(Model model) {
        String s = "Lista cartilor preluate prin repository";
        model.addAttribute("str", s);
        model.addAttribute("lista", repository.findAll());
        return "carti";

    }

    @PostMapping("/operatii")
    public String operatii(Model model,String ISBN,String titlul, String autorul) {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Ttilul: " + titlul);
        System.out.println("Autorul: " + autorul);
        String s = "Lista cartilor preluate prin repository";
        model.addAttribute("str", s);
        model.addAttribute("lista", repository.findAll());
        return "carti";

    }
}
