package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.View;

import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Banco;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Cliente;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Cuenta;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.CuentaCajaAhorro;

public class GestionCuentasView {
	private TableView<Cuenta> tabla;
	private ObservableList<Cuenta> cuentas;
	private TextField idInput;
	private TextField numCuenta;
	private TextField maxMovimientos;
	private TextField montoInput;
	private ComboBox<String> tipoCuenta;
	private Stage stageOriginal;
	private Banco bancoOriginal;
	
	public GestionCuentasView(Stage stage, Banco banco) {
		stageOriginal = stage;
		bancoOriginal = banco;
		tabla = new TableView<Cuenta>();
		cuentas = FXCollections.observableArrayList(banco.getClientes().stream().
				flatMap(cliente -> cliente.getCuentas().stream()).collect(Collectors.toList()));
		idInput = new TextField();
		idInput.setPromptText("ID");
		numCuenta = new TextField();
		numCuenta.setPromptText("Numero de Cuenta");
		maxMovimientos = new TextField();
		maxMovimientos.setPromptText("Maximo de Movimientos");
		montoInput = new TextField();
		montoInput.setPromptText("Monto");
		tipoCuenta = new ComboBox<String>();
		tipoCuenta.getItems().addAll("Caja Ahorro", "Cuenta Corriente");
		tipoCuenta.setValue("Seleccione tipo");
		
		TableColumn<Cuenta, Number> colNumCuenta = new TableColumn<Cuenta, Number>("Numero de cuenta");
		colNumCuenta.setCellValueFactory(cuenta -> new SimpleIntegerProperty(cuenta.getValue().getNumero()));
		TableColumn<Cuenta, Number> colIdCliente = new TableColumn<Cuenta, Number>("ID");
		colIdCliente.setCellValueFactory(cuenta -> new SimpleIntegerProperty(cuenta.getValue().getCliente().getId()));
		TableColumn<Cuenta, String> colNombre = new TableColumn<Cuenta, String>("Nombre");
		colNombre.setCellValueFactory(cuenta -> new SimpleStringProperty(cuenta.getValue().getCliente().getNombre()));
		TableColumn<Cuenta, String> colTipo = new TableColumn<Cuenta, String>("Tipo");
		colTipo.setCellValueFactory(cuenta -> {
			if(cuenta.getValue() instanceof CuentaCajaAhorro) {
				return new SimpleStringProperty("Caja de Ahorro");
			}
			
			return new SimpleStringProperty("Cuenta Corriente");
		});
		TableColumn<Cuenta, Number> colSaldo = new TableColumn<Cuenta, Number>("Saldo");
		colSaldo.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getSaldo()));
		tabla.getColumns().addAll(colNumCuenta, colIdCliente, colNombre, colTipo, colSaldo);
		
		Button botonCrearCuenta = new Button("Crear Cuenta");
		Button botonBuscarCuenta = new Button("BuscarCuenta");
		Button botonDepositar = new Button("Depositar");
		Button botonRetirar = new Button("Retirar");
		Button botonRegresar = new Button("Regresar");
		HBox vBoxBotones = new HBox(50, botonCrearCuenta, botonBuscarCuenta, botonDepositar, botonRetirar, botonRegresar);
		VBox layout = new VBox(20, tabla, idInput, numCuenta, tipoCuenta, maxMovimientos, montoInput, vBoxBotones);
		layout.setPadding(new Insets(20));
		Scene escenaGestionCuentas = new Scene(layout, 800, 500);
		
		stage.setTitle("Sistema Bancario - Gestion de Cuentas");
		stage.setScene(escenaGestionCuentas);
		stage.show();
		
		new GestionCuentasController(this, botonCrearCuenta, botonBuscarCuenta, botonDepositar, botonRetirar,botonRegresar);
	}
	
	public TableView<Cuenta> getTabla(){
		return tabla;
	}
	
	public ObservableList<Cuenta> getCuentas(){
		return cuentas;
	}
	
	public TextField getIdInput() {
		return idInput;
	}
	
	public TextField getNumCuentaInput() {
		return numCuenta;
	}
	
	public TextField getMaxMovimientosInput() {
		return maxMovimientos;
	}
	
	public TextField getMontoInput() {
		return montoInput;
	}
	
	public ComboBox<String> getTipoCuenta(){
		return tipoCuenta;
	}
	
	public Stage getStage() {
		return stageOriginal;
	}
	
	public Banco getBanco() {
		return bancoOriginal;
	}
}
