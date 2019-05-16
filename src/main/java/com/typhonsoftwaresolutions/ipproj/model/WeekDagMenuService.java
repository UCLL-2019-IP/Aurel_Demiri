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

    public void patchDagMenu(LocalDate datum, DagMenu dagMenu) {
        DagMenu foundDagMenu = dagMenuRepository.findByDatum(datum);

        if (dagMenu.getSoep() != null)
            foundDagMenu.setSoep(dagMenu.getSoep());

        if (dagMenu.getDagschotel() != null)
            foundDagMenu.setDagschotel(dagMenu.getDagschotel());

        if (dagMenu.getVeggie() != null)
            foundDagMenu.setVeggie(dagMenu.getVeggie());

        dagMenuRepository.save(foundDagMenu);
    }

    public void deleteDagMenu(LocalDate datum) {
        dagMenuRepository.delete(dagMenuRepository.findByDatum(datum));
    }
}
