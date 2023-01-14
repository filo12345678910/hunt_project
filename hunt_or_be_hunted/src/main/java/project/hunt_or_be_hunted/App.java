package project.hunt_or_be_hunted;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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

    public static void main(String[] args) {
        Collection<Animal> Animals;
        Animals = new ArrayList();
        Animals.add(new Prey("Bob", 100, 2, 10, "Squirrel", 50, 20, 0, 0));
        (new Thread(new Prey("Bob", 100, 2, 10, "Squirrel", 50, 20, 0, 0))).start();
        System.out.println("sth");
        launch();
    }
}