package com.typhonsoftwaresolutions.ipproj.controller;

import com.typhonsoftwaresolutions.ipproj.model.DagMenu;
import com.typhonsoftwaresolutions.ipproj.model.WeekDagMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeekMenuController {

    private final WeekDagMenuService weekDagMenuService;

    @Autowired
    public WeekMenuController(WeekDagMenuService weekDagMenuService) {
        this.weekDagMenuService = weekDagMenuService;
    }

    @GetMapping("/weekmenu")
    public List<DagMenu> getAllDagMenu() {
        return weekDagMenuService.getAllDagMenu();
    }
}
