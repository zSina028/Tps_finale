package com.example.whatsapp.modelli;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat")
public class chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_chat;
    private String nome_chat;
    private String tipo_chat;
    @OneToMany(mappedBy = "chat", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<messaggio> messaggi;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "chatutente",
                joinColumns = {@JoinColumn(name = "id_chat")},
                inverseJoinColumns = {@JoinColumn(name = "id_utente")})
    private List<utente> utenti = new ArrayList<>();

    public int getId_chat() {
        return id_chat;
    }

    public void setId_chat(int id_chat) {
        this.id_chat = id_chat;
    }

    public String getNome_chat() {
        return nome_chat;
    }

    public void setNome_chat(String nome_chat) {
        this.nome_chat = nome_chat;
    }

    public String getTipo_chat() {
        return tipo_chat;
    }

    public void setTipo_chat(String tipo_chat) {
        this.tipo_chat = tipo_chat;
    }

    public List<messaggio> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<messaggio> messaggi) {
        this.messaggi = messaggi;
    }

    public List<utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<utente> utenti) {
        this.utenti = utenti;
    }
}
