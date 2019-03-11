package com.typhonsoftwaresolutions.ipproj.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GerechtenService {
    private List<Gerecht> gerechten = new ArrayList<>();

    public GerechtenService() {
        gerechten.add(new Gerecht("Bloemkool soep", 1d));
        gerechten.add(new Gerecht("Tomatensoep", 1d));
        gerechten.add(new Gerecht("Pompoensoep", 1d));
        gerechten.add(new Gerecht("Cordon Blue", 4.2d));
        gerechten.add(new Gerecht("Konijn met pruimen", 4.2d));
        gerechten.add(new Gerecht("Groetenlasange", 4d));
        gerechten.add(new Gerecht("Veggie pasta", 4d));
    }

    public List<Gerecht> getAllGerechten() {
        return gerechten;
    }
}
