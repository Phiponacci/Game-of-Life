package com.leo.dev.gol.tools.EventManagement;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Leo
 */
public class Publisher {
    private final Set<Listener> listeners;

    public Publisher() {
        listeners = new HashSet<>();
    }

    synchronized public void subscribe(Listener listener) {
        listeners.add(listener);

    }

    public void publish(Object msg) {
        for (Listener listener : listeners) {
            listener.update(this, msg);
        }
    }
}
