package io.github.lucariatias.ld29.event.notification;

import io.github.lucariatias.ld29.event.Listener;
import io.github.lucariatias.ld29.plugin.Plugin;

public abstract class NotificationListener extends Listener<NotificationEvent> {

    public NotificationListener(Plugin plugin) {
        super(plugin, NotificationEvent.class);
    }

    public abstract void onNotification(NotificationEvent event);

    @Override
    public void onEvent(NotificationEvent event) {
        onNotification(event);
    }

}
