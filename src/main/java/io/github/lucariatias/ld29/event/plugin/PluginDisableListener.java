package io.github.lucariatias.ld29.event.plugin;

import io.github.lucariatias.ld29.event.Listener;
import io.github.lucariatias.ld29.plugin.Plugin;

public abstract class PluginDisableListener extends Listener<PluginDisableEvent> {

    public PluginDisableListener(Plugin plugin) {
        super(plugin, PluginDisableEvent.class);
    }

    public abstract void onPluginDisable(PluginDisableEvent event);

    @Override
    public void onEvent(PluginDisableEvent event) {
        onPluginDisable(event);
    }

}
