package com.VotreBanque.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VotreBanque.spring.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
