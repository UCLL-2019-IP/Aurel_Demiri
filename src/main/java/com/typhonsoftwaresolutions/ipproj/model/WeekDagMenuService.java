package com.typhonsoftwaresolutions.ipproj.model;

import com.typhonsoftwaresolutions.ipproj.repository.DagMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeekDagMenuService {

    private final DagMenuRepository dagMenuRepository;

    @Autowired
    public WeekDagMenuService(DagMenuRepository dagMenuRepository) {
        this.dagMenuRepository = dagMenuRepository;
    }

    public List<DagMenu> getAllDagMenu() {
        return dagMenuRepository.findAll();
    }

    public void addDagMenu(DagMenu dagMenu) {
        dagMenuRepository.save(dagMenu);
    }

    public void patchDagMenu(LocalDate datum, Gerecht soep, Gerecht dagschotel, Gerecht veggie) {
        DagMenu foundDagMenu = dagMenuRepository.findByDatum(datum);
        foundDagMenu.setSoep(soep);
        foundDagMenu.setDagschotel(dagschotel);
        foundDagMenu.setVeggie(veggie);

        dagMenuRepository.save(foundDagMenu);
    }
}
