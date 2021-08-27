package com.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String home(Locale locale, Model model){
        Date date= new Date();
        DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,locale);
        String formattedDate=dateFormat.format(date);

        model.addAttribute("serverTime",formattedDate);
        return "home";
    }

}