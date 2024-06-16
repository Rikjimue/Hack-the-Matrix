package main;

import java.awt.Color;

public class Path {
    private Cell[] path;
    private int index;
    private boolean complete;

    public Path(Cell[] path) {
        this.path = path;
        this.index = 0;
        this.complete = false;
    }

    public void incrementIndex() {
        if (index < path.length && !complete) {
            path[index].setColor(Color.GRAY);
            index++;
        }

        if (index == path.length && !complete)  {
            complete = true;
            index--;
        }
    }

    public void resetIndex() {
        if (!complete) {
            for (int i = 0; i < path.length; i++) {
                path[i].setColor(Color.WHITE);
            }
            index = 0;
        }
    }
    
    public Cell[] getPath() {
        return path;
    }
    
    public int getIndex() {
        return index;
    }

    public boolean getComplete() {
        return complete;
    }
}
