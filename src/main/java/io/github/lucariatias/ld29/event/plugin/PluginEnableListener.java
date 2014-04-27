package io.github.lucariatias.ld29.event.plugin;

import io.github.lucariatias.ld29.event.Listener;
import io.github.lucariatias.ld29.plugin.Plugin;

public abstract class PluginEnableListener extends Listener<PluginEnableEvent> {

    public PluginEnableListener(Plugin plugin) {
        super(plugin, PluginEnableEvent.class);
    }

    public abstract void onPluginEnable(PluginEnableEvent event);

    @Override
    public void onEvent(PluginEnableEvent event) {
        onPluginEnable(event);
    }

}
