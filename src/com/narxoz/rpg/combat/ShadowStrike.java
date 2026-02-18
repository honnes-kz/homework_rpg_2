package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability{

    private final String name = "Shadow Strike";
    private final int damage = 60;
    private final String description = "Strikes a target with dark energy (single-target damage + blind).";

    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }
    public String getDescription(){
        return description;
    }
    public ShadowStrike clone(){
        return new ShadowStrike();
    }

}