module Proyecto.Juego1 {
    // Necesitamos JavaFX para mostrar la interfaz gráfica
    requires javafx.controls;
    requires javafx.graphics; // Incluir el módulo de Stage

    // Permitimos que otras partes del programa accedan a la clase principal
    exports Proyecto.Juego1.app;
}