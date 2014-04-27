package io.github.lucariatias.ld29.event.plugin;

import io.github.lucariatias.ld29.event.Event;
import io.github.lucariatias.ld29.plugin.Plugin;

public class PluginDisableEvent extends Event {

    private Plugin plugin;

    public PluginDisableEvent(Plugin plugin) {
        this.plugin = plugin;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

}
