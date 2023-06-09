package com.example.whatsapp.service;

import com.example.whatsapp.modelli.utente;
import com.example.whatsapp.repository.utenteRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class utenteService {
    @Autowired
    private utenteRepository utenteRepository;

    public List<utente> getUtenti() {
        return new ArrayList<>(utenteRepository.findAll());
    }

    public utente getUtente(String numero){
        return utenteRepository.findById(numero).orElse(null);
    }
}
