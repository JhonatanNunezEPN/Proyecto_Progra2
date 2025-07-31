package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.ModelJuego2;

public class Tablero {
	
	//Constantes para el tamaño del tablero
    private final int FILAS = 6;
    private final int COLUMNAS = 7;
    
    //Matriz 6x7 que guarda el estado de cada celda (ROJO, BLANCO, VACIO).
    private FichaColor[][] tablero;
    private FichaColor turnoActual;

    public Tablero() {
    	//Inicializa la matriz de celdas.
        tablero = new FichaColor[FILAS][COLUMNAS];
        
        //Llena toda la matriz con VACIO, indicando que todas las celdas están libres.
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = FichaColor.VACIO;
            }
        }
        turnoActual = FichaColor.ROJO; // Rojo comienza por defecto
    }
    
    // Getters y método para alternar entre los jugadores.
    public FichaColor[][] getTablero() {
        return tablero;
    }

    public FichaColor getTurnoActual() {
        return turnoActual;
    }

    public void cambiarTurno() {
        turnoActual = (turnoActual == FichaColor.ROJO) ? FichaColor.AZUL : FichaColor.ROJO;
    }
    
    //Intenta insertar una ficha en la columna indicada.
    public int insertarFicha(int columna) {
    	//Recorre de abajo hacia arriba para encontrar la primera celda vacía. Inserta allí la ficha y retorna la fila.
        for (int fila = FILAS - 1; fila >= 0; fila--) {
            if (tablero[fila][columna] == FichaColor.VACIO) {
                tablero[fila][columna] = turnoActual;
                return fila; // devuelve en qué fila cayó la ficha
            }
        }
        return -1; // columna llena
    }
    
    //Verifica si la primera fila ya está ocupada, lo cual indica que la columna está llena.
    public boolean columnaLlena(int columna) {
        return tablero[0][columna] != FichaColor.VACIO;
    }
    
    //Lógica completa para verificar si hay un ganador o empate.
    public EstadoJuego verificarEstado() {
    	//Recorre cada celda del tablero. Si está vacía, salta.
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
        
        //Si no hay ganador, y hay espacios → el juego sigue. Si no hay espacios, hay empate.
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
    
    //Método para resetear el tablero a estado inicial.
    public void reiniciar() {
    	//Borra el tablero y vuelve a dar el turno al rojo.
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = FichaColor.VACIO;
            }
        }
        turnoActual = FichaColor.ROJO;
    }
}
