package ru.rosbank.morpher_test_task;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MorpherApiTest {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void whenAuthIgnoredThrowErr() {
        when().get("/russian/message/gender?input=%D0%A1%D0%B5%D1%80%D0%B3%D0%B5%D0%B9").
                then().
                statusCode(401);
    }

    @Test
    public void whenEnterCatThenReturnMasculine() {
        given().auth().basic("user", "password").
                when().get("/russian/message/gender?input=%D0%A1%D0%B5%D1%80%D0%B3%D0%B5%D0%B9").
                then().
                statusCode(200).body(Matchers.containsString("Masculine"));
    }

    @Test
    public void whenEnterVozdushnyiThenReturnFemailVozdushnaya() {
        given().auth().basic("user", "password").
                when().get("/russian/message/changeGender?input=Воздушный&toGender=Feminine").
                then().
                statusCode(200).body(Matchers.containsString("Воздушная"));
    }

    @Test
    public void whenEnterPlularIsTRueThenReturnPluralVozdushnyeShary() {
        given().auth().basic("user", "password").
                when().get("/russian/message/caseDefinition?formCase=Nom&isPlural=true").
                then().
                statusCode(200).body(Matchers.containsString("воздушные шары"));
    }

    @Test
    public void whenEnterFIOThenReturnFIOSort() {

        given().auth().basic("user", "password").when()
                .get("/russian/message/fio?input=Александр Сергеевич Пушкин").
                then()
                .body("lastName", equalTo("Пушкин"))
                .body("firstName", equalTo("Александр"))
                .body("middleName", equalTo("Сергеевич")).statusCode(200);
    }

}
