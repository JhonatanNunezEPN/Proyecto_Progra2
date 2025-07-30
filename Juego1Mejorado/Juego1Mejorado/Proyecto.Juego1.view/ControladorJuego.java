package Proyecto.Juego1.view;

import Proyecto.Juego1.model.TableroJuego;

// Clase que maneja los eventos de la interfaz y coordina con el modelo
public class ControladorJuego {
    private final TableroJuego tablero;
    private final VistaJuego vista;

    // Constructor: inicializa con el tablero y la vista
    public ControladorJuego(TableroJuego tablero, VistaJuego vista) {
        this.tablero = tablero;
        this.vista = vista;
        configurarEventos();
    }

    // Configura las acciones de los botones
    private void configurarEventos() {
        vista.getMoverButton().setOnAction(e -> moverPirata());
        vista.getReiniciarButton().setOnAction(e -> reiniciarJuego());
    }

    // Mueve al pirata y actualiza la vista
    private void moverPirata() {
        boolean movimientoValido = tablero.moverPirata();
        if (movimientoValido) {
            vista.dibujarTablero();
        }
        if (tablero.isJuegoTerminado()) {
            vista.actualizarMensaje(tablero.getMensajeFinal());
        }
    }

    // Reinicia el juego y actualiza la vista
    private void reiniciarJuego() {
        tablero.inicializarTablero();
        vista.dibujarTablero();
        vista.actualizarMensaje("¡Busca el tesoro!");
    }
}