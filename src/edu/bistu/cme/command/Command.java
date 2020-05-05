package edu.bistu.cme.command;

import edu.bistu.cme.BoardScreen;

abstract public class Command
{
    protected BoardScreen boardScreen;

    protected Command(BoardScreen boardScreen)
    {
        this.boardScreen = boardScreen;
    }

    abstract public void execute();

    public void undo()
    {
        boardScreen.undo();
    }
}
