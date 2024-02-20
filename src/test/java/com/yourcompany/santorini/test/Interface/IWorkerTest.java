package com.yourcompany.santorini.test.Interface;

import com.yourcompany.santorini.Implementation.Grid;
import com.yourcompany.santorini.Implementation.Worker;
import com.yourcompany.santorini.Interface.IWorker;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IWorkerTest {
    private Worker worker;
    private Grid initialGrid;
    private Grid newGrid;

    @Before
    public void setUp() {
        initialGrid = new Grid(0, 0); 
        newGrid = new Grid(1, 1);
        worker = new Worker(1, initialGrid); 
    }

    @Test
    public void testMove() {
        worker.move(newGrid);
        assertEquals("Worker should be moved to the new grid.", newGrid, worker.getGrid());
    }

    @Test
    public void testGetGrid() {
        assertEquals("Initial grid should match the one provided at creation.", initialGrid, worker.getGrid());
    }

    @Test
    public void testGetPlayerID() {
        assertEquals("Player ID should match the one provided at creation.", 1, worker.getPlayerID());
    }

    @Test
    public void testSetPosition() {
        worker.setPosition(newGrid);
        assertEquals("Worker's position should be updated to the new grid.", newGrid, worker.getGrid());
    }

    @Test
    public void testGetTowerLevel() {
        // Assuming setTowerLevel affects the grid's tower level and is reflected in the worker's getTowerLevel method
        initialGrid.setTowerLevel(2);
        assertEquals("Tower level should match the one set on the grid.", 2, worker.getTowerLevel());
    }

    @Test
    public void testBuildTowerOn() {
        boolean success = worker.buildTowerOn(newGrid);
        // Assuming buildTowerOn's success depends on specific conditions, adjust this test as necessary
        assertTrue("Building on the new grid should be successful under correct conditions.", success);
        // Further validation might be necessary depending on how buildTowerOn modifies the grid or game state
    }
}

