/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project.hunt_or_be_hunted;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.GridPane;
/**
 * FXML Controller class
 *
 * @author filip
 */
public class GUIController implements Initializable {


    @FXML
    private GridPane map;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //((ImageView) getNodeByCoordinate(1, 1)).setImage(new Image(getClass().getResourceAsStream("blank.png")));
        for (int i = 1; i < 15; i++)
        {
            for (int j = 1; j < 15; j++)
            {
                draw(i,j, "blank.png");
            }
        }

    }
    Node getNodeByCoordinate(int row, int column) {
    for (Node node : map.getChildren()) {
        if((GridPane.getRowIndex(node) == column) && (GridPane.getColumnIndex(node) == row)){
            return node;
        }
    }
    System.out.println("NOT FOUND");
    return null;
    }
    public void draw(int x, int y, String image){
        ((ImageView) getNodeByCoordinate(x, y)).setImage(new Image(getClass().getResourceAsStream(image)));
    }
}