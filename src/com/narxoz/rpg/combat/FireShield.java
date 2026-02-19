package com.narxoz.rpg.combat;

public class FireShield implements Ability{

    private final String name = "Fire Shield";
    private final int damage = 0;
    private final String description = "Shields the enemy with flames (defensive buff).";
    private final AbilityType type = AbilityType.Fire;

    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }
    public String getDescription(){
        return description;
    }
    public AbilityType getType(){
        return type;
    }
    public FireShield clone(){
        return new FireShield();
    }

}