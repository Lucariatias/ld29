package io.github.lucariatias.ld29.event;

import io.github.lucariatias.ld29.plugin.Plugin;

public abstract class Listener<T extends Event> {

    private Plugin plugin;

    private Class<T> event;

    public Listener(Plugin plugin, Class<T> event) {
        this.plugin = plugin;
        this.event = event;
    }

    public abstract void onEvent(T event);

    public Class<T> getEvent() {
        return event;
    }

    public Plugin getPlugin() {
        return plugin;
    }

}
