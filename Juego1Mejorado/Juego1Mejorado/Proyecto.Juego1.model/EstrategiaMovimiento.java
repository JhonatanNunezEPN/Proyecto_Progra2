package Proyecto.Juego1.model;

// Interfaz para definir cómo se elige la dirección del pirata
public interface EstrategiaMovimiento {
    // Selecciona una dirección para el movimiento del pirata
    Direccion elegirDireccion();
}