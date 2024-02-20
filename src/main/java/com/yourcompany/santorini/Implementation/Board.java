package com.yourcompany.santorini.Implementation;

import com.yourcompany.santorini.Interface.IBoard;

public class Board implements IBoard {
    private final int size = 5; // 假设棋盘是5x5的
    private Grid[][] grids;

    public Board() {
        setupBoard();
    }

    @Override
    public void setupBoard() {
        grids = new Grid[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                grids[x][y] = new Grid(x, y);
            }
        }
    }

    @Override
    public Grid getGrid(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            throw new IllegalArgumentException("Grid coordinates out of bounds");
        }
        return grids[x][y];
    }

    @Override
    public boolean isValidMove(Grid grid) {
        // 此处的实现仅为示例，具体逻辑需根据游戏规则调整
        return !grid.isOccupied() && !grid.hasDome();
    }

    @Override
    public void updateAfterBuild(Grid grid) {
        // 假设build方法已在Grid对象中实现，这里可能不需要额外逻辑
        // 可能需要根据游戏规则进行其他更新，如通知玩家等
    }

    @Override
    public boolean checkWinningCondition() {
        // 此处逻辑需根据具体游戏规则实现，以下为简化示例
        for (Grid[] row : grids) {
            for (Grid grid : row) {
                if (grid.getTowerLevel() == 3) {
                    // 假设达到3层高就赢
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void resetBoard() {
        setupBoard(); // 重新初始化棋盘以重置
    }
}

