package Proyecto.Juego1.model;

// Un "enum" es como una lista de opciones fijas que no cambian
public enum Casilla {
    // Tipos de casillas con su símbolo para mostrar en la pantalla
    AGUA('~'),      // Representa el agua
    PUENTE('P'),    // Representa un puente
    TERRENO('.'),   // Representa terreno vacío
    PIRATA('X'),    // Representa al pirata
    TESORO('T');    // Representa el tesoro

    // Cada casilla tiene un símbolo (como '~' o 'X')
    private final char simbolo;

    // Constructor: asigna un símbolo a cada tipo de casilla
    Casilla(char simbolo) {
        this.simbolo = simbolo;
    }

    // Devuelve el símbolo de la casilla para mostrarlo en la pantalla
    public char getSimbolo() {
        return simbolo;
    }
}