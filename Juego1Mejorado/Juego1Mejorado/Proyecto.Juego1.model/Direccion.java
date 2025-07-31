package Proyecto.Juego1.model;

// Enum para las direcciones en las que puede moverse el pirata
public enum Direccion {
    // Cada dirección tiene un cambio en la fila y columna del tablero
    NORTE(-1, 0),   // Mover hacia arriba (reduce la fila)
    SUR(1, 0),      // Mover hacia abajo (aumenta la fila)
    ESTE(0, 1),     // Mover a la derecha (aumenta la columna)
    OESTE(0, -1);   // Mover a la izquierda (reduce la columna)

    // Cambios en la posición (filas y columnas)
    private final int deltaFila;
    private final int deltaColumna;

    // Constructor: asigna los cambios en fila y columna para cada dirección
    Direccion(int deltaFila, int deltaColumna) {
        this.deltaFila = deltaFila;
        this.deltaColumna = deltaColumna;
    }

    // Devuelve cuánto cambia la fila al moverse en esta dirección
    public int getDeltaFila() {
        return deltaFila;
    }

    // Devuelve cuánto cambia la columna al moverse en esta dirección
    public int getDeltaColumna() {
        return deltaColumna;
    }
}