package Proyecto.Grupo.Ejercicio1.view;

import Proyecto.Grupo.Ejercicio1.model.Investigador;
import Proyecto.Grupo.Ejercicio1.model.ProyectoEmprendimiento;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Clase que gestiona la ventana para crear nuevos proyectos de emprendimiento.
 * Permite ingresar los detalles del proyecto y del investigador responsable, con validación de la URL del video.
 */
public class CreateProjectView {
    private IProyectoService proyectoService;

    /**
     * Constructor que inyecta el servicio de proyectos.
     * @param proyectoService El servicio que gestiona los proyectos de emprendimiento.
     */
    public CreateProjectView(IProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    /**
     * Muestra la ventana para crear un nuevo proyecto.
     * Incluye campos para los detalles del proyecto y del investigador, y un botón para guardar.
     * @param primaryStage El escenario principal (no se usa directamente, pero se pasa para referencia).
     * No devuelve nada, crea y muestra una nueva ventana con la interfaz gráfica.
     */
    public void show(Stage primaryStage) {
        // Verifica que proyectoService no sea nulo para evitar errores.
        if (proyectoService == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error: El servicio de proyectos no está inicializado.");
            alert.showAndWait();
            return;
        }

        // Crea una nueva ventana para la funcionalidad de creación de proyectos.
        Stage createStage = new Stage();

        // Crea un contenedor vertical con estilos predefinidos usando ViewFactory.
        VBox root = ViewFactory.createStyledVBox();
        root.setStyle("-fx-background-color: #ffffff;");

        // Crea una etiqueta para el título de la ventana.
        Label titleLabel = ViewFactory.createStyledLabel("Crear Nuevo Proyecto", true);

        // Crea campos de texto para los detalles del proyecto.
        TextField nombreField = ViewFactory.createStyledTextField("Nombre del proyecto");
        TextField descripcionField = ViewFactory.createStyledTextField("Descripción del proyecto");
        TextField urlVideoField = ViewFactory.createStyledTextField("URL del video");
        TextField montoTotalField = ViewFactory.createStyledTextField("Monto total a financiar");

        // Crea campo de texto para el nombre del investigador.
        TextField nombreInvestigadorField = ViewFactory.createStyledTextField("Nombre del investigador");

        // Crea un botón para guardar el proyecto.
        Button guardarButton = ViewFactory.createStyledButton("Guardar Proyecto", "#4CAF50");

        // Define la acción del botón para procesar la creación del proyecto.
        guardarButton.setOnAction(e -> {
            try {
                // Obtiene los valores de los campos.
                String nombre = nombreField.getText();
                String descripcion = descripcionField.getText();
                String urlVideo = urlVideoField.getText();
                double montoTotal = Double.parseDouble(montoTotalField.getText());
                String nombreInvestigador = nombreInvestigadorField.getText();

                // Valida que los campos no estén vacíos.
                if (nombre.isEmpty() || descripcion.isEmpty() || urlVideo.isEmpty() ||
                    nombreInvestigador.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Todos los campos son obligatorios.");
                    alert.showAndWait();
                    return;
                }

                // Valida que la URL contiene un punto (.).
                if (!urlVideo.contains(".")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "La URL del video está incorrecta.");
                    alert.showAndWait();
                    return;
                }

                // Crea un nuevo investigador.
                Investigador investigador = new Investigador(nombreInvestigador);

                // Crea un nuevo proyecto de emprendimiento.
                ProyectoEmprendimiento proyecto = new ProyectoEmprendimiento(nombre, descripcion, urlVideo, investigador, montoTotal);

                // Añade el proyecto al servicio.
                proyectoService.addProyecto(proyecto);

                // Muestra un mensaje de éxito.
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Proyecto creado con éxito.");
                alert.showAndWait();

                // Cierra la ventana tras crear el proyecto.
                createStage.close();
            } catch (NumberFormatException ex) {
                // Muestra un error si el monto no es un número válido.
                Alert alert = new Alert(Alert.AlertType.ERROR, "El monto total debe ser un número válido.");
                alert.showAndWait();
            }
        });

        // Añade todos los elementos al contenedor en orden.
        root.getChildren().addAll(
            titleLabel,
            nombreField,
            descripcionField,
            urlVideoField,
            montoTotalField,
            nombreInvestigadorField,
            guardarButton
        );

        // Crea la escena con el contenedor y un tamaño de 400x600 píxeles.
        Scene scene = new Scene(root, 400, 600);

        // Configura el título de la ventana y muestra la escena.
        createStage.setTitle("Crear Proyecto");
        createStage.setScene(scene);
        createStage.show();
    }
}
