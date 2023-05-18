package com.example.whatsapp.repository;

import com.example.whatsapp.modelli.chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface chatRepository extends JpaRepository<chat, Long> {

}
