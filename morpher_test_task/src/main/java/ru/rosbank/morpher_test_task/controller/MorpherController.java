package ru.rosbank.morpher_test_task.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rosbank.spring_test.Declension;
import ru.rosbank.spring_test.FIO;
import ru.rosbank.spring_test.IFIO;
import ru.rosbank.spring_test.Parse;
import ru.rosbank.spring_test.utils.Case;
import ru.rosbank.spring_test.utils.Gender;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mess")
public class MorpherController {

    @GetMapping("/gender")
    public Gender defineGender(String input) {
      Parse parse = new Parse(input);
      return new Parse(input).getGender();
    }

    @GetMapping("/changeGender")
    public String exchangeGender(String input, Gender toGender) {
        Declension declension = new Declension();
        String newValue = declension.changeGender(input, toGender);
        return newValue;
    }

    @GetMapping("/definecase")
    public String definePadezh(Case formCase, boolean isPlural) {
        Parse parse = new Parse("Воздушный шар");
        String newValue = parse.getForm(formCase, isPlural);
        return newValue;
    }

    @GetMapping("/fio")
    public FIO fio(String input) {
        Parse parse = new Parse(input);
        FIO name = (FIO) parse.getFIO();
        return name;
    }

    @GetMapping("/123")
    public String testMethod() {
        return "Hello world";
    }




}
