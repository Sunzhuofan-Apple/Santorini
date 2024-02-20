package com.yourcompany.santorini.Interface;

import com.yourcompany.santorini.Implementation.Grid;

public interface IWorker {
    /**
     * Move the worker to a new grid position.
     * @param grid The new grid position for the worker.
     */
    void move(Grid grid);

    /**
     * Get the grid where the worker is currently located.
     * @return The current grid of the worker.
     */
    Grid getGrid();

    /**
     * Get the player ID of the worker's owner.
     * @return The player ID associated with the worker.
     */
    int getPlayerID();

    /**
     * Set the position of the worker.
     * @param grid The new grid to set as the worker's position.
     */
    void setPosition(Grid grid);

    /**
     * Get the level of the tower where the worker is currently located.
     * @return The tower level at the worker's current position.
     */
    int getTowerLevel();

    /**
     * Build a tower segment on the specified grid.
     * This could be adding a block or placing a dome, based on the game rules.
     * @param grid The grid on which to build the tower segment.
     * @return true if the build action was successful, false otherwise.
     */
    boolean buildTowerOn(Grid grid);
}

