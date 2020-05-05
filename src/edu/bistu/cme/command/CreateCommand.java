package edu.bistu.cme.command;

import edu.bistu.cme.BoardScreen;

public class CreateCommand extends Command
{
    private static CreateCommand createCommand;

    protected CreateCommand(BoardScreen boardScreen)
    {
        super(boardScreen);
    }

    @Override
    public void execute()
    {
        boardScreen.create();
    }

    public static CreateCommand getInstance()
    {
        if(createCommand == null)
            createCommand = new CreateCommand(BoardScreen.getInstance());
        return createCommand;
    }
}
