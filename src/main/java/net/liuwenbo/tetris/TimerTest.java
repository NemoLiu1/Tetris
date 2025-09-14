package net.liuwenbo.tetris;

import net.liuwenbo.tetris.tetrminos.T;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
}
