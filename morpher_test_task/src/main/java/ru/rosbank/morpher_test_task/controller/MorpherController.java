package ru.rosbank.morpher_test_task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rosbank.spring_test.Declension;
import ru.rosbank.spring_test.IFIO;
import ru.rosbank.spring_test.Parse;
import ru.rosbank.spring_test.utils.Case;
import ru.rosbank.spring_test.utils.Gender;

@RestController
@RequestMapping("/russian/message")
public class MorpherController {

    private static final String DEFAULT_INPUT = "Воздушный шар";
    /**
     * Этот метод определяет род вводимого слова
     * @param input Любое существительное или прилагательное
     * @return род введенного слова
     */
    @GetMapping("/gender")
    public Gender defineGender(String input) {
        return new Parse(input).getGender();
    }

    /**
     * Метод меняет род введеного слова мужского рода на женский или средний или переводит слово
     * во множественное число. Либо оставляет его в мужском роде.
     * @param input только прилагательное мужского рода
     * @param toGender в какой род необходимо перевести слово. Возможные варианты:
     *     Masculine - мужской
     *     Feminine - женский
     *     Neuter - средний
     *     Plural - множественное число
     * @return слово женского или среднего рода. Либо множественное число слова.
     */
    @GetMapping("/changeGender")
    public String exchangeGender(String input, Gender toGender) {
        return new Declension().changeGender(input, toGender);
    }

    /**
     * Метод для склонения словосочетания "воздушный шар"
     * @param formCase Падежи.
     *     Nom - именительный
     *     Gen - родительный
     *     Dat - дательный
     *     Acc - винительный
     *     Ins - творительный
     *     Pre - предложный
     *     Loc - местный
     * @param isPlural true или false (находится ли слово во множественном числе)
     * @return String возвращает слово в заданном падеже
     */
    @GetMapping("/caseDefinition")
    public String defineCase(Case formCase, boolean isPlural) {
        return new Parse(DEFAULT_INPUT).getForm(formCase, isPlural);
    }

    /**
     * Метод выделяет фамилию, имя, отчество из введеной строки.
     * @param input String Фамили Имя Отчество (для этого метода важен порядок И.О.Ф
     * @return JSON ФИО
     */
    @GetMapping("/fio")
    public IFIO fio(String input) {
        return new Parse(input).getFIO();
    }
}
