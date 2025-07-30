package Proyecto.Juego1.model;

import java.util.Random;

// Estrategia que elige una dirección aleatoria para el pirata
public class EstrategiaMovimientoAleatorio implements EstrategiaMovimiento {
    private final Random random;

    // Constructor: inicializa el generador de números aleatorios
    public EstrategiaMovimientoAleatorio() {
        this.random = new Random();
    }

    // Selecciona una dirección aleatoria (NORTE, SUR, ESTE, OESTE)
    @Override
    public Direccion elegirDireccion() {
        int dir = random.nextInt(4);
        return switch (dir) {
            case 0 -> Direccion.NORTE;
            case 1 -> Direccion.SUR;
            case 2 -> Direccion.ESTE;
            case 3 -> Direccion.OESTE;
            default -> throw new IllegalStateException("Dirección inválida");
        };
    }
}