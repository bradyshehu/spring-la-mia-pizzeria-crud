package org.lessons.java.spring_la_mia_pizzeria_crud.controllers;

import java.util.List;

import org.lessons.java.spring_la_mia_pizzeria_crud.models.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.PizzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
@RequestMapping("/pizzas")

public class PizzasController {
    
    @Autowired
    private PizzasRepository repository;

    @GetMapping
    public String index (Model model) {

        List<Pizza> pizzas = repository.findAll();

        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {

        model.addAttribute("pizza", repository.findById(id).get());

       return "pizzas/show";
    }
    
    @GetMapping("/searchByName")
    public String indexSearchedByName(@RequestParam String name, Model model) {

        List<Pizza> pizzas = repository.findByNameContainingIgnoreCase(name);
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }
}
