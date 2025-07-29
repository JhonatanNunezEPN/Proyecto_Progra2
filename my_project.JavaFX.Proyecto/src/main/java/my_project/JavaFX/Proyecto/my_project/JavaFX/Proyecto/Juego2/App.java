package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Juego2;

import javafx.application.Application;
import javafx.stage.Stage;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.ViewJuego2.*;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        new JuegoView(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
