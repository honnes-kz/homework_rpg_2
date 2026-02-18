package com.narxoz.rpg.combat;

public class Vanish implements Ability {

    private final String name = "Vanish";
    private final int damage = 0;
    private final String description = "Becomes invisible to evade attacks (stealth).";
    public String getName() { 
        return name; 
    }
    public int getDamage() { 
        return damage; 
    }
    public String getDescription() { 
        return description; 
    }
    public Vanish clone() { 
        return new Vanish(); 
    }

}