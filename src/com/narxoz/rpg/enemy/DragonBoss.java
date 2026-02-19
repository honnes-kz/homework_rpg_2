package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class DragonBoss implements Enemy {
    private final String name;
    private final int health;
    private final int damage;
    private final int defense;
    private final int speed;
    private final String element;
    private final List<Ability> abilities;
    private final LootTable lootTable;
    private final String aiBehavior;
    private final Map<Integer, Integer> phases;

    public DragonBoss(String name, int health, int damage, int defense, int speed,
                      String element, List<Ability> abilities, LootTable lootTable,
                      String ai, Map<Integer, Integer> phases) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        List<Ability> copyAbilities = new ArrayList<>();
        for (Ability a : abilities) {
            copyAbilities.add(a.clone());
        }
        this.abilities = Collections.unmodifiableList(copyAbilities);
        this.lootTable = (lootTable == null ? null : lootTable.clone());
        this.aiBehavior = ai;
        this.phases = new HashMap<>(phases);
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage; 
    }
    public int getDefense() {
        return defense;
    }
    public int getSpeed() {
        return speed;
    }
    public String getElement() {
        return element;
    }
    public List<Ability> getAbilities() {
        return abilities;
    }
    public LootTable getLootTable() {
        return lootTable;
    }
    public String getaiBehavior() {
        return aiBehavior;
    }
    public Map<Integer, Integer> getPhases() {
        return Collections.unmodifiableMap(phases);
    }
    public DragonBoss clone() {
        return new DragonBoss(name, health, damage, defense, speed,
                              element, abilities, lootTable, aiBehavior, phases);
    }
}