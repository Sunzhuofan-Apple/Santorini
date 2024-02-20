package com.yourcompany.santorini.Interface;

public interface IGrid {
    /**
     * Check if the grid is occupied by a worker or a dome.
     * @return true if the grid is occupied, false otherwise.
     */
    boolean isOccupied();

    /**
     * Check if the grid has a dome.
     * @return true if there is a dome, false otherwise.
     */
    boolean hasDome();

    /**
     * Check if this grid is adjacent to another grid.
     * @param grid The grid to compare adjacency with.
     * @return true if the grid is adjacent, false otherwise.
     */
    boolean isAdjacent(IGrid grid);

    /**
     * Build a level of tower on this grid.
     * This could mean increasing the tower level or placing a dome.
     * @return true if the build action was successful, false otherwise.
     */
    boolean build();

    /**
     * Get the current level of the tower on this grid.
     * @return the current tower level.
     */
    int getTowerLevel();

    /**
     * Set the level of the tower on this grid.
     * @param level The new level of the tower.
     */
    void setTowerLevel(int level);

    // Additional methods to manage the grid state and interactions can be added below.
}
