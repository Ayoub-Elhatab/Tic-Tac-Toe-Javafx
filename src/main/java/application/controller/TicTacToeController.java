package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;


public class TicTacToeController {

    @FXML
    private Button closeBtn;

    @FXML
    public Text playerTurn;

    @FXML
    private Button restartBtn;

    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    @FXML private Button btn7;
    @FXML private Button btn8;
    @FXML private Button btn9;

    ArrayList<Button> cells;
    String currentPlayer = "X";

    @FXML
    public void initialize() {
        playerTurn.setText("player's " + currentPlayer + " turn");
        cells = new ArrayList<>(Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,  btn9));
        cells.forEach(btn -> btn.setOnAction(event -> {
            getPlayerMove(btn, currentPlayer);
            currentPlayer = switchPlayer(currentPlayer);
            playerTurn.setText("player's " + currentPlayer + " turn");
            checkWin(cells);
            checkDraw(cells);

        }));
        restart(cells);
        close();
    }

    public void getPlayerMove(Button move, String currentPlayer){
        move.setText(currentPlayer);
        move.setDisable(true);
    }

    private String switchPlayer(String currentPlayer){
        return (currentPlayer.equals("X")) ? "O" : "X";
    }

    public void checkWin(ArrayList<Button> cells){
        for(int index = 1; index < cells.size(); index++){
            String line = switch(index){
                case 1 -> btn1.getText() + btn2.getText() + btn3.getText();
                case 2 -> btn4.getText() + btn5.getText() + btn6.getText();
                case 3 -> btn7.getText() + btn8.getText() + btn9.getText();
                case 4 -> btn1.getText() + btn4.getText() + btn7.getText();
                case 5 -> btn2.getText() + btn5.getText() + btn8.getText();
                case 6 -> btn3.getText() + btn6.getText() + btn9.getText();
                case 7 -> btn1.getText() + btn5.getText() + btn9.getText();
                case 8 -> btn3.getText() + btn5.getText() + btn7.getText();
                default -> null;
            };

            assert line != null;

            if(line.equals("XXX")){
                playerTurn.setText("X won!");
                disableAllBtn(cells);
            }
            else if(line.equals("OOO")){
                playerTurn.setText("O won!");
                disableAllBtn(cells);
            }
        }
    }

    public void checkDraw(ArrayList<Button> cells){
        boolean full = cells.stream().allMatch(Button::isDisabled);
        if (full && !playerTurn.getText().contains("won")) {
            playerTurn.setText("It's a draw!");
        }
    }

    public void disableAllBtn(ArrayList<Button> cells){
        cells.forEach(btn -> {
            btn.setDisable(true);
        });
    }

    public void restart(ArrayList<Button> cells){
        restartBtn.setOnAction(event -> {
            cells.forEach(btn -> {
                btn.setText("");
                if(currentPlayer.equals("O")){
                    currentPlayer = "X";
                }
                playerTurn.setText("player's " + currentPlayer + " turn");
                btn.setDisable(false);
            });
        });

    }

    public void close(){
        closeBtn.setOnAction(event -> {
            Stage stage = (Stage) closeBtn.getScene().getWindow();
            stage.close();
        });
    }
}
