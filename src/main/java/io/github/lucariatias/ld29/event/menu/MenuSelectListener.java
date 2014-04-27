package io.github.lucariatias.ld29.event.menu;


import io.github.lucariatias.ld29.event.Listener;

public abstract class MenuSelectListener extends Listener<MenuSelectEvent> {

    public MenuSelectListener() {
        super(MenuSelectEvent.class);
    }

    @Override
    public void onEvent(MenuSelectEvent event) {
        onMenuSelect(event);
    }

    public abstract void onMenuSelect(MenuSelectEvent event);

}
