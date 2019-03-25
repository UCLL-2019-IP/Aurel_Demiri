package com.typhonsoftwaresolutions.ipproj.controller;

import com.typhonsoftwaresolutions.ipproj.model.DagMenu;
import com.typhonsoftwaresolutions.ipproj.model.GerechtenService;
import com.typhonsoftwaresolutions.ipproj.model.WeekDagMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class DagMenuController {

    private final WeekDagMenuService weekDagMenuService;

    private final GerechtenService gerechtenService;

    @Autowired
    public DagMenuController(WeekDagMenuService weekDagMenuService, GerechtenService gerechtenService) {
        this.gerechtenService = gerechtenService;
        this.weekDagMenuService = weekDagMenuService;
    }

    @PostMapping("/dagmenu/add")
    public List<DagMenu> addDagMenu(@RequestBody @Valid DagMenu dagMenu) {
        // Improper fix for: Not-null property references a transient value
        // USE ID FOR GOD'S SAKE
        dagMenu.setSoep(gerechtenService.findGerechtByBeschrijving(dagMenu.getSoep().getBeschrijving()));
        dagMenu.setDagschotel(gerechtenService.findGerechtByBeschrijving(dagMenu.getDagschotel().getBeschrijving()));
        dagMenu.setVeggie(gerechtenService.findGerechtByBeschrijving(dagMenu.getVeggie().getBeschrijving()));

        weekDagMenuService.addDagMenu(dagMenu);
        return weekDagMenuService.getAllDagMenu();
    }

    @PatchMapping("/dagmenu/change/{datum}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeDagMenu(@PathVariable("datum") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate datum, @RequestBody DagMenu dagMenu) {
        // Improper fix for: Not-null property references a transient value
        // USE ID FOR GOD'S SAKE
        dagMenu.setSoep(gerechtenService.findGerechtByBeschrijving(dagMenu.getSoep().getBeschrijving()));
        dagMenu.setDagschotel(gerechtenService.findGerechtByBeschrijving(dagMenu.getDagschotel().getBeschrijving()));
        dagMenu.setVeggie(gerechtenService.findGerechtByBeschrijving(dagMenu.getVeggie().getBeschrijving()));
        weekDagMenuService.patchDagMenu(datum, dagMenu.getSoep(), dagMenu.getDagschotel(), dagMenu.getVeggie());
    }
}
