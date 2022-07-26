package ru.yandex.praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class checkNameToEmbossTest {
    private final String currentValue;
    private final boolean expectedValue;

    static Faker faker = new Faker();

    public checkNameToEmbossTest(String currentValue, boolean expectedValue) {
        this.currentValue = currentValue;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Object[][] getFoodData() {
        return new Object[][]{
                {faker.letterify("??"), false}, // длина меньше 3
                {faker.letterify("????????????????????"), false}, // длина больше 19
                {faker.letterify("????????  ?????"), false}, // более одного пробела
                {faker.letterify(" ????????"), false}, // пробел вначале
                {faker.letterify("???????? "), false}, // полбел в конце
                {faker.letterify("????????"), true},  //подходящие имя
                {faker.letterify("???? ????"), true},  //подходящие имя с пробелом
        };
    }

    @Test
    public void checkNameToEmbossShouldReturnCorrectResult() {
        Account account = new Account(currentValue);
        boolean actualResult = account.checkNameToEmboss();
        assertEquals(expectedValue, actualResult);
    }
}
