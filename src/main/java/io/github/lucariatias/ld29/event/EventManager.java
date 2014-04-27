package io.github.lucariatias.ld29.event;

import io.github.lucariatias.ld29.Descent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EventManager {

    private Descent descent;

    private Map<Class<? extends Event>, Set<Listener>> listeners = new HashMap<>();

    public EventManager(Descent descent) {
        this.descent = descent;
    }

    public boolean registerListener(Listener listener) {
        if (!listeners.containsKey(listener.getEvent())) {
            listeners.put(listener.getEvent(), new HashSet<Listener>());
        }
        return listeners.get(listener.getEvent()).add(listener);
    }

    public void dispatchEvent(Event event) {
        if (!listeners.containsKey(event.getClass())) return;
        for (Listener listener : listeners.get(event.getClass())) {
            listener.onEvent(event);
        }
    }

}
