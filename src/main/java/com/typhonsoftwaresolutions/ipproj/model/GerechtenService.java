package com.typhonsoftwaresolutions.ipproj.model;

import com.typhonsoftwaresolutions.ipproj.repository.GerechtenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerechtenService {

    private final GerechtenRepository gerechtenRepository;

    @Autowired
    public GerechtenService(GerechtenRepository gerechtenRepository) {
        this.gerechtenRepository = gerechtenRepository;
    }

    public List<Gerecht> getAllGerechten() {
        return gerechtenRepository.findAll();
    }

    public void addGerecht(Gerecht gerecht) {
        gerechtenRepository.save(gerecht);
    }

    public void deleteGerecht(Gerecht gerecht) {
        gerechtenRepository.delete(findGerechtByBeschrijving(gerecht.getBeschrijving()));
    }

    public Gerecht findGerechtByBeschrijving(String beschrijving) {
        Gerecht x = gerechtenRepository.findByBeschrijving(beschrijving);

        if (x != null)
            return x;

        throw new IllegalArgumentException("Gerecht that has this beschrijving could not be found");
    }

    public void updateGerecht(String beschrijving, Gerecht gerecht) {
        Gerecht foundGerecht = findGerechtByBeschrijving(beschrijving);
        foundGerecht.setBeschrijving(gerecht.getBeschrijving());
        foundGerecht.setPrijs(gerecht.getPrijs());
        foundGerecht.setType(gerecht.getType());

        gerechtenRepository.save(foundGerecht);
    }
}
