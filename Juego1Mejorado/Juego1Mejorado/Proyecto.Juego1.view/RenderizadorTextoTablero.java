package Proyecto.Juego1.view;

import Proyecto.Juego1.model.Casilla;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

// Renderiza el tablero con texto estilizado y fondos para las casillas
public class RenderizadorTextoTablero implements RenderizadorTablero {
    // Dibuja el tablero en la cuadrícula con estilo visual mejorado
    @Override
    public void dibujarTablero(GridPane grid, Casilla[][] tablero) {
        // Limpia el contenido anterior del GridPane para evitar superposiciones
        grid.getChildren().clear();
        // Itera sobre las filas del tablero
        for (int i = 0; i < tablero.length; i++) {
            // Itera sobre las columnas de cada fila
            for (int j = 0; j < tablero[i].length; j++) {
                // Crea un contenedor StackPane para combinar fondo y texto en cada casilla
                StackPane casillaPane = new StackPane();
                // Crea un rectángulo de 40x40 píxeles como fondo de la casilla
                Rectangle fondo = new Rectangle(40, 40);
                // Crea el texto que representa el símbolo de la casilla
                Text texto = new Text(String.valueOf(tablero[i][j].getSimbolo()));
                // Establece una fuente elegante y legible para el texto
                texto.setFont(new Font("Verdana", 20));

                // Configura el estilo según el tipo de casilla
                switch (tablero[i][j].getSimbolo()) {
                    case 'X': // Caso para el pirata
                        // Texto dorado para destacar al pirata
                        texto.setFill(Color.GOLD);
                        // Fuente más grande para mayor énfasis
                        texto.setFont(new Font("Verdana", 24));
                        // Sombra negra para un efecto 3D
                        texto.setEffect(new DropShadow(5, Color.BLACK));
                        // Fondo azul oscuro para contraste
                        fondo.setFill(Color.DARKBLUE);
                        // Borde dorado para un toque elegante
                        fondo.setStroke(Color.GOLD);
                        fondo.setStrokeWidth(2);
                        break;
                    case 'T': // Caso para el tesoro
                        // Texto amarillo para representar riqueza
                        texto.setFill(Color.YELLOW);
                        // Fondo dorado oscuro para un aspecto lujoso
                        fondo.setFill(Color.DARKGOLDENROD);
                        break;
                    case '~': // Caso para el agua
                        // Texto blanco para visibilidad
                        texto.setFill(Color.WHITE);
                        // Fondo azul claro para simular agua
                        fondo.setFill(Color.DEEPSKYBLUE);
                        break;
                    case 'P': // Caso para el puente
                        // Texto blanco para contraste
                        texto.setFill(Color.WHITE);
                        // Fondo marrón para representar madera
                        fondo.setFill(Color.SADDLEBROWN);
                        break;
                    case '.': // Caso para el terreno
                        // Texto verde oscuro para naturalidad
                        texto.setFill(Color.DARKGREEN);
                        // Fondo verde claro para simular césped
                        fondo.setFill(Color.LIGHTGREEN);
                        break;
                    default: // Caso por defecto para casillas desconocidas
                        // Texto negro para simplicidad
                        texto.setFill(Color.BLACK);
                        // Fondo gris claro como predeterminado
                        fondo.setFill(Color.LIGHTGRAY);
                }

                // Añade el fondo y el texto al StackPane
                casillaPane.getChildren().addAll(fondo, texto);
                // Coloca el StackPane en la posición correspondiente del GridPane
                grid.add(casillaPane, j, i);
            }
        }
    }
}