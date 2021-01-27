package com.debartologiego.puntoCaldaie.data.dao;

import com.debartologiego.puntoCaldaie.data.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
}
