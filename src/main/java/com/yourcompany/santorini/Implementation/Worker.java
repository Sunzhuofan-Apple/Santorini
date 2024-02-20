package com.yourcompany.santorini.Implementation;
public class Worker {
    private int playerID;
    private Grid position; 

    public Worker(int playerID, Grid initialPosition) {
        this.playerID = playerID;
        this.position = initialPosition;
    }
    public void move(Grid grid) {
        if (this.position.isAdjacent(grid) && !grid.isOccupied()) {
            this.position = grid;
        } else {
            throw new IllegalStateException("Cannot move to an occupied or non-adjacent grid.");
        }
    }

    public Grid getGrid() {
        return this.position;
    }

    public int getPlayerID() {
        return this.playerID;
    }

    public void setPosition(Grid grid) {
        this.position = grid;
    }

    public int getTowerLevel() {
        return this.position.getTowerLevel();
    }

    public boolean buildTowerOn(Grid grid) {
        if (this.position.isAdjacent(grid) && !grid.isOccupied() && !grid.hasDome()) {
            return grid.build();
        } else {
            return false;
        }
    }
}



