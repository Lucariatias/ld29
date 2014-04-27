package io.github.lucariatias.ld29.plugin;

import io.github.lucariatias.ld29.Descent;

import java.util.Map;

public abstract class Plugin {

    private Descent descent;

    private String name;

    public void setup(Descent descent, Map<String, Object> properties) {
        this.descent = descent;
        this.name = (String) properties.get("name");
    }

    public void onEnable() {}

    public void onDisable() {}

    public Descent getDescent() {
        return descent;
    }

    public String getName() {
        return name;
    }
}
