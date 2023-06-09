package com.example.whatsapp.modelli;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utente")
public class utente {
    @Id
    private String numero_telefono;
    private String nome;
    private String foto;
    @JsonIgnore
    @ManyToMany(mappedBy = "utenti")
    private List<chat> chats;

    public List<chat> getChats() {
        return chats;
    }

    public void setChats(List<chat> chats) {
        this.chats = chats;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
