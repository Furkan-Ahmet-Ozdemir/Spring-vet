package com.vet.controller;

import com.vet.exception.AnimalNotFoundException;
import com.vet.model.Animal;
import com.vet.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService service;

    @GetMapping("/animals")
    public String showAnimalList(Model model){
        List<Animal> listAnimals = service.listAll();
        model.addAttribute("listAnimals",listAnimals);
        return "animals";
    }

    @GetMapping("/animals/new")
    public String showNewForm(Model model){
        model.addAttribute("animal",new Animal());
        model.addAttribute("pageTitle","Add New Animal");
        return "animal_form";
    }

    @PostMapping("/animals/save")
    public String saveAnimal(Animal animal, RedirectAttributes ra){
        service.save(animal);
        ra.addFlashAttribute("message","The Animal has been saved succesfuly");
        return "redirect:/animals";
    }

    @GetMapping("/animals/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Animal animal = service.get(id);
            model.addAttribute("animal",animal);
            model.addAttribute("pageTitle","Edit Animal(ID:+"+ id +")");

            return "animal_form";
        } catch (AnimalNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/animals";
        }
    }

    @GetMapping("/animals/delete/{id}")
    public String deleteAnimal(@PathVariable("id") Integer id,RedirectAttributes ra) throws AnimalNotFoundException {
        try {
            service.delete(id);
            ra.addFlashAttribute("message","The Animal ID "+id+" has been deleted.");

        } catch (AnimalNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/animals";
    }

}
