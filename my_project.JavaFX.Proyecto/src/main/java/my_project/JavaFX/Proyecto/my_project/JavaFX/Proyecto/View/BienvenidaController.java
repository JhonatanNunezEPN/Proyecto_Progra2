package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.View;

import javafx.scene.control.Button;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Banco;

public class BienvenidaController {
	public BienvenidaController(BienvenidaView view, Button botonGestionClientes, Button botonGestionCuentas) {
		botonGestionClientes.setOnAction(e -> {
			new GestionClientesView(view.getStage(), view.getBanco());
		});
		
		botonGestionCuentas.setOnAction(e -> {
			new GestionCuentasView(view.getStage(), view.getBanco());
		});
	}
}
