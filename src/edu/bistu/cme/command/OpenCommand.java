package edu.bistu.cme.command;

import edu.bistu.cme.BoardScreen;

public class OpenCommand extends Command
{
    private static OpenCommand openCommand;

    protected OpenCommand(BoardScreen boardScreen)
    {
        super(boardScreen);
    }

    @Override
    public void execute()
    {
        boardScreen.open();
    }

    public static OpenCommand getInstance()
    {
        if(openCommand == null)
            openCommand = new OpenCommand(BoardScreen.getInstance());
        return openCommand;
    }
}
