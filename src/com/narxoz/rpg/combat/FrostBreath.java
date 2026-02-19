package com.narxoz.rpg.combat;

public class FrostBreath implements Ability{

    private final String name = "Frost Breath";
    private final int damage = 40;
    private final String description = "Breathes ice, slowing targets (damage + slow).";
    private final AbilityType type = AbilityType.Ice;

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
    public FrostBreath clone(){
        return new FrostBreath();
    }

}