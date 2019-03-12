package com.typhonsoftwaresolutions.ipproj.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GerechtenService {
    private List<Gerecht> gerechten = new ArrayList<>();

    public GerechtenService() {
        gerechten.add(new Gerecht("Bloemkool soep", 1d, "SOEP"));
        gerechten.add(new Gerecht("Tomatensoep", 1d, "SOEP"));
        gerechten.add(new Gerecht("Pompoensoep", 1d, "SOEP"));
        gerechten.add(new Gerecht("Cordon Blue", 4.2d, "DAGSCHOTEL"));
        gerechten.add(new Gerecht("Konijn met pruimen", 4.2d, "DAGSCHOTEL"));
        gerechten.add(new Gerecht("Groentenlasange", 4d, "VEGGIE"));
        gerechten.add(new Gerecht("Veggie pasta", 4d, "VEGGIE"));
    }

    public List<Gerecht> getAllGerechten() {
        return gerechten;
    }

    public void addGerecht(Gerecht gerecht) {
        gerechten.add(gerecht);
    }

    public void deleteGerecht(Gerecht gerecht) {
        gerechten.remove(gerecht);
    }

    public Gerecht findGerechtByBeschrijving(String beschrijving) {
        for (Gerecht gerecht : gerechten) {
            if (gerecht.getBeschrijving().equals(beschrijving)) {
                return gerecht;
            }
        }

        throw new IllegalArgumentException("Gerecht that has this beschrijving could not be found");
    }

    public void updateGerecht(String beschrijving, Gerecht gerecht) {
        Gerecht foundGerecht = findGerechtByBeschrijving(beschrijving);
        foundGerecht.setBeschrijving(gerecht.getBeschrijving());
        foundGerecht.setPrijs(gerecht.getPrijs());
        foundGerecht.setType(gerecht.getType());
    }
}
