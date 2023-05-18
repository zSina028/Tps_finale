package com.example.whatsapp.controller;

import com.example.whatsapp.modelli.utente;
import com.example.whatsapp.service.utenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class utenteController {
    @Autowired
    private utenteService utenteService;

    @GetMapping("/utenti")
    public List<utente> getUtenti() {
        return utenteService.getUtenti();
    }
}
