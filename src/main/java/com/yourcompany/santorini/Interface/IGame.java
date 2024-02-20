package com.yourcompany.santorini.Interface;

public interface IGame {
    /**
     * Initializes the game, setting up any necessary components like the board, players, etc.
     */
    void initializeGame();

    /**
     * Starts the game, allowing players to take turns and make moves.
     */
    void startGame();

    /**
     * Ends the current game, performing any necessary cleanup or finalization.
     */
    void endGame();

    /**
     * Processes a player's move action.
     * @param playerID The ID of the player making the move.
     * @param workerID The ID of the worker that is being moved.
     * @param gridX The x-coordinate of the grid to move to.
     * @param gridY The y-coordinate of the grid to move to.
     * @return true if the move was successful, false otherwise.
     */
    boolean movePlayerWorker(int playerID, int workerID, int gridX, int gridY);

    /**
     * Processes a player's build action.
     * @param playerID The ID of the player making the build.
     * @param workerID The ID of the worker that is building.
     * @param gridX The x-coordinate of the grid to build on.
     * @param gridY The y-coordinate of the grid to build on.
     * @return true if the build was successful, false otherwise.
     */
    boolean buildAtGrid(int playerID, int workerID, int gridX, int gridY);

    /**
     * Checks if the game has ended and if there is a winner.
     * @return true if the game has ended and there is a winner, false if the game is still ongoing.
     */
    boolean checkForWinner();

    /**
     * Gets the current status of the game (e.g., ongoing, ended).
     * @return A string representing the current game status.
     */
    String getGameStatus();

    /**
     * Resets the game to its initial state, ready to be started again.
     */
    void resetGame();
}
