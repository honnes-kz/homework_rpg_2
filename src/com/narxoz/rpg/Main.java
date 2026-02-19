package com.narxoz.rpg;

import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.enemy.*;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.BossEnemyBuilder;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;

public class Main {

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("Fire abilities:");
        fireFactory.createAbilities().forEach(a ->
        System.out.println("- " + a.getName()));

        System.out.println("\nIce abilities:");
        iceFactory.createAbilities().forEach(a ->
        System.out.println("- " + a.getName()));

        System.out.println("\nShadow abilities:");
        shadowFactory.createAbilities().forEach(a ->
        System.out.println("- " + a.getName()));

        System.out.println("\n============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        Enemy dragon = new BossEnemyBuilder()
                .setName("Ancient Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(300)
                .setSpeed(100)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAI(fireFactory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .build();

        System.out.println("Built using Fluent Builder:");
        displayEnemy(dragon);

        EnemyDirector director = new EnemyDirector();
        Enemy miniBoss = director.createMiniBoss(iceFactory);
        Enemy raidBoss = director.createRaidBoss(shadowFactory);

        System.out.println("\nBuilt using Director:");
        displayEnemy(miniBoss);
        displayEnemy(raidBoss);

        System.out.println("\n============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        EnemyRegistry registry = new EnemyRegistry();
        registry.registerTemplate("dragon", dragon);

        Enemy clonedDragon = registry.createFromTemplate("dragon");

        System.out.println("Original Dragon abilities count: " + dragon.getAbilities().size());
        System.out.println("Cloned Dragon abilities count: " + clonedDragon.getAbilities().size());
        System.out.println("Different objects in memory? " + (dragon != clonedDragon));
        System.out.println("\nDeep copy proof:");
        System.out.println("Original ability object == Clone ability object ?");
        System.out.println(dragon.getAbilities().get(0)== clonedDragon.getAbilities().get(0));

        System.out.println("\n============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        EnemyComponentFactory shadowFactory2 = new ShadowComponentFactory();

        Enemy demonLord = new BossEnemyBuilder()
                .setName("Demon Lord")
                .setHealth(80000)
                .setDamage(800)
                .setDefense(400)
                .setSpeed(120)
                .setElement("SHADOW")
                .setAbilities(shadowFactory2.createAbilities())
                .setLootTable(shadowFactory2.createLootTable())
                .setAI(shadowFactory2.createAIBehavior())
                .addPhase(1, 80000)
                .addPhase(2, 40000)
                .build();

        registry.registerTemplate("demon-lord", demonLord);
        Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        System.out.println("Base Demon Lord:");
        displayEnemy(demonLord);
        System.out.println("\nCloned Greater Demon:");
        displayEnemy(greaterDemon);

        System.out.println("\n============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================\n");

        System.out.println("Abstract Factory: Fire, Ice, Shadow themed components");
        System.out.println("Builder: Step-by-step complex enemy construction");
        System.out.println("Factory Method: Inside Builder.build()");
        System.out.println("Prototype: Deep cloning via EnemyRegistry");

        System.out.println("\n=== Demo Complete ===");
    }

    private static void displayEnemy(Enemy enemy) {

        System.out.println("----------------------------------");
        System.out.println("Name: " + enemy.getName());
        System.out.println("Health: " + enemy.getHealth());
        System.out.println("Damage: " + enemy.getDamage());
        System.out.println("Element: " + enemy.getElement());

        System.out.println("Abilities:");
        enemy.getAbilities().forEach(a ->
                System.out.println(" - " + a.getName()));

        System.out.println("----------------------------------\n");
    }
}