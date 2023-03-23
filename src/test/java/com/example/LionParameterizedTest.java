package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean isMane;

    public LionParameterizedTest(String sex, boolean isMane) {
        this.sex = sex;
        this.isMane = isMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, признак hasMane: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Чудо-юдо", false}};
    }

    @Test
    public void doesHaveManeTest() {
        try {
            Lion lion = new Lion(sex);
            boolean actual = lion.doesHaveMane();
            assertEquals(isMane, actual);
        } catch (Exception ex) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", ex.getMessage());
        }
    }
}
