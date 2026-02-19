package com.narxoz.rpg.builder;

import java.util.List;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

public interface EnemyBuilder {

    EnemyBuilder setName(String name);
    EnemyBuilder setHealth(int health);
    EnemyBuilder setDamage(int damage);
    EnemyBuilder setDefense(int defense);
    EnemyBuilder setSpeed(int speed);
    EnemyBuilder setElement(String element);
    
    EnemyBuilder addAbility(Ability ability);
    EnemyBuilder setAbilities(List<Ability> abilities);
    EnemyBuilder addPhase(int phaseNumber, int healthThreshold);
    EnemyBuilder setLootTable(LootTable loot);
    EnemyBuilder setAI(String ai);
    Enemy build();
}