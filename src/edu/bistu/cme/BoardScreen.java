package edu.bistu.cme;

public class BoardScreen
{
    private static BoardScreen boardScreen;

    private BoardScreen(){}

    public void open()
    {
        OperationRecord operationRecord = new OperationRecord(Operation.OPEN);
        System.out.println(operationRecord.toString());
        Main.operationRecordList.add(operationRecord);
    }

    public void create()
    {
        OperationRecord operationRecord = new OperationRecord(Operation.CREATE);
        System.out.println(operationRecord.toString());
        Main.operationRecordList.add(operationRecord);
    }

    public void copy()
    {
        OperationRecord operationRecord = new OperationRecord(Operation.COPY);
        System.out.println(operationRecord.toString());
        Main.operationRecordList.add(operationRecord);
    }

    public void paste()
    {
        OperationRecord operationRecord = new OperationRecord(Operation.PASTE);
        System.out.println(operationRecord.toString());
        Main.operationRecordList.add(operationRecord);
    }

    public void undo()
    {
        int size = Main.operationRecordList.size();
        if(size > 0)
        {
            Main.operationRecordList.remove(size - 1);
            System.out.println("撤销成功");
        }
        else
            System.out.println("没有可以撤销的操作");
    }

    public static BoardScreen getInstance()
    {
        if(boardScreen == null)
            boardScreen = new BoardScreen();
        return boardScreen;
    }

}
