package com.leo.dev.gol.tools.io;

import javax.swing.*;
import java.io.*;

/**
 * @author Leo
 */
public class PatchIOHandler implements IOHandler {

    @Override
    public void store(Storable patch) {
        try {
            FileOutputStream out = new FileOutputStream(
                    FileManager.userSelected(".", ".patch", "Patch File", "Store"));
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(patch);
            oos.close();
            out.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Write Failed!",
                    "The Game of Life", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Storable load() {
        Storable memento = null;
        try {
            FileInputStream in = new FileInputStream(
                    FileManager.userSelected(".", ".patch", "Patch File", "Load"));
            ObjectInputStream source = new ObjectInputStream(in);
            memento = (Storable) (source.readObject());
            source.close();
            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Read Failed!",
                    "The Game of Life", JOptionPane.ERROR_MESSAGE);
        }
        return memento;
    }

}
