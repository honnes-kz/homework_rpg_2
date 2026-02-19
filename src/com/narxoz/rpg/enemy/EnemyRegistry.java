package com.narxoz.rpg.enemy;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collections;

public class EnemyRegistry {
    private final Map<String, Enemy> templates = new HashMap<>();

    public void registerTemplate(String key, Enemy template) {
        templates.put(key, template);
    }

    public Enemy createFromTemplate(String key) {
        Enemy template = templates.get(key);
        if (template == null) throw new IllegalArgumentException("No template for key: " + key);
        return template.clone();
    }

    public Set<String> listTemplates() {
        return Collections.unmodifiableSet(templates.keySet());
    }
}
