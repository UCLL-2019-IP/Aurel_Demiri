package com.typhonsoftwaresolutions.ipproj.controller;

import com.typhonsoftwaresolutions.ipproj.model.Gerecht;
import com.typhonsoftwaresolutions.ipproj.model.service.GerechtenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class GerechtenController {

    private final GerechtenService gerechtenService;

    @Autowired
    public GerechtenController(GerechtenService gerechtenService) {
        this.gerechtenService = gerechtenService;
    }

    @GetMapping("/gerechten")
    public String gerechten(Model model) {
        model.addAttribute("gerechten", gerechtenService.getAllGerechten());
        return "gerechten";
    }

    @GetMapping("/gerechten/change")
    public String changeGerechten(Model model) {
        model.addAttribute("gerechten", gerechtenService.getAllGerechten());
        return "changeGerechten";
    }

    @GetMapping("/gerechten/add")
    public String addGerechtForm() {
        return "addGerecht";
    }

    @PostMapping("/gerechten/add")
    public String addGerecht(@Valid Gerecht gerecht, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "addGerecht";
        } else {
            gerechtenService.addGerecht(gerecht);
            return "redirect:./change";
        }
    }

    @GetMapping("/gerechten/update")
    public String updateGerechtForm(@RequestParam("beschrijving") String beschrijving, Model model) {
        Gerecht gerecht = gerechtenService.findGerechtByBeschrijving(beschrijving);
        model.addAttribute("gerecht", gerecht);
        return "updateGerecht";
    }

    @PostMapping("/gerechten/update")
    public String updateGerecht(@RequestParam("oudeBeschrijving") String oudeBeschrijving, @Valid Gerecht gerecht, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "updateGerecht";
        } else {
            gerechtenService.updateGerecht(oudeBeschrijving, gerecht);
            return "redirect:./change";
        }
    }

    @GetMapping("/gerechten/delete")
    public String deleteGerechtConfirmation(@RequestParam("beschrijving") String beschrijving, Model model) {
        Gerecht gerecht = gerechtenService.findGerechtByBeschrijving(beschrijving);
        model.addAttribute("gerecht", gerecht);
        return "deleteGerechtConfirmation";
    }

    @PostMapping("/gerechten/delete")
    public String deleteGerecht(@RequestParam("beschrijving") String beschrijving) {
        Gerecht gerecht = gerechtenService.findGerechtByBeschrijving(beschrijving);
        gerechtenService.deleteGerecht(gerecht);
        return "redirect:./change";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Requested ID not found!")
    @ExceptionHandler(value = IllegalArgumentException.class)
    public void badIdExceptionHandler() {
    }
}
