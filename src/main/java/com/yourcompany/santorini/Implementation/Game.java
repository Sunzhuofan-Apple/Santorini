package com.yourcompany.santorini.Implementation;

import com.yourcompany.santorini.Interface.IGame;

public class Game implements IGame {
    private Board board;
    private Player[] players; 
    private int currentPlayerIndex = 0;
    private String gameStatus = "Not Started";

    public Game(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player(i);
        }
        board = new Board();
    }

    @Override
    public void initializeGame() {
        board.setupBoard();
        gameStatus = "Initialized";
    }

    @Override
    public void startGame() {
        if (!"Initialized".equals(gameStatus)) {
            throw new IllegalStateException("Game must be initialized before it can be started.");
        }
        gameStatus = "In Progress";
        currentPlayerIndex = 0; 
    }

    @Override
    public void endGame() {
        gameStatus = "Ended";
    }

    @Override
    public boolean movePlayerWorker(int playerID, int workerID, int gridX, int gridY) {
        if (!"In Progress".equals(gameStatus)) {
            return false; 
        }
        Player currentPlayer = players[currentPlayerIndex];
        if (currentPlayer.getPlayerID() != playerID) {
            return false; 
        }
        Grid targetGrid = board.getGrid(gridX, gridY);
        Worker worker = currentPlayer.getWorkers()[workerID];
        try {
            currentPlayer.moveWorker(worker, targetGrid);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean buildAtGrid(int playerID, int workerID, int gridX, int gridY) {
        if (!"In Progress".equals(gameStatus)) {
            return false; 
        }
        Player currentPlayer = players[currentPlayerIndex];
        if (currentPlayer.getPlayerID() != playerID) {
            return false; 
        }
        Grid targetGrid = board.getGrid(gridX, gridY);
        Worker worker = currentPlayer.getWorkers()[workerID];
        try {
            return worker.buildTowerOn(targetGrid);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean checkForWinner() {
        for (Player player : players) {
            if (player.checkWinning()) {
                gameStatus = "Ended";
                return true;
            }
        }
        return false;
    }

    @Override
    public String getGameStatus() {
        return gameStatus;
    }

    @Override
    public void resetGame() {
        initializeGame(); 
        gameStatus = "Initialized";
    }
    private void switchToNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }
}

