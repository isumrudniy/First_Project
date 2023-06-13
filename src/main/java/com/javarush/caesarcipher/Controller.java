package com.javarush.caesarcipher;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class Controller {
    @FXML
    private TextField srcPathField;
    @FXML
    private TextField destPathField;
    @FXML
    private TextField keyField;

    private static final String NOT_NUMERIC = "Ключ шифрования должен быть числом";
    private static final String FILE_NOT_FOUND = "Укажите корректный путь к файлам";
    private static final String CIPHER_SECSESS = "Шифрование выполнено успешно";
    private static final String DECIPHER_SECSESS = "Дешифрование выполнено успешно";

    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }

    private void showErrorAlert(String title, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    private void showInformationAlert(String title, String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    @FXML
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

    @FXML
    public void onCipher(ActionEvent actionEvent) {
        try {
            HandlerFile handlerFile = new HandlerFile(srcPathField.getCharacters().toString(),
                    destPathField.getCharacters().toString(), Integer.parseInt(keyField.getCharacters().toString()));
            handlerFile.cipher();
            showInformationAlert("Успешно", CIPHER_SECSESS);
        } catch (NumberFormatException e) {
            showErrorAlert("Ошибка", NOT_NUMERIC);
        } catch (Exception e) {
            if (e.getCause() instanceof FileNotFoundException) {
                showErrorAlert("Ошибка", FILE_NOT_FOUND);
            } else {
                showErrorAlert("Ошибка", e.getMessage());
            }
        }
    }

    @FXML
    public void onDecipher(ActionEvent actionEvent) {
        try {
            if (!srcPathField.equals("") && !destPathField.equals("") && !keyField.equals("")) {
                HandlerFile handlerFile = new HandlerFile(srcPathField.getCharacters().toString(),
                        destPathField.getCharacters().toString(), Integer.parseInt(keyField.getCharacters().toString()));
                handlerFile.decipher();
                showInformationAlert("Успешно", DECIPHER_SECSESS);
            }
        } catch (NumberFormatException e) {
            showErrorAlert("Ошибка", NOT_NUMERIC);
        } catch (Exception e) {
            if (e.getCause() instanceof FileNotFoundException) {
                showErrorAlert("Ошибка", FILE_NOT_FOUND);
            } else {
                showErrorAlert("Ошибка", e.getMessage());
            }
        }
    }

    @FXML
    public void onHacker(ActionEvent actionEvent) {
        showInformationAlert("Упс", "Метод взлома ещё в разработке :)");
//        HandlerFile handlerFile = new HandlerFile(srcPathField.getCharacters().toString(),
//                destPathField.getCharacters().toString(), Integer.parseInt(keyField.getCharacters().toString()));
//        handlerFile.hacker();
    }
}