package com.debartologiego.puntoCaldaie.data.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "CLIENTI")
public class Client {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic(optional = false)
    @Column(name="NOMINATIVO")
    private String nominativo;

    @Column(name = "LUOGO_NASCITA")
    private String luogoNascita;

    @Column(name = "DATA_NASCITA")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascita;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "INDIRIZZO")
    private String indirizzo;

    @Column(name = "CAP")
    private String cap;

    @Column(name = "CITTA")
    private String citta;

    @Column(name = "CF")
    private String CF;

    @Column(name = "PIVA")
    private String piva;

    @Column(name = "CELLULARE")
    private String cellulare;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Stufa> stufe;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Caldaia> caldaie;

    public List<Caldaia> getCaldaie() {
        return caldaie;
    }

    public void setCaldaie(List<Caldaia> caldaie) {
        this.caldaie = caldaie;
    }

    public List<Stufa> getStufe() {
        return stufe;
    }

    public void setStufe(List<Stufa> stufe) {
        this.stufe = stufe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }


}
