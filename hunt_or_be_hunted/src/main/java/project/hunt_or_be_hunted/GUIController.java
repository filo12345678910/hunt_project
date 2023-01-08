/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project.hunt_or_be_hunted;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author filip
 */
public class GUIController implements Initializable {

    @FXML
    private Canvas board;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void stuff(ActionEvent event) {
        System.out.println("aaa");
    }

    @FXML
    private void stuff1(MouseEvent event) {
        System.out.println("bbb");
    }
    public void draw_board(){
        GraphicsContext gc = board.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(75,75,100,100);
    }
}