package com.leo.dev.gol.tools.io;

import edu.emp.gl.gol.model.IPosition;

import java.util.List;

/**
 * @author Leo
 */
public class Memento implements Storable {
    private final List<IPosition> liveCells;

    public Memento(List<IPosition> liveCells) {
        this.liveCells = liveCells;
    }

    @Override
    public Object getSnapshot() {
        return liveCells;
    }
}
