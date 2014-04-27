package io.github.lucariatias.ld29.event;

public interface Cancellable {

    public boolean isCancelled();

    public void setCancelled(boolean cancel);

}
