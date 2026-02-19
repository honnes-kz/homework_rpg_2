package com.narxoz.rpg.factory;

import java.util.List;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.FireShield;
import com.narxoz.rpg.combat.FlameBreath;
import com.narxoz.rpg.loot.FireLootTable;
import com.narxoz.rpg.loot.LootTable;

public class FireComponentFactory implements EnemyComponentFactory{

    public List<Ability> createAbilities(){
        return List.of(new FlameBreath(),new FireShield());
    }
    public LootTable createLootTable(){
        return new FireLootTable();
    }
    public String createAI(){
        return "Aggresive";
    }

}