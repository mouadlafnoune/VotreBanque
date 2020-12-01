package com.VotreBanque.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VotreBanque.spring.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{

}
