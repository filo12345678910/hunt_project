/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project.hunt_or_be_hunted;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
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

    static Collection<Animal> Animals = new ArrayList();
    static Collection<Enviroment> Enviroments = new ArrayList<>();
    @FXML
    private GridPane map;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*Animals.add(new Prey("Bob", 100, 2, 10, "Squirrel", 50, 20, 0, 0));
        (new Thread(new Prey("Bob", 100, 2, 10, "Squirrel", 50, 20, 0, 0))).start();*/
        //draw(1, 1, "blank.png");

    }
    public Node getNodeByCoordinate(int row, int column) {
    int te = 0;
    for (Node node : map.getChildren()) {
        System.out.println(te);
        te ++;
        if((GridPane.getRowIndex(node) == column) && (GridPane.getColumnIndex(node) == row)){
            return node;
        }
    }
    System.out.println("ERROR: PLACE NOT FOUND");
    return null;
    }
    public static Enviroment getEnviromentByCoordinate(int x, int y){
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
    public String getRandomElement(List<String> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
    public static Enviroment getRandomEnviroment(String env){
        for (Enviroment enviroment : Enviroments){
            if (enviroment instanceof Crossroad && "Crossroad".equals(env)){
                return enviroment;
            }
            if (enviroment instanceof Food_source && "Food_source".equals(env)){
                return enviroment;
            }
            if (enviroment instanceof Water_source && "Water_source".equals(env)){
                return enviroment;
            }
            if (enviroment instanceof Hideout && "Hideout".equals(env)){
                return enviroment;
            }
        }
        return null;
    }

    /**
     *
     * check if animal can move
     */
    public static boolean FreeSpace(int x, int y){
        Enviroment env = getEnviromentByCoordinate(x, y);
        int cap = env.getCapacity();
        int a = 0;
        for(Animal animal : Animals){
            if (animal instanceof Prey){
                if(((Prey) animal).getX() == x && ((Prey) animal).getY() == y){
                    a++;
                }
            }
        }
        if (a >= cap){
            return false;
        }
        return true;
    }
    public static void animal_moves(int dest_x, int dest_y, int x, int y){
        Enviroment env_dest = getEnviromentByCoordinate(dest_x, dest_y);
        Enviroment env_c = getEnviromentByCoordinate(x, y);
        if (env_c instanceof Crossroad){
            
        }
    }

    @FXML
    private void create_random_prey(MouseEvent event) {
        List<String> name = Arrays.asList("Adams", "Baker", "Clark", "Davis", "Evans", "Frank", "Ghosh", "Hills", "Irwin", "Jones", "Klein", "Lopez", "Mason", "Nalty", "Ochoa", "Patel", "Quinn", "Reily", "Smith", "Trott", "Usman", "Valdo", "White", "Xiang", "Yakub", "Zafar");
        List<String> spiece = Arrays.asList("Dungeness Crab", "King Crab", "Blue Crab", "Coconut Crab", "Peekytoe Crab", "Brown Edible Crab", "Florida Stone Crab", "Japanese Spider Crab");
        Enviroment spawn = getRandomEnviroment("Hideout");
        Prey ani = new Prey(getRandomElement(name), new Random().nextInt(20)+30, (float) (new Random().nextInt(4)*0.5), new Random().nextInt(20)+5, getRandomElement(spiece),
        new Random().nextInt(5)+20, new Random().nextInt(5)+20, spawn.getX(), spawn.getY());
        Animals.add(ani);
        (new Thread(ani)).start();
    }

    @FXML
    private void create_random_predator(MouseEvent event) {
    }
}