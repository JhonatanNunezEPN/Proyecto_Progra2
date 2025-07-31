package Proyecto.Juego1.view;

import Proyecto.Juego1.model.TableroJuego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.scene.effect.DropShadow;

// Clase que crea y actualiza la interfaz gráfica del juego
public class VistaJuego {
    // Referencia al modelo del tablero
    private final TableroJuego tablero;
    // Renderizador para dibujar el tablero
    private final RenderizadorTablero renderizador;
    // GridPane que contiene el tablero
    private final GridPane tableroGrid;
    // Etiqueta para mostrar mensajes al usuario
    private final Label mensajeLabel;
    // Escena principal de la interfaz
    private final Scene scene;
    // Botón para mover al pirata
    private Button moverButton;
    // Botón para reiniciar el juego
    private Button reiniciarButton;

    // Constructor: inicializa la interfaz con un tablero y renderizador
    public VistaJuego(TableroJuego tablero, RenderizadorTablero renderizador) {
        this.tablero = tablero;
        this.renderizador = renderizador;
        // Inicializa el GridPane para el tablero
        this.tableroGrid = new GridPane();
        // Inicializa la etiqueta de mensajes con un texto inicial
        this.mensajeLabel = new Label("¡Busca el tesoro!");
        // Aplica estilo al mensaje: texto blanco, fuente elegante
        this.mensajeLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-font-family: Verdana;");
        // Crea la escena principal
        this.scene = crearEscena();
        // Dibuja el tablero inicial
        dibujarTablero();
    }

    // Crea la escena con la interfaz gráfica
    private Scene crearEscena() {
        // Configura el GridPane: centrado, con espacios entre casillas
        tableroGrid.setAlignment(Pos.CENTER);
        tableroGrid.setHgap(5);
        tableroGrid.setVgap(5);
        tableroGrid.setPadding(new Insets(10));

        // Crea un contenedor vertical para la leyenda
        VBox leyenda = new VBox(5);
        leyenda.setAlignment(Pos.CENTER_LEFT);
        leyenda.setPadding(new Insets(10));
        // Fondo semitransparente para la leyenda
        leyenda.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5); -fx-text-fill: white;");
        // Añade etiquetas de la leyenda con colores correspondientes
        leyenda.getChildren().addAll(
            new Label("Leyenda:") {{ setStyle("-fx-text-fill: white; -fx-font-family: Verdana;"); }},
            new Label("X: Pirata") {{ setStyle("-fx-text-fill: gold; -fx-font-family: Verdana;"); }},
            new Label("T: Tesoro") {{ setStyle("-fx-text-fill: yellow; -fx-font-family: Verdana;"); }},
            new Label("~: Agua") {{ setStyle("-fx-text-fill: deepskyblue; -fx-font-family: Verdana;"); }},
            new Label("P: Puente") {{ setStyle("-fx-text-fill: saddlebrown; -fx-font-family: Verdana;"); }},
            new Label(".: Terreno") {{ setStyle("-fx-text-fill: lightgreen; -fx-font-family: Verdana;"); }}
        );

        // Contenedor horizontal para el tablero y la leyenda
        HBox tableroYLeyenda = new HBox(20, tableroGrid, leyenda);
        tableroYLeyenda.setAlignment(Pos.CENTER);

        // Configura el botón "Mover Pirata" con estilo moderno
        moverButton = new Button("Mover Pirata");
        moverButton.setStyle(
            "-fx-background-color: #4682B4; " + // Fondo azul acero
            "-fx-text-fill: white; " + // Texto blanco
            "-fx-font-size: 14; " + // Tamaño de fuente
            "-fx-font-family: Verdana; " + // Fuente elegante
            "-fx-padding: 10 20; " + // Espaciado interno
            "-fx-background-radius: 10;" // Bordes redondeados
        );
        // Añade sombra para efecto 3D
        moverButton.setEffect(new DropShadow(5, Color.BLACK));

        // Configura el botón "Reiniciar Juego" con estilo moderno
        reiniciarButton = new Button("Reiniciar Juego");
        reiniciarButton.setStyle(
            "-fx-background-color: #32CD32; " + // Fondo verde lima
            "-fx-text-fill: white; " + // Texto blanco
            "-fx-font-size: 14; " + // Tamaño de fuente
            "-fx-font-family: Verdana; " + // Fuente elegante
            "-fx-padding: 10 20; " + // Espaciado interno
            "-fx-background-radius: 10;" // Bordes redondeados
        );
        // Añade sombra para efecto 3D
        reiniciarButton.setEffect(new DropShadow(5, Color.BLACK));

        // Contenedor horizontal para los botones
        HBox botones = new HBox(10, moverButton, reiniciarButton);
        botones.setAlignment(Pos.CENTER);

        // Contenedor principal vertical para todos los elementos
        VBox root = new VBox(10, tableroYLeyenda, mensajeLabel, botones);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        // Aplica un fondo degradado a la escena
        root.setBackground(new javafx.scene.layout.Background(
            new javafx.scene.layout.BackgroundFill(
                new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                    new Stop(0, Color.DARKBLUE), // Degradado de azul oscuro
                    new Stop(1, Color.LIGHTBLUE)), // a azul claro
                null, null
            )
        ));

        // Crea y retorna la escena con dimensiones ampliadas
        return new Scene(root, 600, 500);
    }

    // Dibuja el tablero usando el renderizador y actualiza el mensaje de movimientos
    public void dibujarTablero() {
        renderizador.dibujarTablero(tableroGrid, tablero.getTablero());
        mensajeLabel.setText("Movimientos: " + tablero.getMovimientos());
    }

    // Actualiza el texto del mensaje
    public void actualizarMensaje(String mensaje) {
        mensajeLabel.setText(mensaje);
    }

    // Obtiene el botón de mover para configurar eventos
    public Button getMoverButton() {
        return moverButton;
    }

    // Obtiene el botón de reiniciar para configurar eventos
    public Button getReiniciarButton() {
        return reiniciarButton;
    }

    // Obtiene la escena para mostrarla en la aplicación
    public Scene getScene() {
        return scene;
    }
}