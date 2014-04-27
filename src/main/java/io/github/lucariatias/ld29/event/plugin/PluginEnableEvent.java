package io.github.lucariatias.ld29.event.plugin;

import io.github.lucariatias.ld29.event.Cancellable;
import io.github.lucariatias.ld29.event.Event;
import io.github.lucariatias.ld29.plugin.Plugin;

public class PluginEnableEvent extends Event implements Cancellable {

    private Plugin plugin;
    private boolean cancelled;

    public PluginEnableEvent(Plugin plugin) {
        this.plugin = plugin;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
