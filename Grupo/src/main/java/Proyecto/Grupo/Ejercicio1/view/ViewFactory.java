package Proyecto.Grupo.Ejercicio1.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Clase que actúa como fábrica para crear componentes de la interfaz gráfica con estilos consistentes.
 * Centraliza la creación de elementos de UI para evitar duplicación de código y facilitar cambios de estilo.
 */
public class ViewFactory {

    /**
     * Crea un contenedor vertical (VBox) con estilos predefinidos.
     * Configura márgenes, espaciado y alineación para un diseño uniforme.
     * @return Un objeto VBox configurado con 10 píxeles de espaciado y centrado.
     */
    public static VBox createStyledVBox() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }

    /**
     * Crea una etiqueta (Label) con estilos personalizados según si es un título o no.
     * @param text El texto que mostrará la etiqueta.
     * @param isTitle Indica si la etiqueta es un título (true) o una etiqueta normal (false).
     * @return Un objeto Label con el texto y estilo especificados.
     */
    public static Label createStyledLabel(String text, boolean isTitle) {
        Label label = new Label(text);
        if (isTitle) {
            label.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #333333;");
        } else {
            label.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #333333;");
        }
        return label;
    }

    /**
     * Crea un botón con un texto y color de fondo personalizados.
     * @param text El texto que mostrará el botón.
     * @param backgroundColor El color de fondo en formato hexadecimal (ej. "#4CAF50").
     * @return Un objeto Button con el texto y estilo especificados.
     */
    public static Button createStyledButton(String text, String backgroundColor) {
        Button button = new Button(text);
        button.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20; -fx-border-radius: 5;", backgroundColor));
        return button;
    }

    /**
     * Crea un campo de texto (TextField) con un texto de ayuda y estilo predefinido.
     * @param promptText El texto de ayuda que se muestra cuando el campo está vacío.
     * @return Un objeto TextField con el texto de ayuda y estilo especificados.
     */
    public static TextField createStyledTextField(String promptText) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5; -fx-padding: 8;");
        return textField;
    }
}