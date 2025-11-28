package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TicTacToeController {

    @FXML
    private Button closeBtn;

    @FXML
    public void initialize() {
        closeBtn.setOnMouseClicked(event -> {
            Stage stage = (Stage) closeBtn.getScene().getWindow();
            stage.close();
        });
    }
}
