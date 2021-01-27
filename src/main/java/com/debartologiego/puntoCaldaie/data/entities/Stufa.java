package com.debartologiego.puntoCaldaie.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Table
@Entity(name="STUFA")
public class Stufa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name="TITOLO",columnDefinition = "varchar(255) default 'Nessun Titolo'")
    private String titolo;

    @Column(name = "ANNO_SCAD")
    private String scadanno;

    @Column(name = "IMPORTO")
    private String importo;

    @Column(name = "ANNOTAZIONE")
    private String annotazione;

    @Column(name = "SCAD_BOLLO")
    private String scadbollo;

    @ManyToOne(optional=false,fetch = FetchType.LAZY)
    @JoinColumn (name="CLIENTE",referencedColumnName = "ID")
    private Client cliente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }


}
