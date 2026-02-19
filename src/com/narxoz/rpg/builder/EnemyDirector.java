package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;

public class EnemyDirector {

    public Enemy createMinion(EnemyComponentFactory factory) {
        EnemyBuilder builder = new BasicEnemyBuilder();
        
        return builder
            .setName(factory.getClass().getSimpleName().replace("ComponentFactory", "") + " Goblin")
            .setHealth(50)
            .setDamage(5)
            .setDefense(2)
            .setSpeed(10)
            .setElement(extractElement(factory))
            .addAbility(factory.createAbilities().get(0))
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAI())
            .build();
    }
    public Enemy createElite(EnemyComponentFactory factory) {
        EnemyBuilder builder = new BasicEnemyBuilder();
        return builder
            .setName(factory.getClass().getSimpleName().replace("ComponentFactory", "") + " Elite Goblin")
            .setHealth(100)
            .setDamage(10)
            .setDefense(5)
            .setSpeed(12)
            .setElement(extractElement(factory))
            .setAbilities(factory.createAbilities())
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAI())
            .build();
    }
    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        EnemyBuilder builder = new BossEnemyBuilder();
        return builder
            .setName(factory.getClass().getSimpleName().replace("ComponentFactory", "") + " Dragon")
            .setHealth(300)
            .setDamage(30)
            .setDefense(15)
            .setSpeed(8)
            .setElement(extractElement(factory))
            .setAbilities(factory.createAbilities())
            .addPhase(1, 200)
            .addPhase(2, 100)
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAI())
            .build();
    }
    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        EnemyBuilder builder = new BossEnemyBuilder();
        return builder
            .setName(factory.getClass().getSimpleName().replace("ComponentFactory", "") + " Ancient Dragon")
            .setHealth(1000)
            .setDamage(50)
            .setDefense(25)
            .setSpeed(6)
            .setElement(extractElement(factory))
            .setAbilities(factory.createAbilities())
            .addPhase(1, 700)
            .addPhase(2, 400)
            .addPhase(3, 100)
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAI())
            .build();
    }
    private String extractElement(EnemyComponentFactory factory) {
        if (factory instanceof FireComponentFactory){
            return "Fire";
        }
        if (factory instanceof IceComponentFactory){
            return "Ice";
        }
        if (factory instanceof ShadowComponentFactory){
            return "Shadow";
        }
        return "Neutral";
    }
}