package com.leo.dev.gol.ui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Leo
 */
public class Window implements AbstractWindow {

    private JMenuBar menuBar;
    private JFrame frame;
    private Map<String, JMenu> menus;

    public Window() {
        menus = new HashMap<>();
        menuBar = new JMenuBar();
    }

    @Override
    public void addLine(String menuName, String name, ActionListener handler) {
        JMenu menu = getMenuByName(menuName);
        JMenuItem item = new JMenuItem(name);
        item.setName(name);
        item.addActionListener(handler);
        menu.add(item);
    }

    private JMenu getMenuByName(String name) {
        if (menus.keySet().contains(name)) {
            return menus.get(name);
        }
        //menu not exists
        JMenu menu = new JMenu(name);
        menus.put(name, menu);
        menuBar.add(menu);
        return menu;
    }

    @Override
    public void establish(JFrame frame) {
        this.frame = frame;
        this.frame.setJMenuBar(menuBar);
    }

}
