package io.github.lucariatias.ld29.event.plugin;

import io.github.lucariatias.ld29.event.Listener;

public abstract class PluginEnableListener extends Listener<PluginEnableEvent> {

    public PluginEnableListener() {
        super(PluginEnableEvent.class);
    }

    public abstract void onPluginEnable(PluginEnableEvent event);

    @Override
    public void onEvent(PluginEnableEvent event) {
        onPluginEnable(event);
    }

}
