package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto;

import javafx.application.Application;
import javafx.stage.Stage;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Banco;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.View.BienvenidaView;

public class AppSistemaBancario extends Application{
	private Banco banco = new Banco();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new BienvenidaView(primaryStage, banco);
	}

}
