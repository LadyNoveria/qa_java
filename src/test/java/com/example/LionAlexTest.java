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
    private LionAlex lionAlex;
    @Spy
    private Feline feline;
    @Mock
    private Animal animal;

    @Test
    public void getKittensTest() throws Exception {
        lionAlex = new LionAlex(feline);
        int actual = lionAlex.getKittens();
        assertEquals(0, actual);
    }

    @Test
    public void getFriendsTest() throws Exception {
        lionAlex = new LionAlex(feline);
        List<String> actual = lionAlex.getFriends();
        assertEquals(List.of("Марти", "Глория", "Мелман"), actual);
    }

    @Test
    public void getPlaceOfLivingTest() throws Exception {
        lionAlex = new LionAlex(feline);
        String actual = lionAlex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", actual);
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        lionAlex = new LionAlex(feline);
        boolean actual = lionAlex.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        lionAlex = new LionAlex(feline);
        List<String> actual = lionAlex.getFood();
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(animal.getFood("Хищник"), actual);
    }
}
