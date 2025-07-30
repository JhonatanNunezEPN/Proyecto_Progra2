package Proyecto.Juego1.model;

// Clase que maneja la lógica del juego
public class LogicaJuego {
    private final Tablero tablero;
    private final EstrategiaMovimiento estrategiaMovimiento;
    private static final int MAX_MOVIMIENTOS = 50;

    // Constructor: inicializa con el tablero y la estrategia de movimiento
    public LogicaJuego(Tablero tablero, EstrategiaMovimiento estrategiaMovimiento) {
        this.tablero = tablero;
        this.estrategiaMovimiento = estrategiaMovimiento;
    }

    // Mueve al pirata según las reglas del juego
    public boolean moverPirata() {
        if (tablero.isJuegoTerminado() || tablero.getMovimientos() >= MAX_MOVIMIENTOS) {
            return false;
        }

        Direccion dir = estrategiaMovimiento.elegirDireccion();
        int nuevaFila = tablero.getPirataFila() + dir.getDeltaFila();
        int nuevaColumna = tablero.getPirataColumna() + dir.getDeltaColumna();

        if (nuevaFila < 0 || nuevaFila >= tablero.getTamano() || 
            nuevaColumna < 0 || nuevaColumna >= tablero.getTamano()) {
            return false;
        }

        Casilla destino = tablero.getTablero()[nuevaFila][nuevaColumna];
        if (destino == Casilla.AGUA) {
            tablero.setJuegoTerminado(true, "¡El pirata se ha ahogado!");
            return false;
        }

        if (destino == Casilla.TESORO) {
            tablero.setJuegoTerminado(true, "¡El pirata ha encontrado el tesoro en " + 
                (tablero.getMovimientos() + 1) + " movimientos!");
            return true;
        }

        tablero.setPirataPosicion(nuevaFila, nuevaColumna);
        tablero.incrementarMovimientos();

        if (tablero.getMovimientos() >= MAX_MOVIMIENTOS) {
            tablero.setJuegoTerminado(true, "¡El pirata no encontró el tesoro en 50 movimientos!");
        }

        return true;
    }
}