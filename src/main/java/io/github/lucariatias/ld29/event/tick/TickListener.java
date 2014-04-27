package io.github.lucariatias.ld29.event.tick;

import io.github.lucariatias.ld29.event.Listener;
import io.github.lucariatias.ld29.plugin.Plugin;

public abstract class TickListener extends Listener<TickEvent> {

    public TickListener(Plugin plugin) {
        super(plugin, TickEvent.class);
    }

    @Override
    public void onEvent(TickEvent event) {
        onTick(event);
    }

    public abstract void onTick(TickEvent event);

}
