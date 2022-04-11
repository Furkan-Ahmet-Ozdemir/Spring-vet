package com.vet.controller;

import com.vet.model.Animal;
import com.vet.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchPageController {

    @Autowired
    private AnimalService animalService;

    @RequestMapping(path = {"/","/search"})
    public String home(Animal shop, Model model, String keyword) {
        if(keyword!=null) {
            List<Animal> list = animalService.getByKeyword(keyword);
            model.addAttribute("list", list);
        }else {
            List<Animal> list = animalService.getAllAnimals();
            model.addAttribute("list", list);}
        return "index";
    }



}
