package com.debartologiego.puntoCaldaie.data.dto;

import com.debartologiego.puntoCaldaie.data.entities.Caldaia;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ClientDto implements Serializable {

    private long id;
    private String nominativo;
    private String luogoNascita;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascita;
    private String telefono;
    private String indirizzo;
    private String cap;
    private String citta;
    private String CF;
    private String piva;
    private String cellulare;
    @JsonManagedReference
    private List<StufaDto> stufe;
    @JsonManagedReference
    private List<CaldaiaDto> caldaie;

    public List<CaldaiaDto> getCaldaie() {
        return caldaie;
    }

    public void setCaldaie(List<CaldaiaDto> caldaie) {
        this.caldaie = caldaie;
    }

    public List<StufaDto> getStufe() {
        return stufe;
    }

    public void setStufe(List<StufaDto> stufe) {
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

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", nominativo='" + nominativo + '\'' +
                ", luogoNascita='" + luogoNascita + '\'' +
                ", dataNascita=" + dataNascita +
                ", telefono='" + telefono + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", cap='" + cap + '\'' +
                ", citta='" + citta + '\'' +
                ", CF='" + CF + '\'' +
                ", piva='" + piva + '\'' +
                ", cellulare='" + cellulare + '\'' +
                ", stufe=" + stufe +
                '}';
    }
}
