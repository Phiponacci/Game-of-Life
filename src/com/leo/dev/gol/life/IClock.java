package com.leo.dev.gol.life;

import com.leo.dev.gol.tools.EventManagement.Listener;

/**
 * @author Leo
 */
public interface IClock {
    void addClockListener(Listener listener);

    void changeFrequency();

    void startTicking(int millisecondsBetweenTicks);

    void stop();

    void tick();
}
