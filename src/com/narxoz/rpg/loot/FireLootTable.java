package com.narxoz.rpg.loot;

import java.util.List;
import java.util.ArrayList;


public class FireLootTable implements LootTable {
    
    private final List<String> items = List.of("Fire Gem", "Dragon Scale", "Flame Rune");
    private final int goldDrop = 100;
    private final int xpDrop = 200;

    public List<String> getItems(){
        return new ArrayList<>(items);
    }
    public int getGoldDrop(){ 
        return goldDrop; 
    }
    public int getExperienceDrop(){ 
        return xpDrop; 
    }
    public String getLootInfo(){
        return "Gold:" + goldDrop + "Xp:" + xpDrop;
    }
    public FireLootTable clone(){ 
        return new FireLootTable(); 
    }

}