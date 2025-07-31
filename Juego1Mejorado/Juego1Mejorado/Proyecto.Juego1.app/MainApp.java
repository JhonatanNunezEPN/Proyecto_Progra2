package Proyecto.Juego1.app;

import Proyecto.Juego1.model.EstrategiaMovimientoAleatorio;
import Proyecto.Juego1.model.Tablero;
import Proyecto.Juego1.view.ControladorJuego;
import Proyecto.Juego1.view.RenderizadorTextoTablero;
import Proyecto.Juego1.view.VistaJuego;
import javafx.application.Application;
import javafx.stage.Stage;

// Clase que inicia el juego
public class MainApp extends Application {
    // Método que se ejecuta al iniciar el programa
    @SuppressWarnings({ "unused", "exports" })
	@Override
    public void start(Stage stage) {
        // Crea las instancias necesarias
        Tablero tablero = new Tablero(5, new EstrategiaMovimientoAleatorio());
        RenderizadorTextoTablero renderizador = new RenderizadorTextoTablero();
        VistaJuego vista = new VistaJuego(tablero, renderizador);
        ControladorJuego controlador = new ControladorJuego(tablero, vista);

        // Configura la ventana principal
        stage.setTitle("Juego del Pirata Pata de Palo");
        stage.setScene(vista.getScene());
        stage.show();
    }

    // Punto de entrada del programa
    public static void main(String[] args) {
        launch();
    }
}