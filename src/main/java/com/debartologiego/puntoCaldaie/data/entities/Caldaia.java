package com.debartologiego.puntoCaldaie.data.entities;

import javax.persistence.*;

@Entity
@Table(name="CALDAIA")
public class Caldaia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="TITOLO")
    private  String titolo;

    @Column(name="SCAD_ANNO")
    private  String scadanno;

    @Column(name="IMPORTO")
    private String importo;

    @Column(name="ANNOTAZIONE")
    private String annotazione;

    @Column(name="SCAD_BOLLO")
    private String scadbollo;

    @Column(name="SCADENZA")
    private String scadenza;

    @ManyToOne(optional=false,fetch = FetchType.LAZY)
    @JoinColumn (name="CLIENTE",referencedColumnName = "ID")
    private Client cliente;

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

    public String getScadenza() {
        return scadenza;
    }

    public void setScadenza(String scadenza) {
        this.scadenza = scadenza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
}
