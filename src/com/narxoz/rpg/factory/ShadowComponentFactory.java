package com.narxoz.rpg.factory;

import java.util.List;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.ShadowStrike;
import com.narxoz.rpg.combat.Vanish;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.ShadowLootTable;

public class ShadowComponentFactory implements EnemyComponentFactory{

    public List<Ability> createAbilities(){
        return List.of(new ShadowStrike(),new Vanish());
    }
    public LootTable createLootTable(){
        return new ShadowLootTable();
    }
    public String createAI(){
        return "Tactical";
    }
}