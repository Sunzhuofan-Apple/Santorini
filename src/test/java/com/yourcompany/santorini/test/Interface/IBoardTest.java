package com.yourcompany.santorini.test.Interface;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.yourcompany.santorini.Implementation.Board;
import com.yourcompany.santorini.Implementation.Grid;
import com.yourcompany.santorini.Interface.IBoard;

public class IBoardTest {
    private IBoard board;

    @Before
    public void setUp() {
        board = new Board();
        board.setupBoard(); 
    }

    @Test
    public void testSetupBoard() {
        assertNotNull("Board should not be null after setup.", board);
        Grid grid = board.getGrid(0, 0);
        assertNotNull("Grid at (0,0) should not be null.", grid);
    }

    @Test
    public void testGetGrid_ValidCoordinates() {
        Grid grid = board.getGrid(2, 2);
        assertNotNull("Grid at (2,2) should exist.", grid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetGrid_InvalidCoordinates() {
        board.getGrid(-1, -1);
    }

    @Test
    public void testIsValidMove() {
        Grid grid = board.getGrid(1, 1);
        assertTrue("Move should be valid on an unoccupied grid.", board.isValidMove(grid));
    }

    @Test
    public void testUpdateAfterBuild() {
        Grid grid = board.getGrid(1, 1);
        board.updateAfterBuild(grid);
    }

    @Test
    public void testCheckWinningCondition() {
        assertFalse("Winning condition should not be met initially.", board.checkWinningCondition());
    }

    @Test
    public void testResetBoard() {
        board.resetBoard();
        Grid grid = board.getGrid(0, 0);
        assertNotNull("Grid at (0,0) should not be null after reset.", grid);
    }
}
