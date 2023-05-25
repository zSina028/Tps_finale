package com.example.whatsapp.service;

import com.example.whatsapp.modelli.*;
import com.example.whatsapp.repository.chatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class chatService {
    @Autowired
    private chatRepository chatRepository;
    @Autowired
    private utenteService utenteService;

    public List<chat> getchats(String numeroUtente){
        return new ArrayList<>(chatRepository.trovaChatByTelefono(numeroUtente));
    }

    public chat getChat(long id){
        return chatRepository.findById(id).orElse(null);
    }

    public void salvaMessaggio(messaggioDTO contenuto){
        messaggio temporaneo = new messaggio();
        temporaneo.setTesto(contenuto.getTesto());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        temporaneo.setData(dateFormat.format(date));
        utente u = utenteService.getUtente(contenuto.getMittente());
        temporaneo.setMittente(u);
        chat c = getChat(contenuto.getChat());
        temporaneo.setChat(c);
        c.getMessaggi().add(temporaneo);
        chatRepository.save(c);
    }

    public void salvaChat(chatDTO contenuto){
        chat temporaneo = new chat();
        temporaneo.setNome_chat(contenuto.getNome_chat());
        temporaneo.setTipo_chat(contenuto.getTipo_chat());
        for(int i=0; i<contenuto.getUtenti().size(); i++){
            utente u = utenteService.getUtente(contenuto.getUtenti().get(i));
            if(u != null)
            {
                temporaneo.getUtenti().add(u);
            }
        }
        if(temporaneo.getUtenti().size()>1){
            chatRepository.save(temporaneo);
        }
    }
}