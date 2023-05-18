package com.example.whatsapp.modelli;

import jakarta.persistence.*;

@Entity
@Table(name = "messaggio")
public class messaggio {
    @Id
    @GeneratedValue
    private int id_messaggio;
    private String testo;
    private String data;
    private String mittente;
    @ManyToOne
    @JoinColumn(name = "id_chat")
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

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public com.example.whatsapp.modelli.chat getChat() {
        return chat;
    }

    public void setChat(com.example.whatsapp.modelli.chat chat) {
        this.chat = chat;
    }
}
