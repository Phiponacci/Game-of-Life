package com.leo.dev.gol.tools.io;

import java.io.Serializable;

/**
 * @author Leo
 */
public interface Storable extends Serializable {
    Object getSnapshot();
}
