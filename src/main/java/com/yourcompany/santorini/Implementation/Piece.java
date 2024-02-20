package com.yourcompany.santorini.Implementation;
public abstract class Piece {
    protected Grid position;

    public Piece(Grid position) {
        this.position = position;
    }

    public Grid getPosition() {
        return position;
    }

    public void setPosition(Grid position) {
        this.position = position;
    }
}


