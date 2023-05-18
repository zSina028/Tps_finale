package com.example.whatsapp.service;

import com.example.whatsapp.modelli.chat;
import com.example.whatsapp.repository.chatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class chatService {
    @Autowired
    private chatRepository chatRepository;

    public List<chat> getchats(){
        return new ArrayList<>();
    }
}
