package com.vet.controller;

import com.vet.exception.UserNotFoundException;
import com.vet.model.User;
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
public class UserController {
    @Autowired
    private UserService service;

    // User ları listeliyorum .
    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers",listUsers);
        return "users";
    }

    // User formu gönderiyorum .
    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("pageTitle","Add New User");
        return "user_form";
    }

    //  POST metodu ile User ı kayıt ediyorum.
    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra){
        service.save(user);
        ra.addFlashAttribute("message","The User has been saved succesfuly");
        return ("redirect:/users");
    }

    // User Id si ile forma kayıtlı bilgileri gösteriyorum .
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id,Model model, RedirectAttributes ra){
        try {
            User user = service.get(id);
            model.addAttribute("user",user);
            model.addAttribute("pageTitle","Edit User ");

            return "user_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/users";
        }
    }

    // User Id si ile silme işlmei yapıyorum
//    @GetMapping("/users/delete/{id}")
//    public String deleteUser(@PathVariable("id") Integer id,RedirectAttributes ra){
//        try {
//            service.delete(id);
//            ra.addFlashAttribute("message","The User ID "+id+" has been deleted.");
//
//        } catch (UserNotFoundException e) {
//            ra.addFlashAttribute("message",e.getMessage());
//        }
//        return "redirect:/users";
//    }


}
