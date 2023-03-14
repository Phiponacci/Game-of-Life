package com.leo.dev.gol.main;

import com.leo.dev.gol.life.Clock;
import com.leo.dev.gol.life.IClock;
import com.leo.dev.gol.ui.Window;
import com.leo.dev.gol.world.World;
import edu.emp.gl.gol.model.IWorld;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

/**
 * @author Leo
 */
public class Game extends JFrame {

    private Game() {
        super("Game Of Life");

        Window win = new Window();
        win.establish(this);

        //use lookup here
        IClock clock = new Clock(win);
        IWorld world = new World(clock, win);

        Properties p = new Properties();
        p.setProperty(IWorld.WIDTH, "80");
        p.setProperty(IWorld.HEIGHT, "80");
        world.initializeWorld(p);

        setContentPane((Container) world);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game();
    }

}
