package io.github.lucariatias.ld29.menu;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.event.menu.MenuSelectEvent;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Menu extends JPanel {

    private Descent descent;

    private String title;
    private List<MenuItem> menuItems = new ArrayList<>();

    private static final int MENU_ITEM_WIDTH = 384;

    public Menu(Descent descent) {
        this.descent = descent;
        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                Font font = Menu.this.descent.getTitleFont().deriveFont(16.0F);
                if (SwingUtilities.isLeftMouseButton(event)) {
                    int x = (getWidth() - MENU_ITEM_WIDTH) / 2;
                    int y = 128;
                    for (MenuItem menuItem : getMenuItems()) {
                        Point mouse = MouseInfo.getPointerInfo().getLocation();
                        if (mouse.getX() - getLocationOnScreen().getX() >= x && mouse.getY() - getLocationOnScreen().getY() >= y && mouse.getX() - getLocationOnScreen().getX() <= getWidth() - x && mouse.getY() - getLocationOnScreen().getY() <= y + 32 + getFontMetrics(font).getMaxAscent()) {
                            MenuSelectEvent menuSelectEvent = new MenuSelectEvent(Menu.this, menuItem);
                            Menu.this.descent.getEventManager().dispatchEvent(menuSelectEvent);
                            if (!menuSelectEvent.isCancelled()) {
                                menuSelectEvent.getMenuItem().doSelect();
                            }
                            return;
                        }
                        y += 1.5 * (32 + getFontMetrics(font).getMaxAscent());
                    }
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setFont(descent.getTitleFont().deriveFont(48.0F));
        graphics.setColor(Color.WHITE);
        graphics.drawString(title, (getWidth() - graphics.getFontMetrics().charsWidth(title.toCharArray(), 0, title.length())) / 2, (graphics.getFontMetrics().getLeading() + graphics.getFontMetrics().getMaxAscent()) * 2);
        graphics.setFont(descent.getTitleFont().deriveFont(16.0F));
        int x = (getWidth() - MENU_ITEM_WIDTH) / 2;
        int y = 128;
        for (MenuItem menuItem : getMenuItems()) {
            Point mouse = MouseInfo.getPointerInfo().getLocation();
            if (mouse.getX() - getLocationOnScreen().getX() >= x && mouse.getY() - getLocationOnScreen().getY() >= y && mouse.getX() - getLocationOnScreen().getX() <= getWidth() - x && mouse.getY() - getLocationOnScreen().getY() <= y + 32 + graphics.getFontMetrics().getMaxAscent()) {
                graphics.setColor(Color.RED);
                graphics.fillRoundRect(x - 8, y - 8, MENU_ITEM_WIDTH + 16, 32 + graphics.getFontMetrics().getMaxAscent() + 16, 16, 16);
                graphics.setColor(Color.BLACK);
                graphics.fillRoundRect(x + 8, y + 8, MENU_ITEM_WIDTH - 16, 32 + graphics.getFontMetrics().getMaxAscent() - 16, 16, 16);
                graphics.setColor(Color.WHITE);
            } else {
                graphics.setColor(Color.WHITE);
            }
            graphics.drawRect(x, y, MENU_ITEM_WIDTH, 32 + graphics.getFontMetrics().getMaxAscent());
            graphics.drawString(menuItem.getTitle(), (getWidth() - graphics.getFontMetrics().charsWidth(menuItem.getTitle().toCharArray(), 0, menuItem.getTitle().length())) / 2, 16 + graphics.getFontMetrics().getAscent() + y);
            y += 1.5 * (32 + graphics.getFontMetrics().getMaxAscent());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void addMenuItem(String title, Runnable runnable) {
        addMenuItem(new MenuItem(title, runnable));
    }

}
