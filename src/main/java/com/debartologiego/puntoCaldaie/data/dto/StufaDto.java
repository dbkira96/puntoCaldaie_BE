package com.debartologiego.puntoCaldaie.data.dto;

import com.debartologiego.puntoCaldaie.data.entities.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

public class StufaDto {
    private long id;
    private String titolo;
    private String scadanno;
    private String importo;
    private String annotazione;
    private String scadbollo;
    @JsonBackReference
    private ClientDto cliente;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getScadanno() {
        return scadanno;
    }

    public void setScadanno(String scadanno) {
        this.scadanno = scadanno;
    }

    public String getImporto() {
        return importo;
    }

    public void setImporto(String importo) {
        this.importo = importo;
    }

    public String getAnnotazione() {
        return annotazione;
    }

    public void setAnnotazione(String annotazione) {
        this.annotazione = annotazione;
    }

    public String getScadbollo() {
        return scadbollo;
    }

    public void setScadbollo(String scadbollo) {
        this.scadbollo = scadbollo;
    }

    public ClientDto getCliente() {
        return cliente;
    }

    public void setCliente(ClientDto cliente) {
        cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
