package com.yourcompany.santorini.test.Interface;

import com.yourcompany.santorini.Implementation.Game;
import com.yourcompany.santorini.Interface.IGame;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IGameTest {
    private IGame game;

    @Before
    public void setUp() {
        game = new Game(2); 
    }

    @Test
    public void testInitializeGame() {
        game.initializeGame();
        assertEquals("Initialized", game.getGameStatus());
    }

    @Test
    public void testStartGame() {
        game.initializeGame();
        game.startGame();
        assertEquals("In Progress", game.getGameStatus());
    }

    @Test
    public void testEndGame() {
        game.initializeGame();
        game.startGame();
        game.endGame();
        assertEquals("Ended", game.getGameStatus());
    }

    @Test
    public void testMovePlayerWorker() {
        game.initializeGame();
        game.startGame();
        assertTrue(game.movePlayerWorker(0, 0, 1, 1));
    }

    @Test
public void testBuildAtGrid() {
    game.initializeGame();
    game.startGame();
    game.movePlayerWorker(0, 0, 0, 2); 
    assertTrue("Building at grid (1, 2) should be successful.", game.buildAtGrid(0, 0, 1, 2));
}


    @Test
    public void testCheckForWinner() {
        game.initializeGame();
        game.startGame();
        assertFalse(game.checkForWinner());
    }

    @Test
    public void testResetGame() {
        game.initializeGame();
        game.startGame();
        game.resetGame();
        assertEquals("Initialized", game.getGameStatus());
    }
}


