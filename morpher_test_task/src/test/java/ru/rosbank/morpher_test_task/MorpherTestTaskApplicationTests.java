package ru.rosbank.morpher_test_task;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.rosbank.morpher_test_task.controller.MorpherController;
import ru.rosbank.spring_test.utils.Gender;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MorpherTestTaskApplicationTests {

	MorpherController morpherController;

//	@Test
//	public void contextLoads() {
//	}

	@Before
	public void create() {
		morpherController = new MorpherController();
	}

	@Test
	public void whenEnterCatThenReturnMasculine() {
		System.out.println("Определение рода вводимого значения-мужской род");
		Gender result = morpherController.defineGender("Кот");
		Gender expected = Gender.Masculine;
		assertEquals(expected, result);
	}

	@Test
	public void whenEnterCowThenReturnFeminine() {
		System.out.println("Определение рода вводимого значения-женский род");
		Gender result = morpherController.defineGender("Корова");
		Gender expected = Gender.Feminine;
		assertEquals(expected, result);
	}

	@Test
	public void whenEnterMilkThenReturnNeuter() {
		System.out.println("Определение рода вводимого значения - средний род");
		Gender result = morpherController.defineGender("Молоко");
		Gender expected = Gender.Neuter;
		assertEquals(expected, result);
	}

	@Test
	public void whenEnterDogsThenReturnPlural() {
		System.out.println("Определение рода вводимого значения - множественное число");
		Gender result = morpherController.defineGender("Собаки");
		Gender expected = Gender.Plural;
		assertEquals(expected, result);
	}

	@Test(expected = NullPointerException.class)
	public void whenTypeNullThenReturnExceptions() {
		System.out.println("Проверка на пустое значение");
		Gender result = morpherController.defineGender(null);
		Gender expected = Gender.Masculine;
		assertEquals(expected, result);
	}

	




}

