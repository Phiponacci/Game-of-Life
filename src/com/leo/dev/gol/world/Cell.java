package com.leo.dev.gol.world;

import com.leo.dev.gol.tools.Positioning.Position2D;
import edu.emp.gl.gol.model.ICell;
import edu.emp.gl.gol.model.IPosition;
import edu.emp.gl.gol.model.IWorld;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Leo
 */
public class Cell implements ICell, Serializable {

    public static final int DEFAULT_CELL_SIZE = 10;
    public static final int DEFAULT_SPACE = 11;
    private static final Color LIVE_COLOR = Color.RED;
    private static final Color DEAD_COLOR = Color.LIGHT_GRAY;
    private static final Color BORDER_COLOR = Color.ORANGE;
    private final Position2D pos;
    private final IWorld world;
    private ICell.State currentState;
    private ICell.State futureState;

    public Cell(IWorld world, IPosition pos, State state) {
        this.world = world;
        this.pos = (Position2D) pos;
        setState(state);

    }

    @Override
    public IPosition getPosition() {
        return pos;
    }

    @Override
    public State getState() {
        return this.currentState;
    }

    @Override
    public void setState(State s) {
        this.currentState = s;
    }

    /**
     * first pass to identify future state of current cell --> game rules
     */
    @Override
    public void beforeEvolve() {
        int livingNeighbors = 0;
        List<ICell> neighbors = this.world.getNeigbors(this);

        livingNeighbors = (int) neighbors.stream().filter(c -> (c.getState() == ICell.State.ALIVE)).count();

        switch (this.currentState) {
            case ALIVE:
                if (livingNeighbors == 2 || livingNeighbors == 3) {
                    this.futureState = this.currentState;
                    break;
                }
                this.futureState = ICell.State.DEAD;
                break;
            case DEAD:
                if (livingNeighbors == 3) {
                    this.futureState = ICell.State.ALIVE;
                    break;
                }
                this.futureState = this.currentState;
                break;
        }
    }

    /**
     * second pass to maintain the state of the cell --> perform state
     * transition
     */
    @Override
    public void evolve() {
        setState(futureState);
    }

    @Override
    public void postEvolve() {
    }

    public void onClick() {
        if (getState() == State.ALIVE) {
            setState(State.DEAD);
        } else {
            setState(State.ALIVE);
        }
    }

    public void render(Graphics g, int ratio) {
        //draw inside the cell
        g.setColor(getState() == ICell.State.ALIVE ? LIVE_COLOR : DEAD_COLOR);
        g.fillRect(
                getPosition().getX() * DEFAULT_SPACE * ratio,
                getPosition().getY() * DEFAULT_SPACE * ratio,
                DEFAULT_CELL_SIZE * ratio,
                DEFAULT_CELL_SIZE * ratio
        );

        //draw the borders
        g.setColor(BORDER_COLOR);
        g.drawRect(
                getPosition().getX() * DEFAULT_SPACE * ratio,
                getPosition().getY() * DEFAULT_SPACE * ratio,
                DEFAULT_CELL_SIZE * ratio,
                DEFAULT_CELL_SIZE * ratio
        );
    }

}
