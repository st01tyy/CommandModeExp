package edu.bistu.cme;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OperationRecord implements Serializable
{
    private Date time;
    private Operation operation;
    private String str;

    public OperationRecord(Operation operation)
    {
        this.operation = operation;
        time = new Date();
    }

    @Override
    public String toString()
    {
        if(str == null)
        {
            StringBuffer sb = new StringBuffer();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            sb.append(dateFormat.format(time));
            sb.append(' ');
            String op;
            if(operation == Operation.COPY)
                op = "复制";
            else if(operation == Operation.CREATE)
                op = "新建";
            else if(operation == Operation.PASTE)
                op = "粘贴";
            else
                op = "打开";
            sb.append(op);
            str = sb.toString();
        }
        return str;
    }
}
