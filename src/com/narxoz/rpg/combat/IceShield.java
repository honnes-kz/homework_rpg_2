package com.narxoz.rpg.combat;

public class IceShield implements Ability{

    private final String name = "Ice Shield";
    private final int damage = 0;
    private final String description = "Shields the enemy with ice (defensive buff).";
    private final AbilityType type = AbilityType.BurnDefense;

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
    public IceShield clone(){
        return new IceShield();
    }

}