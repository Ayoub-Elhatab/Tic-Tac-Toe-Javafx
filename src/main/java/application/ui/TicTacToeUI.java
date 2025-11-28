package application.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class TicTacToeUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/icon.png")));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/TicTacToe.fxml")));
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
