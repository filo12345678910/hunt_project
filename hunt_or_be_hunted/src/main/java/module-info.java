module project.hunt_or_be_hunted {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens project.hunt_or_be_hunted to javafx.fxml;
    exports project.hunt_or_be_hunted;
}
