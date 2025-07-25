package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.View;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Cliente;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.ClienteInexistenteException;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Cuenta;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.CuentaCajaAhorro;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.CuentaCorriente;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.NumCuentaDuplicadoException;

public class GestionCuentasController {
	private final GestionCuentasView view;
	private List<Integer> numCuentas;
	private List<Integer> idClientes;
	private FilteredList<Cuenta> listaFiltradaCuentas;
	private Scene escenaResultado;
	private Label textoResultado;
	private Stage stageResultado;
	
	public GestionCuentasController(GestionCuentasView view, Button botonCrearCuenta, Button botonBuscarCuenta,
			Button botonDepositar, Button botonRetirar, Button botonRegresar) {
		this.view = view;
		numCuentas = new ArrayList<Integer>();
		idClientes = view.getBanco().getClientes().stream().map(Cliente :: getId).collect(Collectors.toList());
		listaFiltradaCuentas = new FilteredList<>(view.getCuentas(), p -> true);
		view.getTabla().setItems(listaFiltradaCuentas);
		stageResultado = new Stage();
		
		botonCrearCuenta.setOnAction(e -> {
			try {
				int id = Integer.parseInt(view.getIdInput().getText());
				int numCuenta = Integer.parseInt(view.getNumCuentaInput().getText());
				String tipo = view.getTipoCuenta().getValue();
				
				if(numCuentas.contains(numCuenta)) {
					throw new NumCuentaDuplicadoException(numCuenta);
				}else if(!idClientes.contains(id)) {
					throw new ClienteInexistenteException(id);
				}
				
				numCuentas.add(numCuenta);
				Cliente cliente = view.getBanco().getClientes().stream().filter(cl -> cl.getId() == id).
						findFirst().orElse(null);
			
				
				switch(tipo) {
				case "Caja Ahorro":{
					int movAnuales = Integer.parseInt(view.getMaxMovimientosInput().getText());
					Cuenta cuenta = new CuentaCajaAhorro(numCuenta, cliente, movAnuales);
					view.getCuentas().add(cuenta);
					view.getIdInput().clear();
					view.getNumCuentaInput().clear();
					view.getMaxMovimientosInput().clear();
					cliente.agregarCuenta(cuenta);
					textoResultado = new Label("Cuenta de caja de ahorro creada exitosamente");
					escenaResultado = new Scene(textoResultado, 200, 100);
					stageResultado.setScene(escenaResultado);
					stageResultado.show();
					break;
				}
				
				case "Cuenta Corriente":{
					Cuenta cuenta = new CuentaCorriente(numCuenta, cliente);
					view.getCuentas().add(cuenta);
					view.getIdInput().clear();
					view.getNumCuentaInput().clear();
					view.getMaxMovimientosInput().clear();
					cliente.agregarCuenta(cuenta);
					textoResultado = new Label("Cuenta corriente creada exitosamente");
					escenaResultado = new Scene(textoResultado, 200, 100);
					stageResultado.setScene(escenaResultado);
					stageResultado.show();
					break;
				}
				
				default:{
					view.getIdInput().clear();
					view.getNumCuentaInput().clear();
					view.getMaxMovimientosInput().clear();
					textoResultado = new Label("No se pudo crear la cuenta");
					escenaResultado = new Scene(textoResultado, 200, 100);
					stageResultado.setScene(escenaResultado);
					stageResultado.show();
				}
				}
			}catch(NumCuentaDuplicadoException exception) {
				textoResultado = new Label("El numero de cuenta ya esta en uso");
				escenaResultado = new Scene(textoResultado, 200, 100);
				stageResultado.setScene(escenaResultado);
				stageResultado.show();
			}catch(ClienteInexistenteException exception) {
				textoResultado = new Label("El cliente con la id " + exception.getId() + " no existe");
				escenaResultado = new Scene(textoResultado, 200, 100);
				stageResultado.setScene(escenaResultado);
				stageResultado.show();
			}
		});
		
		botonBuscarCuenta.setOnAction(e -> {
			String numCuentaBuscar = view.getNumCuentaInput().getText();
			listaFiltradaCuentas.setPredicate(cuenta -> {
				if(numCuentaBuscar == null || numCuentaBuscar.isEmpty()) {
					return true;
				}
				
				return String.valueOf(cuenta.getNumero()).contains(numCuentaBuscar);
			});
			
			view.getIdInput().clear();
			view.getNumCuentaInput().clear();
			view.getMaxMovimientosInput().clear();
		});
		
		botonDepositar.setOnAction(e -> {
			try {
				Cuenta cuenta = view.getTabla().getSelectionModel().getSelectedItem();
				
				int monto = Integer.parseInt(view.getMontoInput().getText());
				
				double saldo = cuenta.deposito(monto, cuenta.getCliente());
				
				cuenta.setSaldo(saldo);
				view.getMontoInput().clear();
				view.getTabla().refresh();
				
				textoResultado = new Label("Deposito realizado exitosamente. Su nuevo saldo es de: " + saldo);
				escenaResultado = new Scene(textoResultado, 200, 100);
				stageResultado.setScene(escenaResultado);
				stageResultado.show();
			}catch(RuntimeException exception) {
				textoResultado = new Label("No se pudo realizar el deposito, Ingrese un monto positivo o sus movimientos acabaron");
				escenaResultado = new Scene(textoResultado, 200, 100);
				stageResultado.setScene(escenaResultado);
				stageResultado.show();
			}
		});
		
		botonRetirar.setOnAction(e ->{
			try {
				Cuenta cuenta = view.getTabla().getSelectionModel().getSelectedItem();
				
				int monto = Integer.parseInt(view.getMontoInput().getText());
				
				double saldo = cuenta.retiro(monto, cuenta.getCliente());
				
				cuenta.setSaldo(saldo);
				view.getMontoInput().clear();
				view.getTabla().refresh();
				
				textoResultado = new Label("Deposito realizado exitosamente. Su nuevo saldo es de: " + saldo);
				escenaResultado = new Scene(textoResultado, 200, 100);
				stageResultado.setScene(escenaResultado);
				stageResultado.show();
			}catch(RuntimeException exception) {
				textoResultado = new Label("No se pudo realizar el retiro. Ingrese un monto positivo, "
						+ "monto mayor a su saldo actual o sus movimientos acabaron");
				escenaResultado = new Scene(textoResultado, 200, 100);
				stageResultado.setScene(escenaResultado);
				stageResultado.show();
			}
		});
		
		botonRegresar.setOnAction(e -> {
			new BienvenidaView(view.getStage(), view.getBanco());
		});
	}
}
