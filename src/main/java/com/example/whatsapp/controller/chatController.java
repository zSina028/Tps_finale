package com.example.whatsapp.controller;

import com.example.whatsapp.modelli.chat;
import com.example.whatsapp.service.chatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class chatController {
    @Autowired
    private chatService chatService;

    @GetMapping("/chats/{numeroUtente}")
    public List<chat> getchats(@PathVariable String numeroUtente){
        return chatService.getchats(numeroUtente);
    }
}
