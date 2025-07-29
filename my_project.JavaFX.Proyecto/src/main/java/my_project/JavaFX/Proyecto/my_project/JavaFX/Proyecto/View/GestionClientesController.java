package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.View;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Banco;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Cliente;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.IdDuplicadoException;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.NumTelefonoDuplicado;

public class GestionClientesController {
	//Atributos
	private final GestionClientesView view;
	private List<Integer> idClientes;
	private List<String> numTelClientes;
	private FilteredList<Cliente> listaFiltradaClientes;
	private Scene escenaResultado;
	private Label textoResultado;
	private Stage stageResultado;
	
	public GestionClientesController(GestionClientesView view, Button botonAgregarCliente,
			Button botonBuscarCliente, Button botonRegresar) {
		//Creacion de elementos a usar
		this.view = view;
		idClientes = new ArrayList<Integer>();
		numTelClientes = new ArrayList<String>();
		listaFiltradaClientes = new FilteredList<>(view.getClientes(), p -> true);
		view.getTabla().setItems(listaFiltradaClientes);
		stageResultado = new Stage();
		
		//Aplicar acciones para los botones cuando se los aplastan
		botonAgregarCliente.setOnAction(e -> {
			try {
				int id = Integer.parseInt(view.getIdInput().getText());
				String nombre = view.getNombreInput().getText();
				String numTelefono = view.getNumTelefonoInput().getText();
				
				//Verificacion de restricciones
				if(idClientes.contains(id)) {
					throw new IdDuplicadoException(id);
				}else if(numTelClientes.contains(numTelefono)) {
					throw new NumTelefonoDuplicado(numTelefono);
				}
				
				//Agregar datos obtenidos
				idClientes.add(id);
				numTelClientes.add(numTelefono);
				Cliente cliente = new Cliente(id, nombre, numTelefono);
				//Limpar la interfaz
				view.getClientes().add(cliente);
				view.getIdInput().clear();
				view.getNombreInput().clear();
				view.getNumTelefonoInput().clear();
				view.getBanco().agregarCliente(cliente);
				textoResultado = new Label("Cliente agregado exitosamente");
				escenaResultado = new Scene(textoResultado, 200, 100);
				stageResultado.setScene(escenaResultado);
				stageResultado.show();
			}catch(IdDuplicadoException exception) {
				textoResultado = new Label("Id duplicado");
				escenaResultado = new Scene(textoResultado, 300, 200);
				stageResultado.setScene(escenaResultado);
				stageResultado.show();
			}catch(NumTelefonoDuplicado exception) {
				textoResultado = new Label("Numero de telefono duplicado");
				escenaResultado = new Scene(textoResultado, 300, 200);
				stageResultado.setScene(escenaResultado);
				stageResultado.show();
			}
		});
		
		botonBuscarCliente.setOnAction(e -> {
			String idBuscar = view.getIdInput().getText();
			listaFiltradaClientes.setPredicate(cliente -> {
				if(idBuscar == null || idBuscar.isEmpty()) {
					return true;
				}
				
				return String.valueOf(cliente.getId()).contains(idBuscar);
			});
			
			view.getIdInput().clear();
			view.getNombreInput().clear();
			view.getNumTelefonoInput().clear();
		});
		
		botonRegresar.setOnAction(e -> {
			new BienvenidaView(view.getStage(), view.getBanco());
		});
	}
}
