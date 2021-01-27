package com.debartologiego.puntoCaldaie.data.dao;

import com.debartologiego.puntoCaldaie.data.entities.Stufa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StufaDao extends JpaRepository<Stufa,Long> {
}
