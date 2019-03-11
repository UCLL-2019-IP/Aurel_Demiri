package com.typhonsoftwaresolutions.ipproj.controller;

import com.typhonsoftwaresolutions.ipproj.model.GerechtenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class GerechtenController implements WebMvcConfigurer {

    @Autowired
    private GerechtenService gerechtenService;

    @GetMapping("/gerechten")
    public String gerechten(Model model) {
        model.addAttribute("gerechten", gerechtenService.getAllGerechten());
        return "gerechten";
    }
}
