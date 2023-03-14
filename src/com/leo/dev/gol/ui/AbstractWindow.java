package com.leo.dev.gol.ui;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Leo
 */
public interface AbstractWindow {
    void addLine(String menuName, String name, ActionListener handler);

    void establish(JFrame frame);
}
