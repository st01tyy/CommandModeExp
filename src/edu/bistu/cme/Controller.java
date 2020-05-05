package edu.bistu.cme;

import edu.bistu.cme.command.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.List;

public class Controller {

    @FXML
    private MenuItem undo;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private MenuItem create;

    @FXML
    private MenuItem copy;

    @FXML
    private MenuItem paste;

    @FXML
    private GridPane gridPane;

    @FXML
    private MenuItem open;

    @FXML
    void onOpenClicked(ActionEvent event)
    {
        OpenCommand.getInstance().execute();
        refreshUI();
    }

    @FXML
    void onCreateClicked(ActionEvent event)
    {
        CreateCommand.getInstance().execute();
        refreshUI();
    }

    @FXML
    void onCopyClicked(ActionEvent event)
    {
        CopyCommand.getInstance().execute();
        refreshUI();
    }

    @FXML
    void onPasteClicked(ActionEvent event)
    {
        PasteCommand.getInstance().execute();
        refreshUI();
    }

    @FXML
    void onUndoClicked(ActionEvent event)
    {
        Command command = OpenCommand.getInstance();
        command.undo();
        refreshUI();
    }

    public void initialize()
    {
        refreshUI();
    }

    private void refreshUI()
    {
        List<OperationRecord> list = Main.operationRecordList;
        gridPane.getChildren().clear();
        for(int i = 0; i < list.size(); i++)
        {
            Label label = new Label(list.get(i).toString());
            label.setFont(Font.font(15));
            label.setPadding(new Insets(5, 0, 5, 0));
            gridPane.add(label, 0, i);
        }
        scrollPane.layout();
        scrollPane.setVvalue(scrollPane.getVmax());
    }

}
