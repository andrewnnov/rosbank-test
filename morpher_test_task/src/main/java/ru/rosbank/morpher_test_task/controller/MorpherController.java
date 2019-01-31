package ru.rosbank.morpher_test_task.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rosbank.spring_test.Declension;
import ru.rosbank.spring_test.Parse;
import ru.rosbank.spring_test.utils.Case;
import ru.rosbank.spring_test.utils.Gender;

@RestController
@RequestMapping("/message")
public class MorpherController {

    @GetMapping("/gender")
    public Gender defineGender(String input) {
      Parse parse = new Parse(input);
//      String gender = parse.getGender();
//        System.out.println(gender);
       return new Parse(input).getGender();
    }
//http://localhost:8080/message/2?input=Кошка&toGender=Masculine
    @GetMapping("/changeGender")
    public String exchangeGender(String input, Gender toGender) {
        Declension declension = new Declension();
        String newValue = declension.changeGender(input, toGender);
//        System.out.println(newValue);
        return newValue;
    }
//http://localhost:8080/message/3?formCase=Dat&isPlural=false
    @GetMapping("/definecase")
    public String definePadezh(Case formCase, boolean isPlural) {
        Parse parse = new Parse("Воздушный шар");
        String newValue = parse.getForm(formCase, isPlural);
        return newValue;
    }




}
