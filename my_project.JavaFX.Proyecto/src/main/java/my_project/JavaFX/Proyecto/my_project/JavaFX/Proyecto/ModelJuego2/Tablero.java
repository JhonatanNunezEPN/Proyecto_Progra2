package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.ModelJuego2;

public class Tablero {
    private final int FILAS = 6;
    private final int COLUMNAS = 7;
    private FichaColor[][] tablero;
    private FichaColor turnoActual;

    public Tablero() {
        tablero = new FichaColor[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = FichaColor.VACIO;
            }
        }
        turnoActual = FichaColor.ROJO; // Rojo comienza por defecto
    }

    public FichaColor[][] getTablero() {
        return tablero;
    }

    public FichaColor getTurnoActual() {
        return turnoActual;
    }

    public void cambiarTurno() {
        turnoActual = (turnoActual == FichaColor.ROJO) ? FichaColor.AZUL : FichaColor.ROJO;
    }

    public int insertarFicha(int columna) {
        for (int fila = FILAS - 1; fila >= 0; fila--) {
            if (tablero[fila][columna] == FichaColor.VACIO) {
                tablero[fila][columna] = turnoActual;
                return fila; // devuelve en qué fila cayó la ficha
            }
        }
        return -1; // columna llena
    }

    public boolean columnaLlena(int columna) {
        return tablero[0][columna] != FichaColor.VACIO;
    }

    public EstadoJuego verificarEstado() {
        // Revisar todas las direcciones
        for (int fila = 0; fila < FILAS; fila++) {
            for (int col = 0; col < COLUMNAS; col++) {
                FichaColor actual = tablero[fila][col];
                if (actual == FichaColor.VACIO) continue;

                // Horizontal
                if (col <= COLUMNAS - 4 &&
                    actual == tablero[fila][col + 1] &&
                    actual == tablero[fila][col + 2] &&
                    actual == tablero[fila][col + 3]) {
                    return actual == FichaColor.ROJO ? EstadoJuego.GANA_ROJO : EstadoJuego.GANA_BLANCO;
                }

                // Vertical
                if (fila <= FILAS - 4 &&
                    actual == tablero[fila + 1][col] &&
                    actual == tablero[fila + 2][col] &&
                    actual == tablero[fila + 3][col]) {
                    return actual == FichaColor.ROJO ? EstadoJuego.GANA_ROJO : EstadoJuego.GANA_BLANCO;
                }

                // Diagonal ↘
                if (fila <= FILAS - 4 && col <= COLUMNAS - 4 &&
                    actual == tablero[fila + 1][col + 1] &&
                    actual == tablero[fila + 2][col + 2] &&
                    actual == tablero[fila + 3][col + 3]) {
                    return actual == FichaColor.ROJO ? EstadoJuego.GANA_ROJO : EstadoJuego.GANA_BLANCO;
                }

                // Diagonal ↙
                if (fila >= 3 && col <= COLUMNAS - 4 &&
                    actual == tablero[fila - 1][col + 1] &&
                    actual == tablero[fila - 2][col + 2] &&
                    actual == tablero[fila - 3][col + 3]) {
                    return actual == FichaColor.ROJO ? EstadoJuego.GANA_ROJO : EstadoJuego.GANA_BLANCO;
                }
            }
        }

        // Verificar empate
        boolean hayEspacios = false;
        for (int col = 0; col < COLUMNAS; col++) {
            if (!columnaLlena(col)) {
                hayEspacios = true;
                break;
            }
        }

        return hayEspacios ? EstadoJuego.EN_CURSO : EstadoJuego.EMPATE;
    }

    public void reiniciar() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = FichaColor.VACIO;
            }
        }
        turnoActual = FichaColor.ROJO;
    }
}
