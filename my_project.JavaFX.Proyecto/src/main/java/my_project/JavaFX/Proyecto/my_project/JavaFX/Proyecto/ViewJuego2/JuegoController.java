package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.ViewJuego2;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.ModelJuego2.*;

public class JuegoController {
    private final JuegoView view;
    private final Tablero tablero;

    public JuegoController(JuegoView view) {
        this.view = view;
        this.tablero = new Tablero();

        // Asociar eventos a cada botón de columna
        for (Button boton : view.getBotonesColumna()) {
            boton.setOnAction(e -> {
                int col = (int) boton.getUserData();
                jugarTurno(col);
            });
        }
    }

    private void jugarTurno(int columna) {
        if (tablero.columnaLlena(columna)) {
            mostrarMensaje("Columna llena", "Intenta en otra columna");
            return;
        }

        int fila = tablero.insertarFicha(columna);
        FichaColor colorActual = tablero.getTurnoActual();
        actualizarVista(fila, columna, colorActual);

        EstadoJuego estado = tablero.verificarEstado();
        if (estado == EstadoJuego.GANA_ROJO) {
            mostrarMensaje("¡Ganó Rojo!", "Felicidades");
            deshabilitarBotones();
        } else if (estado == EstadoJuego.GANA_BLANCO) {
            mostrarMensaje("¡Ganó Blanco!", "Felicidades");
            deshabilitarBotones();
        } else if (estado == EstadoJuego.EMPATE) {
            mostrarMensaje("Empate", "El tablero se ha llenado");
            deshabilitarBotones();
        } else {
            tablero.cambiarTurno();
            view.getEstadoLabel().setText("Turno: " + (tablero.getTurnoActual() == FichaColor.ROJO ? "Rojo" : "Blanco"));
        }
    }

    private void actualizarVista(int fila, int col, FichaColor color) {
        Circle celda = view.getCeldas()[fila][col];
        if (color == FichaColor.ROJO) {
            celda.setFill(Color.RED);
        } else if (color == FichaColor.AZUL) {
            celda.setFill(Color.BLUE);
        }
    }

    private void deshabilitarBotones() {
        for (Button boton : view.getBotonesColumna()) {
            boton.setDisable(true);
        }
    }

    private void mostrarMensaje(String titulo, String contenido) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
