package com.example.whatsapp.modelli;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "messaggio")
public class messaggio {
    @Id
    @GeneratedValue
    private int id_messaggio;
    private String testo;
    private String data;
    @OneToOne
    @JoinColumn(name = "mittente")
    private utente mittente;
    @ManyToOne
    @JoinColumn(name = "id_chat")
    @JsonIgnore
    private chat chat;

    public int getId_messaggio() {
        return id_messaggio;
    }

    public void setId_messaggio(int id_messaggio) {
        this.id_messaggio = id_messaggio;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public utente getMittente() {
        return mittente;
    }

    public void setMittente(utente mittente) {
        this.mittente = mittente;
    }

    public com.example.whatsapp.modelli.chat getChat() {
        return chat;
    }

    public void setChat(com.example.whatsapp.modelli.chat chat) {
        this.chat = chat;
    }
}
