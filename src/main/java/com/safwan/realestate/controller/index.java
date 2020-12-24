package com.safwan.realestate.controller;

import com.safwan.realestate.model.ApartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class index {
    private final ApartmentService apartmentService;

    public index(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }


    @RequestMapping({"","/","index","index.html"})
    public String Index(){
        //Locale locale = this.resolveLocale(request);
        //System.out.println(locale);
        return "redirect:/apartments/find/";
    }


    @RequestMapping("/oups")
    public String oupsHandler(){
        return "notimplemented";
    }
}
