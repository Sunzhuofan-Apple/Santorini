package com.yourcompany.santorini.Implementation;

import com.yourcompany.santorini.Interface.IPlayer;
import com.yourcompany.santorini.Implementation.Worker;
import com.yourcompany.santorini.Implementation.Grid;


public class Player implements IPlayer {
    private int playerID;
    private Worker[] workers;

    public Player(int playerID) {
        this.playerID = playerID;
        // Assuming the Worker class has a constructor that takes a playerID.
        this.workers = new Worker[]{
            new Worker(playerID, null), 
            new Worker(playerID, null)
        };
    }

    @Override
    public void moveWorker(Worker worker, Grid grid) {
        // Check if the worker belongs to the player
        if (worker.getPlayerID() != this.playerID) {
            throw new IllegalArgumentException("This worker does not belong to the player.");
        }

        if (!grid.isOccupied()) {
            worker.setPosition(grid);
        } else {
            throw new IllegalStateException("The grid is occupied.");
        }
    }

    @Override
    public boolean checkWinning() {
        for (Worker worker : this.workers) {
            Grid grid = worker.getGrid();
            if (grid != null && grid.getTowerLevel() == 3) {
                return true;
            }
        }
        return false;
    }
    

    @Override
    public int getPlayerID() {
        return this.playerID;
    }

    @Override
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    @Override
    public Worker[] getWorkers() {
        return this.workers;
    }

    @Override
    public void setWorkers(Worker[] workers) {
        if (workers.length != 2) {
            throw new IllegalArgumentException("A player must have exactly two workers.");
        }
        this.workers = workers;
    }
}
