package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Spy
    private Feline feline;
    @Mock
    private Animal animal;
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline);
        List<String> actual = lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(animal.getFood("Хищник"), actual);
    }

    @Test
    public void getKittensTest() {
        Lion lion = new Lion(feline);
        int actual = lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        assertEquals(1, actual);
    }
}

