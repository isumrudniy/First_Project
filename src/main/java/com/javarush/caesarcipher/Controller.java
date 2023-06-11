package com.javarush.caesarcipher;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    @FXML
    private TextField srcPathField;
    @FXML
    private TextField destPathField;
    @FXML
    private TextField keyField;

    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }

    public void getPath(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        Stage stage = new Stage();
        File selectedFile = fileChooser.showOpenDialog(stage);
        Button button = (Button) actionEvent.getSource();
        String idBtn = button.getId();
        if (selectedFile != null) {
            if (idBtn.equals("srcBtn")) {
                srcPathField.setText(selectedFile.getAbsolutePath());
            } else if (idBtn.equals("destBtn")) {
                destPathField.setText(selectedFile.getAbsolutePath());
            }
        }
    }

    public void onCipher(ActionEvent actionEvent) {
        if (!srcPathField.equals("") && !destPathField.equals("") && !keyField.equals("")) {
            HandlerFile handlerFile = new HandlerFile(srcPathField.getCharacters().toString(),
                    destPathField.getCharacters().toString(), Integer.parseInt(keyField.getCharacters().toString()));
            handlerFile.cipher();
        }
    }

    public void onDecipher(ActionEvent actionEvent) {
        if (!srcPathField.equals("") && !destPathField.equals("") && !keyField.equals("")) {
            HandlerFile handlerFile = new HandlerFile(srcPathField.getCharacters().toString(),
                    destPathField.getCharacters().toString(), Integer.parseInt(keyField.getCharacters().toString()));
            handlerFile.decipher();
        }
    }
}