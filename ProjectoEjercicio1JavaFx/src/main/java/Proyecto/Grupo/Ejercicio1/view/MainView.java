package Proyecto.Grupo.Ejercicio1.view;

import Proyecto.Grupo.Ejercicio1.model.Colaborador;
import Proyecto.Grupo.Ejercicio1.model.Investigador;
import Proyecto.Grupo.Ejercicio1.model.ProyectoEmprendimiento;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

// Esta clase es la encargada de crear la interfaz gráfica de la aplicación.
// Imagina que es como el plano de una casa: define cómo se ven las ventanas y qué puedes hacer en ellas.
// Hereda de "Application" porque JavaFX necesita eso para mostrar ventanas en tu computadora.
public class MainView extends Application {
    // Esta lista guarda todos los proyectos de emprendimiento, como una libreta donde apuntas ideas.
    // Usamos ArrayList porque es una forma flexible de almacenar muchos proyectos y añadir más luego.
    private List<ProyectoEmprendimiento> proyectos = new ArrayList<>();

    // El método "start" es como el botón de encendido de la aplicación.
    // JavaFX lo ejecuta automáticamente cuando inicias el programa.
    // Recibe un "Stage" (escenario), que es como la ventana principal donde pondremos todo.
    @Override
    public void start(Stage primaryStage) {
        // Agregamos tres proyectos de ejemplo para que la lista no esté vacía al empezar.
        // Cada proyecto tiene un nombre, descripción, URL, un investigador y un monto a financiar.
        // Es como llenar una base de datos inicial con proyectos ficticios para probar la aplicación.
        proyectos.add(new ProyectoEmprendimiento("Energía Solar", "Paneles solares innovadores", "http://solar.com", new Investigador("Ana López", "http://ana.com", "Energía"), 10000.0));
        proyectos.add(new ProyectoEmprendimiento("Agua Limpia", "Filtros de agua portátiles", "http://water.com", new Investigador("Carlos Ruiz", "http://carlos.com", "Sostenibilidad"), 5000.0));
        proyectos.add(new ProyectoEmprendimiento("EdTech", "Plataforma educativa", "http://edtech.com", new Investigador("María Gómez", "http://maria.com", "Educación"), 15000.0));

        // Creamos un contenedor vertical (VBox) para organizar los elementos uno encima del otro.
        // El "10" significa que habrá 10 píxeles de espacio entre cada elemento, como márgenes en un cuaderno.
        VBox root = new VBox(10);
        // Añadimos un margen de 20 píxeles alrededor del contenedor para que no esté pegado a los bordes.
        root.setPadding(new Insets(20));
        // Centramos todos los elementos dentro del contenedor, como alinear texto al centro en Word.
        root.setAlignment(Pos.CENTER);
        // Le ponemos un color de fondo gris claro (#f4f4f4) para que la ventana se vea limpia y moderna.
        root.setStyle("-fx-background-color: #f4f4f4;");

        // Creamos una etiqueta (Label) que actúa como el título de la ventana principal.
        // Es como un letrero que dice qué puedes hacer aquí.
        Label titleLabel = new Label("Bienvenidos -- elija la acción a realizar");
        // Estilamos la etiqueta: tamaño de letra grande (20px), en negrita, y color gris oscuro (#333333).
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #333333;");

        // Creamos un botón para "Crear Proyecto".
        // Es como un botón en un formulario web que al presionarlo te lleva a otra página.
        Button crearButton = new Button("Crear Proyecto");
        // Estilamos el botón: fondo verde (#4CAF50), texto blanco, tamaño de letra 14px,
        // márgenes internos (padding) de 10px arriba/abajo y 20px a los lados, y bordes redondeados.
        crearButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20; -fx-border-radius: 5;");

        // Creamos otro botón para "Donar".
        Button donarButton = new Button("Donar");
        // Estilamos el botón: fondo azul (#2196F3), texto blanco, mismo tamaño y bordes que el otro.
        donarButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20; -fx-border-radius: 5;");

        // Le decimos al botón "Crear Proyecto" qué hacer cuando lo presionas.
        // Al hacer clic, llamará al método "showCreateProjectWindow" para abrir una nueva ventana.
        crearButton.setOnAction(e -> showCreateProjectWindow(primaryStage));
        // Lo mismo para el botón "Donar", pero llama al método "showDonationWindow".
        donarButton.setOnAction(e -> showDonationWindow(primaryStage));

        // Añadimos el título y los botones al contenedor, en orden, para que se muestren uno encima del otro.
        root.getChildren().addAll(titleLabel, crearButton, donarButton);

        // Creamos una "escena" (Scene), que es como el lienzo donde ponemos el contenedor.
        // Le damos un tamaño de 400x300 píxeles.
        Scene scene = new Scene(root, 400, 300);
        // Le ponemos un título a la ventana principal, como el nombre de una pestaña en un navegador.
        primaryStage.setTitle("Portal de Innovación");
        // Asociamos la escena a la ventana principal.
        primaryStage.setScene(scene);
        // Mostramos la ventana para que aparezca en pantalla.
        primaryStage.show();
    }

    // Este método crea una ventana nueva para ingresar los detalles de un proyecto.
    // Es como un formulario en papel donde llenas información.
    private void showCreateProjectWindow(Stage primaryStage) {
        // Creamos una nueva ventana (Stage) para el formulario de crear proyecto.
        Stage createStage = new Stage();
        // Otro contenedor vertical para organizar los campos del formulario.
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        // Fondo blanco (#ffffff) para que esta ventana se vea diferente a la principal.
        root.setStyle("-fx-background-color: #ffffff;");

        // Campo de texto para el nombre del proyecto.
        // Es como una casilla en un formulario donde escribes algo.
        TextField nombreField = new TextField();
        // Mostramos un texto de ayuda (placeholder) que dice "Nombre del proyecto".
        nombreField.setPromptText("Nombre del proyecto");
        // Estilamos el campo: borde gris, bordes redondeados, y margen interno para que el texto no esté pegado.
        nombreField.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5; -fx-padding: 8;");

        // Campo para la descripción del proyecto.
        TextField descripcionField = new TextField();
        descripcionField.setPromptText("Descripción del proyecto");
        descripcionField.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5; -fx-padding: 8;");

        // Campo para la URL del video del proyecto.
        TextField urlVideoField = new TextField();
        urlVideoField.setPromptText("URL del video");
        urlVideoField.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5; -fx-padding: 8;");

        // Campo para el nombre del investigador.
        TextField investigadorField = new TextField();
        investigadorField.setPromptText("Nombre del investigador");
        investigadorField.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5; -fx-padding: 8;");

        // Campo para el monto a financiar.
        TextField montoField = new TextField();
        montoField.setPromptText("Monto total a financiar");
        montoField.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5; -fx-padding: 8;");

        // Botón para enviar el formulario y crear el proyecto.
        Button submitButton = new Button("Crear Proyecto");
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20; -fx-border-radius: 5;");

        // Definimos qué pasa cuando haces clic en "Crear Proyecto".
        submitButton.setOnAction(e -> {
            try {
                // Creamos un nuevo investigador con el nombre ingresado.
                // La URL y área de experiencia son ficticias por ahora.
                Investigador investigador = new Investigador(
                    investigadorField.getText(),
                    "http://example.com",
                    "Área de experiencia"
                );
                // Creamos un nuevo proyecto con todos los datos ingresados.
                ProyectoEmprendimiento proyecto = new ProyectoEmprendimiento(
                    nombreField.getText(),
                    descripcionField.getText(),
                    urlVideoField.getText(),
                    investigador,
                    Double.parseDouble(montoField.getText()) // Convertimos el monto a número.
                );
                // Añadimos el proyecto a la lista.
                proyectos.add(proyecto);
                // Mostramos un mensaje de éxito, como una notificación en tu teléfono.
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Proyecto creado con éxito");
                alert.showAndWait();
                // Cerramos la ventana del formulario.
                createStage.close();
            } catch (NumberFormatException ex) {
                // Si el monto no es un número válido, mostramos un mensaje de error.
                Alert alert = new Alert(Alert.AlertType.ERROR, "El monto debe ser un número válido");
                alert.showAndWait();
            }
        });

        // Añadimos todos los campos y el botón al contenedor.
        root.getChildren().addAll(
            nombreField,
            descripcionField,
            urlVideoField,
            investigadorField,
            montoField,
            submitButton
        );

        // Creamos la escena para esta ventana (400x400 píxeles).
        Scene scene = new Scene(root, 400, 400);
        // Título de la ventana.
        createStage.setTitle("Crear Proyecto");
        createStage.setScene(scene);
        createStage.show();
    }

    // Este método crea una ventana para donar a un proyecto existente.
    private void showDonationWindow(Stage primaryStage) {
        // Nueva ventana para donaciones.
        Stage donationStage = new Stage();
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ffffff;");

        // Creamos una lista (ListView) que muestra todos los proyectos disponibles.
        // Es como un menú desplegable, pero con más espacio para ver los proyectos.
        ListView<ProyectoEmprendimiento> projectList = new ListView<>();
        // Llenamos la lista con los proyectos de la lista "proyectos".
        projectList.getItems().addAll(proyectos);
        // Estilamos la lista con un borde gris y bordes redondeados.
        projectList.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5;");

        // Etiqueta que indica qué hacer.
        Label projectLabel = new Label("Seleccione un proyecto:");
        projectLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #333333;");

        // Campo para el nombre del colaborador (quien dona).
        TextField colaboradorField = new TextField();
        colaboradorField.setPromptText("Nombre del colaborador");
        colaboradorField.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5; -fx-padding: 8;");

        // Campo para el monto de la donación.
        TextField donacionField = new TextField();
        donacionField.setPromptText("Monto de la donación");
        donacionField.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5; -fx-padding: 8;");

        // Botón para enviar la donación.
        Button donarButton = new Button("Donar");
        donarButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20; -fx-border-radius: 5;");

        // Definimos qué pasa cuando haces clic en "Donar".
        donarButton.setOnAction(e -> {
            try {
                // Obtenemos el proyecto seleccionado de la lista.
                ProyectoEmprendimiento proyecto = projectList.getSelectionModel().getSelectedItem();
                // Si no seleccionaste nada, mostramos un error.
                if (proyecto == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Seleccione un proyecto");
                    alert.showAndWait();
                    return;
                }
                // Creamos un nuevo colaborador con el nombre ingresado.
                Colaborador colaborador = new Colaborador(colaboradorField.getText());
                // Convertimos el monto de la donación a número.
                double monto = Double.parseDouble(donacionField.getText());
                // Verificamos si el proyecto puede recibir esa donación (no excede el monto necesario).
                if (proyecto.puedeRecibirDonacion(monto)) {
                    // Realizamos la donación.
                    colaborador.donar(proyecto, monto);
                    // Actualizamos la lista para reflejar los cambios.
                    projectList.refresh();
                    // Mostramos un mensaje de éxito.
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Donación realizada con éxito");
                    alert.showAndWait();
                    donationStage.close();
                } else {
                    // Si la donación es demasiado grande, mostramos un error.
                    Alert alert = new Alert(Alert.AlertType.ERROR, "La donación excede el monto necesario");
                    alert.showAndWait();
                }
            } catch (NumberFormatException ex) {
                // Si el monto no es un número válido, mostramos un error.
                Alert alert = new Alert(Alert.AlertType.ERROR, "El monto debe ser un número válido");
                alert.showAndWait();
            }
        });

        // Añadimos la etiqueta, la lista y los campos al contenedor.
        root.getChildren().addAll(
            projectLabel,
            projectList,
            colaboradorField,
            donacionField,
            donarButton
        );

        // Creamos la escena para esta ventana (400x400 píxeles).
        Scene scene = new Scene(root, 400, 400);
        donationStage.setTitle("Donar a un Proyecto");
        donationStage.setScene(scene);
        donationStage.show();
    }

    // Este método es como el botón de "encender" de toda la aplicación.
    // JavaFX lo usa para iniciar el programa.
    public static void main(String[] args) {
        launch(args);
    }
}