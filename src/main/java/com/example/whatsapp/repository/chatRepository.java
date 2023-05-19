package com.example.whatsapp.repository;

import com.example.whatsapp.modelli.chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface chatRepository extends JpaRepository<chat, Long> {
    @Query("SELECT c FROM chat c LEFT JOIN FETCH c.utenti u WHERE c.id_chat IN (SELECT c.id_chat FROM chat c LEFT JOIN c.utenti u WHERE u.numero_telefono = :telefono) and u.numero_telefono <> :telefono ")
    List<chat> trovaChatByTelefono(@Param("telefono") String telefono);
}
