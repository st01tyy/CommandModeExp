package edu.bistu.cme.command;

import edu.bistu.cme.BoardScreen;

public class CopyCommand extends Command
{
    private static CopyCommand copyCommand;

    protected CopyCommand(BoardScreen boardScreen)
    {
        super(boardScreen);
    }

    @Override
    public void execute()
    {
        boardScreen.copy();
    }

    public static CopyCommand getInstance()
    {
        if(copyCommand == null)
            copyCommand = new CopyCommand(BoardScreen.getInstance());
        return copyCommand;
    }
}
