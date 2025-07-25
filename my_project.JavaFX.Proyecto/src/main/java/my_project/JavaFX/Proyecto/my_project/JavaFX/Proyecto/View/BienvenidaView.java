package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Banco;

public class BienvenidaView {
	private Stage stageOriginal;
	private Banco bancoOriginal;
	
	public BienvenidaView(Stage stage, Banco banco) {
		stageOriginal = stage;
		bancoOriginal = banco;
		Label textoBienvenida = new Label("Bienvenido Bancario EPN");
		Button botonGestionClientes = new Button("Gestion de Clientes");
		Button botonGestionCuentas = new Button("Gestion de Cuentas");
		HBox hBoxBotones = new HBox(50, botonGestionClientes, botonGestionCuentas);
		VBox layout = new VBox(70, textoBienvenida, hBoxBotones);
		
		textoBienvenida.setStyle(
								 "-fx-font-size: 30px;" +
								 "-fx-text-fill: white;" +
								 "-fx-font-weight: bold;" +
								 "-fx-font-family: 'Arial';" +
								 "-fx-text-fill: #343A40;"
								 );
		layout.setPadding(new Insets(20));
		layout.setAlignment(Pos.CENTER);
		layout.setStyle(
						"-fx-border-color: #0056B3;" +
						"-fx-border-width: 2;" +
						"-fx-border-radius: 3;" +
						"-fx-background-color: #E0F2F7;"
						);
		hBoxBotones.setAlignment(Pos.CENTER);
		botonGestionClientes.setStyle(
									  "-fx-background-color: #0056B3;" +
									  "-fx-text-fill: white;" +
									  "-fx-font-size: 16px;" +              
									  "-fx-font-weight: bold;" +           
									  "-fx-background-radius: 10;" +        
									  "-fx-border-radius: 10;" +            
									  "-fx-padding: 10 20 10 20;"
									  );
			
		botonGestionCuentas.setStyle(
								   	 "-fx-background-color: #0056B3;" +
									 "-fx-text-fill: white;" +
									 "-fx-font-size: 16px;" +              
									 "-fx-font-weight: bold;" +           
									 "-fx-background-radius: 10;" +        
									 "-fx-border-radius: 10;" +            
									 "-fx-padding: 10 20 10 20;"
									 );
		
		Scene escenaBienvenida = new Scene(layout, 800, 500);
		stage.setTitle("Sistema Bancario");
		stage.setScene(escenaBienvenida);
		stage.show();
		
		new BienvenidaController(this, botonGestionClientes, botonGestionCuentas);
	}
	
	public Stage getStage() {
		return stageOriginal;
	}
	
	public Banco getBanco() {
		return bancoOriginal;
	}
}
