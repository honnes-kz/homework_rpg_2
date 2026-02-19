package com.narxoz.rpg.factory;

import java.util.List;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.FrostBreath;
import com.narxoz.rpg.combat.IceShield;
import com.narxoz.rpg.loot.IceLootTable;
import com.narxoz.rpg.loot.LootTable;

public class IceComponentFactory implements EnemyComponentFactory{

    public List<Ability> createAbilities(){
        return List.of(new FrostBreath(),new IceShield());
    }
    public LootTable createLootTable(){
        return new IceLootTable();
    }
    public String createAI(){
        return "Defensive";
    }
}