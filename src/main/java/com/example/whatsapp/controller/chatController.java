package com.example.whatsapp.controller;

import com.example.whatsapp.modelli.chat;
import com.example.whatsapp.modelli.chatDTO;
import com.example.whatsapp.modelli.messaggioDTO;
import com.example.whatsapp.service.chatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class chatController {
    @Autowired
    private chatService chatService;

    @GetMapping("/chats/{numeroUtente}")
    public List<chat> getchats(@PathVariable String numeroUtente){
        return chatService.getchats(numeroUtente);
    }

    @PostMapping("/messaggio")
    public void aggiungiMessaggio(@RequestBody messaggioDTO contenuto){
        chatService.salvaMessaggio(contenuto);
    }

    @PostMapping("/chat")
    public void aggiungiChat(@RequestBody chatDTO contenuto){
        chatService.salvaChat(contenuto);
    }
}
