/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project.hunt_or_be_hunted;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
/**
 * FXML Controller class
 *
 * @author filip
 */
public class GUIController implements Initializable {

    Collection<Animal> Animals = new ArrayList();
    Collection<Enviroment> Enviroments = new ArrayList<>();
    @FXML
    private GridPane map;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*Animals.add(new Prey("Bob", 100, 2, 10, "Squirrel", 50, 20, 0, 0));
        (new Thread(new Prey("Bob", 100, 2, 10, "Squirrel", 50, 20, 0, 0))).start();*/

    }
    public Node getNodeByCoordinate(int row, int column) {
    for (Node node : map.getChildren()) {
        if((GridPane.getRowIndex(node) == column) && (GridPane.getColumnIndex(node) == row)){
            return node;
        }
    }
    System.out.println("ERROR: PLACE NOT FOUND");
    return null;
    }
    public Enviroment getEnviromentByCoordinate(int x, int y){
        for (Enviroment enviroment : Enviroments){
            if (enviroment.getX() == x && enviroment.getY() == y){
                return enviroment;
            }
        }
        System.out.println("ERROR: ENVIROMENT NOT FOUND");
        return null;
    }
    public void draw(int x, int y, String image){
        ((ImageView) getNodeByCoordinate(x, y)).setImage(new Image(getClass().getResourceAsStream(image)));
    }
    public void drawArray(Collection<Enviroment> Enviroments){
        for (Enviroment enviroment : Enviroments){
            if (enviroment instanceof Crossroad){
                draw(enviroment.getX(), enviroment.getY(), "blank.png");
            }
            if (enviroment instanceof Hideout){
                draw(enviroment.getX(), enviroment.getY(), "hideout.png");
            }
            if (enviroment instanceof Water_source){
                draw(enviroment.getX(), enviroment.getY(), "Water_source.png");
            }
            if (enviroment instanceof Food_source){
                draw(enviroment.getX(), enviroment.getY(), "Food_source.png");
            }
        }
    }

    @FXML
    private void layout1(MouseEvent event) {
        System.out.println("testing");
        Enviroments.clear();
        for (int i = 0; i < 16; i++){
            for (int j = 0; j < 16; j++){
                Enviroments.add(new Crossroad(i, j, 1));
            }
        }
        Enviroments.remove(getEnviromentByCoordinate(3, 4));
        Enviroments.add(new Hideout(3, 4, 3));
        Enviroments.remove(getEnviromentByCoordinate(13, 14));
        Enviroments.add(new Hideout(13, 14, 2));
        Enviroments.remove(getEnviromentByCoordinate(6, 1));
        Enviroments.add(new Hideout(6, 1, 4));
        Enviroments.remove(getEnviromentByCoordinate(8, 8));
        Enviroments.add(new Hideout(8, 8, 5));
        Enviroments.remove(getEnviromentByCoordinate(11, 2));
        Enviroments.add(new Hideout(11, 2, 2));
        Enviroments.remove(getEnviromentByCoordinate(3, 14));
        Enviroments.add(new Water_source(3, 14, 4, 50));
        Enviroments.remove(getEnviromentByCoordinate(14, 13));
        Enviroments.add(new Water_source(14, 13, 4, 60));
        Enviroments.remove(getEnviromentByCoordinate(9, 1));
        Enviroments.add(new Water_source(9, 1, 2, 70));
        Enviroments.remove(getEnviromentByCoordinate(10, 6));
        Enviroments.add(new Water_source(10, 6, 3, 55));
        Enviroments.remove(getEnviromentByCoordinate(2, 3));
        Enviroments.add(new Water_source(2, 3, 2, 40));
        Enviroments.remove(getEnviromentByCoordinate(1, 10));
        Enviroments.add(new Food_source(1, 10, 2, 40));
        Enviroments.remove(getEnviromentByCoordinate(10, 14));
        Enviroments.add(new Food_source(10, 14, 3, 50));
        Enviroments.remove(getEnviromentByCoordinate(14, 5));
        Enviroments.add(new Food_source(14, 5, 2, 60));
        Enviroments.remove(getEnviromentByCoordinate(6, 9));
        Enviroments.add(new Food_source(6, 9, 3, 40));
        Enviroments.remove(getEnviromentByCoordinate(8, 5));
        Enviroments.add(new Food_source(8, 5, 4, 70));
        drawArray(Enviroments);
    }

    @FXML
    private void layout2(MouseEvent event) {
        System.out.println("testing 2");
        Enviroments.clear();
    }

    @FXML
    private void layout3(MouseEvent event) {
        System.out.println("testing 3");
        Enviroments.clear();
    }
}