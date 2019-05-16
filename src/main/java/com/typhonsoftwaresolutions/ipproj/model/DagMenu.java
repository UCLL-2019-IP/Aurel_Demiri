package com.typhonsoftwaresolutions.ipproj.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
public class DagMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "Maandag|Dinsdag|Woensdag|Donderdag|Vrijdag", message = "Invalid dag format")
    private String dag;

    @NotNull
    private LocalDate datum;

    @NotNull
    @ManyToOne
    private Gerecht soep;

    @NotNull
    @ManyToOne
    private Gerecht dagschotel;

    @NotNull
    @ManyToOne
    private Gerecht veggie;

    public DagMenu() {
    }

    public DagMenu(String dag, LocalDate datum, Gerecht soep, Gerecht dagschotel, Gerecht veggie) {
        this.dag = dag;
        this.datum = datum;
        this.soep = soep;
        this.dagschotel = dagschotel;
        this.veggie = veggie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDag() {
        return dag;
    }

    public void setDag(String dag) {
        this.dag = dag;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Gerecht getSoep() {
        return soep;
    }

    public void setSoep(Gerecht soep) {
        this.soep = soep;
    }

    public Gerecht getDagschotel() {
        return dagschotel;
    }

    public void setDagschotel(Gerecht dagschotel) {
        this.dagschotel = dagschotel;
    }

    public Gerecht getVeggie() {
        return veggie;
    }

    public void setVeggie(Gerecht veggie) {
        this.veggie = veggie;
    }
}
