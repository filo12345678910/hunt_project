package project.hunt_or_be_hunted;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        scene = new Scene(loadFXML("GUI"), 1440, 810);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    /*public static Node getNodeByCoordinate(Integer row, Integer column) {
    for (Node node : gridLayout.getChildren()) {
        if(GridPane.getColumnIndex(node) == row && GridPane.getColumnIndex(node) == column){
            return node;
        }
    }
    return null;
    }*/
    
    public static void generate_Enviroment_Array(Collection<Enviroment> Enviroments){
        for (int i = 0; i < Enviroments.size(); i++)
        {
            for (int j = 0; j < Enviroments.size(); j++)
            {
                Enviroments.add(new Crossroad(i, j, 1));
            }
        }
    }
    
    public static void generate_Map(){
        
    }
    
    public static void main(String[] args) {
        Collection<Animal> Animals = new ArrayList();
        Collection<Enviroment> Enviroments = new ArrayList<Enviroment>();
        generate_Enviroment_Array(Enviroments);
        Animals.add(new Prey("Bob", 100, 2, 10, "Squirrel", 50, 20, 0, 0));
        (new Thread(new Prey("Bob", 100, 2, 10, "Squirrel", 50, 20, 0, 0))).start();
        launch();
    }
}