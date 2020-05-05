package edu.bistu.cme;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application
{
    public final static List<OperationRecord> operationRecordList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        File ui = new File("resources/ui.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(ui.toURI().toURL());
        Parent parent = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        controller.initialize();
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("文本编辑器");
        primaryStage.setOnCloseRequest(event -> saveRecord());
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        readRecord();
        launch(args);
    }

    private static void saveRecord()
    {
        try
        {
            if(operationRecordList.size() > 0)
            {
                PrintWriter writer = new PrintWriter(new File("record.txt"), "UTF-8");
                for(int i = 0; i < operationRecordList.size() - 1; i++)
                    writer.println(operationRecordList.get(i).toString());
                writer.print(operationRecordList.get(operationRecordList.size() - 1).toString());
                writer.close();

                ObjectOutputStream outputStream = new ObjectOutputStream(
                        new BufferedOutputStream(new FileOutputStream("record.dat")));
                for(OperationRecord record: operationRecordList)
                {
                    outputStream.writeObject(record);
                    outputStream.flush();
                }
                outputStream.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void readRecord()
    {
        try
        {
            ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("record.dat")));
            Object obj = inputStream.readObject();
            while(obj != null)
            {
                operationRecordList.add((OperationRecord) obj);
                obj = inputStream.readObject();
            }
            inputStream.close();
        }
        catch (EOFException e)
        {

        }
        catch (FileNotFoundException e)
        {

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
