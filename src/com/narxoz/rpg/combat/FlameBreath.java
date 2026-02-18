package com.narxoz.rpg.combat;

public class FlameBreath implements Ability {
    
    private final String name = "Flame Breath";
    private final int damage = 50;
    private final String description = "Breathes fire in an area (AoE damage + burn).";

    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }
    public String getDescription(){
        return description;
    }
    public FlameBreath clone(){
        return new FlameBreath();
    }

}