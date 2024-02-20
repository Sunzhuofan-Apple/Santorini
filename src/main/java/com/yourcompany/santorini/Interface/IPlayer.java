package com.yourcompany.santorini.Interface;

import com.yourcompany.santorini.Implementation.Grid;
import com.yourcompany.santorini.Implementation.Worker;
public interface IPlayer {
    /**
     * Move the worker for the player
     * Effect: update this worker's position
     * @param worker The worker to be moved
     * @param grid The updated grid of that worker
     */
    void moveWorker(Worker worker, Grid grid);

    /**
     * @return The work(player) is winning
     */
    boolean checkWinning();

    /**
     * Get the current playerid
     * @return The current player id
     */
    int getPlayerID();

    /**
     * give a playerid for the game
     * @param playerID 
     */
    void setPlayerID(int playerID);

    /**
     * @return The two workers the player has
     */
    Worker[] getWorkers();

    /**
     * Set the new copied worker under the original player
     * @param workers
     */
    void setWorkers(Worker[] workers);

}

