/**
 * Define el módulo de la aplicación Proyecto.Grupo.Ejercicio1.
 * Especifica las dependencias de JavaFX y los paquetes exportados o abiertos para acceso externo y reflectivo.
 */
module Proyecto.Grupo.Ejercicio1 {
    // Requiere el módulo de controles de JavaFX para componentes gráficos como VBox, ListView, Button, etc.
    requires javafx.controls;
    // Requiere el módulo FXML para soportar interfaces definidas en archivos FXML y anotaciones @FXML.
    requires javafx.fxml;

    // Exporta el paquete principal para las clases App, PrimaryController, SecondaryController, y CreateProjectController.
    exports Proyecto.Grupo.Ejercicio1;
    // Abre el paquete principal para permitir acceso reflectivo por parte de JavaFX FXML (necesario para controladores).
    opens Proyecto.Grupo.Ejercicio1 to javafx.fxml;

    // Exporta el paquete app para MainApp (si aún se usa en el proyecto).
    exports Proyecto.Grupo.Ejercicio1.app;
    // Abre el paquete app para acceso reflectivo por JavaFX.
    opens Proyecto.Grupo.Ejercicio1.app to javafx.fxml;

    // Exporta el paquete view para las clases de la interfaz gráfica programática (MainView, DonationView, etc.).
    exports Proyecto.Grupo.Ejercicio1.view;
    // Abre el paquete view para acceso reflectivo por JavaFX (por ejemplo, para ListView).
    opens Proyecto.Grupo.Ejercicio1.view to javafx.fxml, javafx.controls;

    // Exporta el paquete model para las clases del dominio (ProyectoEmprendimiento, Investigador, Colaborador, etc.).
    exports Proyecto.Grupo.Ejercicio1.model;
    // Abre el paquete model para acceso reflectivo (por ejemplo, para ListView<ProyectoEmprendimiento>).
    opens Proyecto.Grupo.Ejercicio1.model to javafx.base, javafx.fxml;
}