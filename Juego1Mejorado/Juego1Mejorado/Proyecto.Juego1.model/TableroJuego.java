package Proyecto.Juego1.model;

// Interfaz que define los métodos para interactuar con el tablero del juego
public interface TableroJuego {
    // Obtiene la matriz del tablero
    Casilla[][] getTablero();
    // Mueve al pirata según las reglas del juego
    boolean moverPirata();
    // Indica si el juego ha terminado
    boolean isJuegoTerminado();
    // Obtiene el mensaje final del juego
    String getMensajeFinal();
    // Obtiene el número de movimientos realizados
    int getMovimientos();
    // Reinicia el tablero para un nuevo juego
    void inicializarTablero();
}