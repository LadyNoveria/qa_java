package com.example;

import java.util.List;

public class LionAlex extends Lion {
    public LionAlex() throws Exception {
        super("Самец");
    }

    public LionAlex(Feline feline) {
        super(feline);
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}


