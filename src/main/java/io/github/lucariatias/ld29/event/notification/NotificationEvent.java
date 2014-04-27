package io.github.lucariatias.ld29.event.notification;

import io.github.lucariatias.ld29.event.Cancellable;
import io.github.lucariatias.ld29.event.Event;

public class NotificationEvent extends Event implements Cancellable {

    private String message;
    private boolean cancelled;

    public NotificationEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
