package com.yourcompany.santorini.Implementation;

import com.yourcompany.santorini.Interface.IGrid;

public class Grid implements IGrid {
    private int x, y; 
    private boolean isOccupied; 
    private boolean hasDome; 
    private int towerLevel; 

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        this.isOccupied = false;
        this.hasDome = false;
        this.towerLevel = 0;
    }

    @Override
    public boolean isOccupied() {
        return this.isOccupied;
    }

    @Override
    public boolean hasDome() {
        return this.hasDome;
    }

    @Override
    public boolean isAdjacent(IGrid grid) {
        if (!(grid instanceof Grid)) {
            return false;
        }
        Grid otherGrid = (Grid) grid;
        int dx = Math.abs(this.x - otherGrid.x);
        int dy = Math.abs(this.y - otherGrid.y);
        return (dx <= 1 && dy <= 1) && !(dx == 0 && dy == 0);
    }

    @Override
    public boolean build() {
        if (this.hasDome) {
            return false;
        }
        if (this.towerLevel < 3) {
            this.towerLevel++;
            return true;
        } else {
            this.hasDome = true;
            return true;
        }
    }

    @Override
    public int getTowerLevel() {
        return this.towerLevel;
    }

    @Override
    public void setTowerLevel(int level) {
        if (level >= 0 && level <= 3) {
            this.towerLevel = level;
        } else {
            throw new IllegalArgumentException("Invalid tower level: " + level);
        }
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

