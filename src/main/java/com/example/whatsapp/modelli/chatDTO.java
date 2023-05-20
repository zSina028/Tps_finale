package com.example.whatsapp.modelli;

import java.util.List;

public class chatDTO {
    private String nome_chat;
    private String tipo_chat;
    private List<String> utenti;

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

    public List<String> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<String> utenti) {
        this.utenti = utenti;
    }
}
