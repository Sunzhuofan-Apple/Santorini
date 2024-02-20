package com.yourcompany.santorini.Interface;

import com.yourcompany.santorini.Implementation.Grid;

public interface IBoard {
    /**
     * Initializes the board with a specified size.
     */
    void setupBoard();

    /**
     * Returns the grid object at the specified coordinates.
     * @param x The x coordinate of the grid.
     * @param y The y coordinate of the grid.
     * @return The grid at the specified location.
     */
    Grid getGrid(int x, int y);

    /**
     * Checks if a move to the specified grid is valid.
     * @param grid The target grid for the move.
     * @return true if the move is valid, false otherwise.
     */
    boolean isValidMove(Grid grid);

    /**
     * Updates the board after a tower has been built on a grid.
     * @param grid The grid where the tower has been built.
     */
    void updateAfterBuild(Grid grid);

    /**
     * Checks if any player has won based on the current state of the board.
     * @return true if a winning condition is met, false otherwise.
     */
    boolean checkWinningCondition();

    /**
     * Resets the board to its initial state.
     */
    void resetBoard();
}
