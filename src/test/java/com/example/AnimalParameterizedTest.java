package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private final String animalKind;
    private final List<String> food;
    public AnimalParameterizedTest(String animalKind, List<String> food){
        this.animalKind = animalKind;
        this.food = food;
    }
    @Parameterized.Parameters(name = "Вид: \"{0}\", еда: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Чудо-юдо", Collections.emptyList()}};
    }

    @Test
    public void getFoodTest() {
        try {
            Animal feline = new Feline();
            List<String> actual = feline.getFood(animalKind);
            assertEquals(food, actual);
        } catch (Exception ex) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", ex.getMessage());
        }
    }
}
