package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedPositiveTest {
    private final String sex;
    private final boolean isMane;

    public LionParameterizedPositiveTest(String sex, boolean isMane) {
        this.sex = sex;
        this.isMane = isMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, признак hasMane: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}};
    }

    @Test
    public void doesHaveManePositiveTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean actual = lion.doesHaveMane();
        assertEquals(isMane, actual);
    }
}
