package io.github.lucariatias.ld29.event;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.plugin.Plugin;

import java.util.*;

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

    public void unregisterListener(Listener listener) {
        for (Set<Listener> eventListeners : listeners.values()) {
            if (eventListeners.contains(listener)) {
                eventListeners.remove(listener);
            }
        }
    }

    public void unregisterListeners(Plugin plugin) {
        for (Set<Listener> eventListeners : listeners.values()) {
            Iterator<Listener> iterator = eventListeners.iterator();
            while (iterator.hasNext()) {
                Listener listener = iterator.next();
                if (listener.getPlugin() == plugin) {
                    iterator.remove();
                }
            }
        }
    }

    public void dispatchEvent(Event event) {
        if (!listeners.containsKey(event.getClass())) return;
        Class<? extends Event> clazz = event.getClass();
        while (clazz != null) {
            for (Listener listener : listeners.get(event.getClass())) {
                listener.onEvent(event);
            }
            clazz = (Class<? extends Event>) clazz.getSuperclass();
        }
    }

}
