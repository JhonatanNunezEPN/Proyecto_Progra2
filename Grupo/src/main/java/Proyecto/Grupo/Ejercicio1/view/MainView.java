package Proyecto.Grupo.Ejercicio1.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Clase principal que crea la ventana inicial de la aplicación JavaFX.
 * Muestra un título y dos botones para crear proyectos o donar a proyectos existentes.
 */
public class MainView extends Application {
    private IProyectoService proyectoService;

    /**
     * Constructor por defecto que inicializa el servicio de proyectos.
     * Crea una instancia de ProyectoEmprendimientoService para gestionar los proyectos.
     */
    public MainView() {
        this.proyectoService = new ProyectoEmprendimientoService();
    }

    /**
     * Constructor que permite inyectar una implementación de IProyectoService.
     * @param proyectoService El servicio que gestiona los proyectos.
     * Útil para pruebas o para usar una implementación diferente del servicio.
     */
    public MainView(IProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    /**
     * Método principal de JavaFX que configura y muestra la ventana inicial.
     * @param primaryStage El escenario principal (ventana) de la aplicación.
     * No devuelve nada, configura la UI y muestra la ventana.
     */
    @Override
    public void start(Stage primaryStage) {
        // Crea un contenedor vertical con estilos predefinidos.
        VBox root = ViewFactory.createStyledVBox();
        root.setStyle("-fx-background-color: #f4f4f4;");

        // Crea una etiqueta de título para la ventana.
        Label titleLabel = ViewFactory.createStyledLabel("Bienvenidos -- elija la acción a realizar", true);

        // Crea botones para abrir las ventanas de crear proyecto y donar.
        Button crearButton = ViewFactory.createStyledButton("Crear Proyecto", "#4CAF50");
        Button donarButton = ViewFactory.createStyledButton("Donar", "#2196F3");

        // Asigna acciones a los botones para abrir las ventanas correspondientes.
        crearButton.setOnAction(e -> new CreateProjectView(proyectoService).show(primaryStage));
        donarButton.setOnAction(e -> new DonationView(proyectoService).show(primaryStage));

        // Añade los elementos al contenedor en orden.
        root.getChildren().addAll(titleLabel, crearButton, donarButton);

        // Crea la escena con el contenedor y un tamaño de 400x300 píxeles.
        Scene scene = new Scene(root, 400, 300);

        // Configura el título de la ventana y muestra la escena.
        primaryStage.setTitle("Portal de Innovación");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Punto de entrada de la aplicación JavaFX.
     * @param args Argumentos de la línea de comandos (no se usan en este caso).
     * Inicia la aplicación llamando al método launch de JavaFX.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
