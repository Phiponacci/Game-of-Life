package com.leo.dev.gol.tools.Positioning;

import edu.emp.gl.gol.model.IPosition;

import java.io.Serializable;

/**
 * @author Leo
 */
public class Position2D implements IPosition, Serializable {
    private final int x;
    private final int y;

    public Position2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getZ() {
        return 0;
    }
}
