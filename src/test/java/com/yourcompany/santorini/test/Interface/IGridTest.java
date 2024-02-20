package com.yourcompany.santorini.test.Interface;

import com.yourcompany.santorini.Implementation.Grid;
import com.yourcompany.santorini.Interface.IGrid;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IGridTest {
    private IGrid grid;
    private IGrid adjacentGrid;
    private IGrid nonAdjacentGrid;

    @Before
    public void setUp() {
        grid = new Grid(0, 0); // Assuming Grid has a constructor that accepts coordinates
        adjacentGrid = new Grid(0, 1); // Assuming this grid is considered adjacent
        nonAdjacentGrid = new Grid(2, 2); // Assuming this grid is not considered adjacent
    }

    @Test
    public void testIsOccupied_InitiallyFalse() {
        assertFalse("Grid should not be occupied initially.", grid.isOccupied());
    }

    @Test
    public void testHasDome_InitiallyFalse() {
        assertFalse("Grid should not have a dome initially.", grid.hasDome());
    }

    @Test
    public void testIsAdjacent_Adjacent() {
        assertTrue("Grid should be considered adjacent to its neighbor.", grid.isAdjacent(adjacentGrid));
    }

    @Test
    public void testIsAdjacent_NonAdjacent() {
        assertFalse("Grid should not be considered adjacent to a far away grid.", grid.isAdjacent(nonAdjacentGrid));
    }

    @Test
    public void testBuild_IncreasesLevel() {
        assertTrue("Building on the grid should be successful.", grid.build());
        assertEquals("The tower level should be increased.", 1, grid.getTowerLevel());
    }

    @Test
    public void testSetTowerLevel() {
        grid.setTowerLevel(2);
        assertEquals("The tower level should be set correctly.", 2, grid.getTowerLevel());
    }
}
