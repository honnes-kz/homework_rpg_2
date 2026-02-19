package com.narxoz.rpg.builder;

public class BossEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health = 0;
    private int damage = 0;
    private int defense = 0;
    private int speed = 0;
    private String element;
    
    private List<Ability> abilities = new ArrayList<>();
    private Map<Integer, Integer> phases = new HashMap<>();
    private LootTable loot;
    private String ai;

    public EnemyBuilder setName(String name) {
        this.name = name; return this;
    }
    public EnemyBuilder setHealth(int health) {
        this.health = health; return this;
    }
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage; return this;
    }
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense; return this;
    }
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed; return this;
    }
    public EnemyBuilder setElement(String element) {
        this.element = element; return this;
    }
    public EnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability); return this;
    }
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = new ArrayList<>(abilities); return this;
    }
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold); return this;
    }
    public EnemyBuilder setLootTable(LootTable loot) {
        this.loot = loot; return this;
    }
    public EnemyBuilder setAI(String ai) {
        this.ai = ai; return this;
    }

    public Enemy build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Name must be set");
        }
        if (health <= 0) {
            throw new IllegalStateException("Health must be positive");
        }
        return new DragonBoss(name, health, damage, defense, speed,
                              element, abilities, loot, ai, phases);
    }
}