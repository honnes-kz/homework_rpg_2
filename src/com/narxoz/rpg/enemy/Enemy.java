package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;

import java.util.List;
import java.util.Map;

public interface Enemy extends Cloneable{

    String getName();
    int getHealth();
    int getDamage();
    int getDefense();
    int getSpeed();
    String getElement();

    List<Ability> getAbilities();
    LootTable getLootTable();
    String getAIBehavior();
    Map<Integer, Integer> getPhases();
    void displayInfo();
    Enemy clone();
    
}
