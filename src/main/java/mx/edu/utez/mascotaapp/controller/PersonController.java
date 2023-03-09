package mx.edu.utez.mascotaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import mx.edu.utez.mascotaapp.model.Person;
import mx.edu.utez.mascotaapp.service.PersonServiceImp;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServiceImp service;

    @GetMapping("/form")
    public String savePerson(Person person, Model model) {
        model.addAttribute("person", new Person());
        return "formPerson";
    }

    @PostMapping("/save")
    public String savePerson(@Valid @ModelAttribute("person") Person person, BindingResult  result ) {
        if (result.hasErrors()) {
            return "formPerson";
        }
        service.savePerson(person);
        return "success";
    }
}
