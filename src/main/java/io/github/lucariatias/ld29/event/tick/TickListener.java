package io.github.lucariatias.ld29.event.tick;

import io.github.lucariatias.ld29.event.Listener;

public abstract class TickListener extends Listener<TickEvent> {

    public TickListener() {
        super(TickEvent.class);
    }

    @Override
    public void onEvent(TickEvent event) {
        onTick(event);
    }

    public abstract void onTick(TickEvent event);

}
