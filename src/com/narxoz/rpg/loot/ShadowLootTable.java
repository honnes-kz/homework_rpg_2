package com.narxoz.rpg.loot;

import java.util.List;
import java.util.ArrayList;


public class ShadowLootTable implements LootTable {
    private final List<String> items = List.of("Shadow Gem", "Dark Essence", "Shadow Rune");
    private final int goldDrop = 90;
    private final int xpDrop = 190;
    public List<String> getItems() {
        return new ArrayList<>(items);
    }
    public int getGoldDrop() {
        return goldDrop;
    }
    public int getExperienceDrop() {
        return xpDrop;
    }
    public String getLootInfo(){
        return "Gold:" + goldDrop + "Xp:" + xpDrop; 
    }
    public ShadowLootTable clone() {
        return new ShadowLootTable();
    }
}