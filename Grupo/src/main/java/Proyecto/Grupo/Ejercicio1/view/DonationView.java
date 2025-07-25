package Proyecto.Grupo.Ejercicio1.view;

import Proyecto.Grupo.Ejercicio1.model.Colaborador;
import Proyecto.Grupo.Ejercicio1.model.ProyectoEmprendimiento;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Clase que gestiona la ventana para realizar donaciones a proyectos existentes.
 * Muestra una lista de proyectos disponibles y un formulario para ingresar los detalles de la donación, con validación para el nombre del colaborador.
 */
public class DonationView {
    private IProyectoService proyectoService;

    /**
     * Constructor que inyecta el servicio de proyectos.
     * @param proyectoService El servicio que gestiona los proyectos de emprendimiento.
     */
    public DonationView(IProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    /**
     * Muestra la ventana de donaciones con una lista de proyectos y un formulario.
     * Permite seleccionar un proyecto, ingresar el nombre del colaborador y el monto de la donación.
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

        // Crea una nueva ventana para la funcionalidad de donaciones.
        Stage donationStage = new Stage();

        // Crea un contenedor vertical con estilos predefinidos usando ViewFactory.
        VBox root = ViewFactory.createStyledVBox();
        root.setStyle("-fx-background-color: #ffffff;");

        // Crea una etiqueta para indicar que se debe seleccionar un proyecto.
        Label projectLabel = ViewFactory.createStyledLabel("Seleccione un proyecto:", false);

        // Crea una lista que muestra todos los proyectos disponibles obtenidos del servicio.
        ListView<ProyectoEmprendimiento> projectList = new ListView<>();
        projectList.getItems().addAll(proyectoService.getProyectos());
        projectList.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5;");

        // Crea campos de texto para los detalles de la donación.
        TextField colaboradorField = ViewFactory.createStyledTextField("Nombre del colaborador");
        TextField donacionField = ViewFactory.createStyledTextField("Monto de la donación");

        // Crea un botón para enviar la donación.
        Button donarButton = ViewFactory.createStyledButton("Donar", "#2196F3");

        // Define la acción del botón para procesar la donación.
        donarButton.setOnAction(e -> {
            try {
                // Obtiene el proyecto seleccionado de la lista.
                ProyectoEmprendimiento proyecto = projectList.getSelectionModel().getSelectedItem();

                // Verifica si se seleccionó un proyecto.
                if (proyecto == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Seleccione un proyecto.");
                    alert.showAndWait();
                    return;
                }

                // Obtiene el nombre del colaborador.
                String nombreColaborador = colaboradorField.getText();

                // Verifica que el nombre del colaborador no esté vacío.
                if (nombreColaborador.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "El nombre del colaborador es obligatorio.");
                    alert.showAndWait();
                    return;
                }

                // Crea un nuevo colaborador con el nombre ingresado.
                Colaborador colaborador = new Colaborador(nombreColaborador);

                // Convierte el monto de la donación a un número.
                double monto = Double.parseDouble(donacionField.getText());

                // Realiza la donación usando el método donar del Colaborador.
                colaborador.donar(proyecto, monto);

                // Actualiza la lista para reflejar los cambios en los datos.
                projectList.refresh();

                // Muestra un mensaje de éxito al usuario.
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Donación realizada con éxito.");
                alert.showAndWait();

                // Cierra la ventana de donación tras una donación exitosa.
                donationStage.close();
            } catch (NumberFormatException ex) {
                // Muestra un error si el monto ingresado no es un número válido.
                Alert alert = new Alert(Alert.AlertType.ERROR, "El monto debe ser un número válido.");
                alert.showAndWait();
            } catch (IllegalArgumentException ex) {
                // Muestra un error si la donación excede el monto necesario del proyecto.
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                alert.showAndWait();
            }
        });

        // Añade todos los elementos al contenedor en orden.
        root.getChildren().addAll(
            projectLabel,
            projectList,
            colaboradorField,
            donacionField,
            donarButton
        );

        // Crea la escena con el contenedor y un tamaño de 400x400 píxeles.
        Scene scene = new Scene(root, 400, 400);

        // Configura el título de la ventana y muestra la escena.
        donationStage.setTitle("Donar a un Proyecto");
        donationStage.setScene(scene);
        donationStage.show();
    }
}
