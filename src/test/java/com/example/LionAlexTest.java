package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    @Spy
    private LionAlex lionAlex;
    @Mock
    private Animal animal;

    @Test
    public void getKittensTest() {
        int actual = lionAlex.getKittens();
        assertEquals(0, actual);
    }

    @Test
    public void getFriendsTest() {
        List<String> actual = lionAlex.getFriends();
        assertEquals(List.of("Марти", "Глория", "Мелман"), actual);
    }

    @Test
    public void getPlaceOfLivingTest() {
        String actual = lionAlex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", actual);
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lionAlex = new LionAlex();
        boolean actual = lionAlex.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lionAlex = new LionAlex(new Feline());
        List<String> actual = lionAlex.getFood();
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(animal.getFood("Хищник"), actual);
    }
}
