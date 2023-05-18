package com.example.whatsapp.modelli;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "utente")

public class utente {
    @Id
    private String numero_telefono;
    private String nome;
    private String foto;

    //private ArrayList<chat> chats;
}
