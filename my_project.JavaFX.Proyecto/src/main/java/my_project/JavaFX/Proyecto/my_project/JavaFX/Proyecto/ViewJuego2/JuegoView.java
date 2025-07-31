package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.ViewJuego2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class JuegoView {
	//Declarar recursos para el view
    private Stage stage;
    private GridPane tableroGrid;
    private Button[] botonesColumna;
    private Circle[][] celdas;
    private Label estadoLabel;

    public JuegoView(Stage stage) {
    	//Inicializar los recursos
        this.stage = stage;
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(15));
        layout.setAlignment(Pos.CENTER);

        estadoLabel = new Label("Turno: Rojo");
        tableroGrid = new GridPane();
        tableroGrid.setAlignment(Pos.CENTER);
        tableroGrid.setHgap(5);
        tableroGrid.setVgap(5);
        tableroGrid.setPadding(new Insets(10));

        // 6 filas x 7 columnas para el tablero
        celdas = new Circle[6][7];
        botonesColumna = new Button[7];

        HBox botones = new HBox(5);
        botones.setAlignment(Pos.CENTER);
        
        //Bucle para crear los botones
        for (int col = 0; col < 7; col++) {
            Button boton = new Button("↓");
            boton.setPrefWidth(40);
            boton.setUserData(col); // para saber cuál columna se presiona
            botonesColumna[col] = boton;
            botones.getChildren().add(boton);
        }

        //Bucle para crear las celdas
        for (int fila = 0; fila < 6; fila++) {
            for (int col = 0; col < 7; col++) {
                Circle circulo = new Circle(20, Color.LIGHTGRAY); // celda vacía
                celdas[fila][col] = circulo;
                StackPane celda = new StackPane(circulo);
                celda.setPrefSize(45, 45);
                celda.setStyle("-fx-border-color: black;");
                tableroGrid.add(celda, col, fila);
            }
        }

        //Agregar todo al view final
        layout.getChildren().addAll(estadoLabel, botones, tableroGrid);
        Scene scene = new Scene(layout, 500, 500);
        stage.setTitle("Cuatro en Línea");
        stage.setScene(scene);
        stage.show();

        new JuegoController(this);
    }

    public Circle[][] getCeldas() {
        return celdas;
    }

    public Button[] getBotonesColumna() {
        return botonesColumna;
    }

    public Label getEstadoLabel() {
        return estadoLabel;
    }

    public Stage getStage() {
        return stage;
    }
}
