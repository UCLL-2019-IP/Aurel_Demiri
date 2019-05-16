package com.typhonsoftwaresolutions.ipproj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@SuppressWarnings("WeakerAccess")
@Entity
public class Gerecht {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Beschrijving should not be empty")
    @Size(min = 4, max = 50, message = "Beschrijving length should be between 4 and 50")
    private String beschrijving;

    @NotNull(message = "Prijs should not be empty")
    @DecimalMin(value = "0.1", message = "Prijs should not be lower than 0.1")
    @DecimalMax(value = "10", message = "Prijs should not be higher than 10")
    private Double prijs;

    @Pattern(regexp = "DAGSCHOTEL|SOEP|VEGGIE", message = "Invalid gerecht type")
    private String type;

    public Gerecht() {
    }

    public Gerecht(String beschrijving, Double prijs, String type) {
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
