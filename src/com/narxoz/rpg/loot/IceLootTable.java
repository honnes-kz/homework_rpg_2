package com.narxoz.rpg.loot;

public class IceLootTable implements LootTable {
    private final List<String> items = List.of("Ice Gem", "Frost Scale", "Ice Rune");
    private final int goldDrop = 80;
    private final int xpDrop = 180;
    public List<String> getItems() {
        return new ArrayList<>(items);
    }
    public int getGoldDrop() {
        return goldDrop;
    }
    public int getExperienceDrop() {
        return xpDrop;
    }
    public IceLootTable clone() {
        return new IceLootTable();
    }
}