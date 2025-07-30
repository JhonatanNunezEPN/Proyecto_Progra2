package Proyecto.Juego1.view;

import Proyecto.Juego1.model.Casilla;
import javafx.scene.layout.GridPane;

// Interfaz para renderizar el tablero en la interfaz gráfica
public interface RenderizadorTablero {
    // Dibuja el tablero en la cuadrícula proporcionada
    void dibujarTablero(GridPane grid, Casilla[][] tablero);
}