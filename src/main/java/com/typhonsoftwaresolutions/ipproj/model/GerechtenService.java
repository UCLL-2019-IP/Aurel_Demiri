package com.typhonsoftwaresolutions.ipproj.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GerechtenService {
    private List<Gerecht> gerechten = new ArrayList<Gerecht>();
    private AtomicInteger nextId = new AtomicInteger();

    public GerechtenService() {
        gerechten.add(new Gerecht(nextId.incrementAndGet(), "Bloemkool soep", 1d));
        gerechten.add(new Gerecht(nextId.incrementAndGet(), "Tomatensoep", 1d));
        gerechten.add(new Gerecht(nextId.incrementAndGet(), "Pompoensoep", 1d));
        gerechten.add(new Gerecht(nextId.incrementAndGet(), "Cordon Blue", 4.2d));
        gerechten.add(new Gerecht(nextId.incrementAndGet(), "Konijn met pruimen", 4.2d));
        gerechten.add(new Gerecht(nextId.incrementAndGet(), "Groetenlasange", 4d));
        gerechten.add(new Gerecht(nextId.incrementAndGet(), "Veggie pasta", 4d));
    }

    public List<Gerecht> getAllGerechten() {
        return gerechten;
    }
}
