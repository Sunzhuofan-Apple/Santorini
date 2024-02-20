package com.yourcompany.santorini.test.Interface;

import com.yourcompany.santorini.Implementation.Grid;
import com.yourcompany.santorini.Implementation.Player;
import com.yourcompany.santorini.Implementation.Worker;
import com.yourcompany.santorini.Interface.IPlayer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPlayerTest {
    private IPlayer player;
    private Worker worker1;
    private Worker worker2;
    private Grid initialGrid;
    private Grid targetGrid;

    @Before
    public void setUp() {
        player = new Player(1); 
        initialGrid = new Grid(0, 0); 
        targetGrid = new Grid(1, 1);
        worker1 = new Worker(1, initialGrid);
        worker2 = new Worker(1, initialGrid);
        player.setWorkers(new Worker[]{worker1, worker2});
    }

    @Test
    public void testMoveWorker() {
        assertEquals(initialGrid, worker1.getGrid());

        player.moveWorker(worker1, targetGrid);
        
        assertEquals(targetGrid, worker1.getGrid());
    }

    @Test
    public void testCheckWinning() {
        assertFalse(player.checkWinning());
        
        targetGrid.setTowerLevel(3);
        worker1.setPosition(targetGrid); 
        
        assertTrue(player.checkWinning());
    }

    @Test
    public void testGetAndSetPlayerID() {
        assertEquals(1, player.getPlayerID());
        
        player.setPlayerID(2);
        assertEquals(2, player.getPlayerID());
    }

    @Test
    public void testGetAndSetWorkers() {
        Worker[] workers = player.getWorkers();
        assertNotNull(workers);
        assertEquals(2, workers.length);
        
        Worker newWorker1 = new Worker(2, targetGrid);
        Worker newWorker2 = new Worker(2, targetGrid);
        player.setWorkers(new Worker[]{newWorker1, newWorker2});
        
        workers = player.getWorkers();
        assertArrayEquals(new Worker[]{newWorker1, newWorker2}, workers);
    }
}

