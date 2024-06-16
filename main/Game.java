package main;

import Panels.GamePanel;
import Panels.MenuPanel;

/* TODO:
May god help anyone who looks at this code.

 * High:
 * Cap Frame Rate
 * 
 * Medium:
 * Refactor inTarget()
 * Refactor to camelCase
 * 
 * Low:
 * Make code more readable
 * Add starting animation
 * 
 * Impossible:
 * Make code not shit
 */

public class Game {
    private GamePanel game_panel;
    private MenuPanel menu_panel;
    private GameWindow window;

    private Game() {
        window = new GameWindow();
    }

    private void loop() {
        while (true) {
            window.getPanel().repaint();
        }
    }

    public static void play() {
        new Game().loop();
    }

    public static void main(String[] args) {
        play();
    }
}
