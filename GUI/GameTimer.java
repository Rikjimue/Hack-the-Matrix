package GUI;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import main.GameWindow;
import Utils.FontUtils;

public class GameTimer extends DrawableObject {
    private GameWindow window;
    private long millisecondsLeft;
    private Timer timer;
    private String time;
    private boolean timerStarted;
    private int x_cord;
    private int y_cord;

    public GameTimer(GameWindow window, Component panel, Grid grid, int seconds) {
        super(panel, null, 100, grid.getLocation()[1] + 44 * grid.getMatrix().getMatrix().length + 25);
        this.window = window;
        x_cord = super.getLocation()[0];
        y_cord = super.getLocation()[1];
        this.millisecondsLeft = (long) seconds * 1000;
    }

    public void startTimer() {
        timerStarted = true;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (millisecondsLeft >= 0) {
                    time = millisecondsLeft/1000 + ":" + (millisecondsLeft % 1000) / 10;
                    millisecondsLeft--;
                } else {
                    stopTimer();
                }
            }
        }, 0, 1);
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            window.setPanel(4);
        }
    }

    public void forceStopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public boolean getTimerStarted() {
        return timerStarted;
    }

    public void drawImage(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setFont(FontUtils.getTextFont(24f));
        if (!timerStarted) {
            g2.setColor(Color.WHITE);
            g2.drawRect(x_cord, y_cord, 200 , 40);
            g2.drawString("Circuit Stable", x_cord + 30, y_cord + 30);
        }
        else {
            g2.setColor(Color.RED);
            g2.drawRect(x_cord, y_cord, 200 , 40);
            g2.drawString("Overload: " + time, x_cord + 20, y_cord + 30);
        }
    }
}