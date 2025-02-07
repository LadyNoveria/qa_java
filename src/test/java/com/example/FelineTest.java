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
public class FelineTest {

    @Spy
    private Feline feline;
    @Mock
    private Animal animal;

    @Test
    public void getKittensWithoutParametersTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithParametersTest() {
        int actual = feline.getKittens(5);
        assertEquals(5, actual);
    }

    @Test
    public void getFamilyTest() {
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual);
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> actual = feline.eatMeat();
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(animal.getFood("Хищник"), actual);
    }
}
