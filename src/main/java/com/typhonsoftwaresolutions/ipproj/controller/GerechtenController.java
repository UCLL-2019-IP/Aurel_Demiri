package com.typhonsoftwaresolutions.ipproj.controller;

import com.typhonsoftwaresolutions.ipproj.model.Gerecht;
import com.typhonsoftwaresolutions.ipproj.model.GerechtenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class GerechtenController implements WebMvcConfigurer {

    @Autowired
    private GerechtenService gerechtenService;

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
    public String addGerechtForm(Model model) {
        return "addGerecht";
    }

    @PostMapping("/gerechten/add")
    public String addGerecht(@Valid Gerecht gerecht, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "addGerecht";
        } else {
            gerechtenService.addGerecht(gerecht);
            model.addAttribute("gerechten", gerechtenService.getAllGerechten());
            return "redirect:./change";
        }
    }
}
