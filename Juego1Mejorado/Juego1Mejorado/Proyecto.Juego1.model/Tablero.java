package Proyecto.Juego1.model;

import java.util.Random;

// Clase que gestiona el estado del tablero y su inicialización
public class Tablero implements TableroJuego {
    private final int tamano;
    private final Casilla[][] tablero;
    private int pirataFila;
    private int pirataColumna;
    private int tesoroFila;
    private int tesoroColumna;
    private boolean juegoTerminado;
    private String mensajeFinal;
    private int movimientos;
    private final Random random;
    private final LogicaJuego logicaJuego;

    // Constructor: inicializa el tablero con una estrategia de movimiento
    public Tablero(int tamano, EstrategiaMovimiento estrategiaMovimiento) {
        this.tamano = tamano;
        this.tablero = new Casilla[tamano][tamano];
        this.random = new Random();
        this.movimientos = 0;
        this.logicaJuego = new LogicaJuego(this, estrategiaMovimiento);
        inicializarTablero();
    }

    // Configura el tablero al inicio del juego
    @Override
    public void inicializarTablero() {
        // Pone terreno en todas las casillas
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                tablero[i][j] = Casilla.TERRENO;
            }
        }

        // Pone agua en los bordes
        for (int i = 0; i < tamano; i++) {
            tablero[0][i] = Casilla.AGUA;
            tablero[tamano - 1][i] = Casilla.AGUA;
            tablero[i][0] = Casilla.AGUA;
            tablero[i][tamano - 1] = Casilla.AGUA;
        }

        // Pone puentes en las esquinas opuestas
        tablero[0][0] = Casilla.PUENTE;
        tablero[tamano - 1][tamano - 1] = Casilla.PUENTE;

        // Coloca al pirata en una posición aleatoria
        do {
            pirataFila = random.nextInt(tamano - 2) + 1;
            pirataColumna = random.nextInt(tamano - 2) + 1;
        } while (tablero[pirataFila][pirataColumna] != Casilla.TERRENO);

        // Coloca el tesoro en una posición aleatoria
        do {
            tesoroFila = random.nextInt(tamano - 2) + 1;
            tesoroColumna = random.nextInt(tamano - 2) + 1;
        } while (tablero[tesoroFila][tesoroColumna] != Casilla.TERRENO ||
                (tesoroFila == pirataFila && tesoroColumna == pirataColumna));

        // Coloca al pirata y al tesoro
        tablero[pirataFila][pirataColumna] = Casilla.PIRATA;
        tablero[tesoroFila][tesoroColumna] = Casilla.TESORO;

        // Reinicia el estado del juego
        juegoTerminado = false;
        mensajeFinal = "";
        movimientos = 0;
    }

    // Mueve al pirata delegando a la lógica del juego
    @Override
    public boolean moverPirata() {
        return logicaJuego.moverPirata();
    }

    // Getters para acceder al estado
    @Override
    public Casilla[][] getTablero() {
        return tablero;
    }

    @Override
    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    @Override
    public String getMensajeFinal() {
        return mensajeFinal;
    }

    @Override
    public int getMovimientos() {
        return movimientos;
    }

    // Métodos internos para que LogicaJuego actualice el estado
    protected void setPirataPosicion(int fila, int columna) {
        tablero[pirataFila][pirataColumna] = Casilla.TERRENO;
        pirataFila = fila;
        pirataColumna = columna;
        tablero[pirataFila][pirataColumna] = Casilla.PIRATA;
    }

    protected void setJuegoTerminado(boolean terminado, String mensaje) {
        this.juegoTerminado = terminado;
        this.mensajeFinal = mensaje;
    }

    protected void incrementarMovimientos() {
        this.movimientos++;
    }

    protected int getTamano() {
        return tamano;
    }

    protected int getPirataFila() {
        return pirataFila;
    }

    protected int getPirataColumna() {
        return pirataColumna;
    }

    protected int getTesoroFila() {
        return tesoroFila;
    }

    protected int getTesoroColumna() {
        return tesoroColumna;
    }
}