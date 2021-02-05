package com.debartologiego.puntoCaldaie.data.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class CaldaiaDto {

    private long id;
    private String titolo;
    private String scadenza;



    private String scadanno;
    private String importo;
    private String annotazione;
    private String scadbollo;

    @JsonBackReference
    private ClientDto cliente;

    public String getScadenza() {
        return scadenza;
    }

    public void setScadenza(String scadenza) {
        this.scadenza = scadenza;
    }
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

    public void setCliente(ClientDto clienteDto) {
        cliente = clienteDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CaldaiaDto{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", scadenza='" + scadenza + '\'' +
                ", scadanno='" + scadanno + '\'' +
                ", importo='" + importo + '\'' +
                ", annotazione='" + annotazione + '\'' +
                ", scadbollo='" + scadbollo + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
