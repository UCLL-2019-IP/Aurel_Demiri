package com.typhonsoftwaresolutions.ipproj.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Gerecht {

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 30)
    private String beschrijving;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    private Double prijs;

    public Gerecht() {
    }

    public Gerecht(String beschrijving, Double prijs) {
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Double getPrijs() {
        return prijs;
    }
}
