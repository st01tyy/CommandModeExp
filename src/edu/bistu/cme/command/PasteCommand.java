package edu.bistu.cme.command;

import edu.bistu.cme.BoardScreen;

public class PasteCommand extends Command
{
    private static PasteCommand pasteCommand;

    protected PasteCommand(BoardScreen boardScreen)
    {
        super(boardScreen);
    }

    @Override
    public void execute()
    {
        boardScreen.paste();
    }

    public static PasteCommand getInstance()
    {
        if(pasteCommand == null)
            pasteCommand = new PasteCommand(BoardScreen.getInstance());
        return pasteCommand;
    }
}
