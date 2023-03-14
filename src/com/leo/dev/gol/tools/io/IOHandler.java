package com.leo.dev.gol.tools.io;

/**
 * @author Leo
 */
public interface IOHandler {
    void store(Storable out);

    Storable load();
}
