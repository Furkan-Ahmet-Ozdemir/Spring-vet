package com.vet.controller;

import com.vet.exception.AnimalNotFoundException;
import com.vet.model.Animal;
import com.vet.model.User;
import com.vet.service.AnimalService;
import com.vet.service.UserService;
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
    private AnimalService animalService;

    @Autowired
    private UserService userService;

    // Animal ları listeliyorum .
    @GetMapping("/animals")
    public String showAnimalList(Model model){
        List<Animal> listAnimals = animalService.listAll();
        model.addAttribute("listAnimals",listAnimals);
        return "index";
    }

    // User ları listeye atıp yeni Animal formunda gösteriyorum .
    @GetMapping("/animals/new")
    public String showAnimalNewForm(Model model){
        List<User> listUsers = userService.listAll();
        if (listUsers.isEmpty()){
            model.addAttribute("user",new User());
            model.addAttribute("pageTitle","There is no User so :You have to Add New User");
            return "user_form";
        }
        model.addAttribute("pageTitle","Create Animal");

        model.addAttribute("listUsers",listUsers);
        model.addAttribute("animal",new Animal());
        return "animal_form";
    }

    // Post metodu ile Animalı kayıt ediyorum. POST kullanma sebebim url de verilerin görünmemesi için
    @PostMapping("/animals/save")
    public String saveAnimal(Animal animal, RedirectAttributes ra){
        animalService.save(animal);
        ra.addFlashAttribute("message","The Animal has been saved succesfuly");
        return "redirect:/ ";
    }

    // Animal Id si ile forma kayıtlı bilgileri gösteriyorum .
    @GetMapping("/animals/edit/{id}")
    public String showEditFormAnimal(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Animal animal = animalService.get(id);
            model.addAttribute("animal",animal);
            model.addAttribute("pageTitle","Edit Animal");
            List<User> listUsers = userService.listAll();
            model.addAttribute("listUsers",listUsers);

            return "animal_form";
        } catch (AnimalNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/ ";
        }
    }

    // Animal Id si ile silme işlmei yapıyorum
    @GetMapping("/animals/delete/{id}")
    public String deleteAnimal(@PathVariable("id") Integer id,RedirectAttributes ra) throws AnimalNotFoundException {
        try {
            animalService.delete(id);
            ra.addFlashAttribute("message","The Animal ID "+id+" has been deleted.");

        } catch (AnimalNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/ ";
    }


}
