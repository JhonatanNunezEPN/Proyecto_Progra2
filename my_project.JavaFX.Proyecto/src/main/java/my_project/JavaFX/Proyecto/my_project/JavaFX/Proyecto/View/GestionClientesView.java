package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.View;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Banco;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Cliente;
import my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model.Cuenta;

public class GestionClientesView {
	//Atributos
	private TableView<Cliente> tabla;
	private ObservableList<Cliente> clientes;
	private TextField idInput;
	private TextField nombreInput;
	private TextField numTelefonoInput;
	private Stage stageOriginal;
	private Banco bancoOriginal;
	
	public GestionClientesView(Stage stage, Banco banco) {
		stageOriginal = stage;
		bancoOriginal = banco;
		tabla = new TableView<Cliente>();
		clientes = FXCollections.observableArrayList(banco.getClientes());
		idInput = new TextField();
		idInput.setPromptText("ID");
		nombreInput = new TextField();
		nombreInput.setPromptText("Nombre");
		numTelefonoInput = new TextField();
		numTelefonoInput.setPromptText("Numero de Telefono");
		
		TableColumn<Cliente, Number> colIdCliente = new TableColumn<Cliente, Number>("ID");
		colIdCliente.setCellValueFactory(cliente -> new SimpleIntegerProperty(cliente.getValue().getId()));
		TableColumn<Cliente, String> colNombre = new TableColumn<Cliente, String>("Nombre");
		colNombre.setCellValueFactory(cliente -> new SimpleStringProperty(cliente.getValue().getNombre()));
		TableColumn<Cliente, String> colTelefono = new TableColumn<Cliente, String>("Telefono");
		colTelefono.setCellValueFactory(cliente -> new SimpleStringProperty(cliente.getValue().getTelefono()));
		TableColumn<Cliente, Number> colNumCuentas = new TableColumn<Cliente, Number>("Numero de Cuentas");
		colNumCuentas.setCellValueFactory(cliente -> new SimpleIntegerProperty(cliente.getValue().getCuentas().size()));
		tabla.getColumns().addAll(colIdCliente, colNombre, colTelefono, colNumCuentas);
		
		Button botonAgregarCliente = new Button("Agregar Cliente");
		Button botonBuscarCliente = new Button("Buscar Cliente");
		Button botonRegresar = new Button("Regresar");
		HBox vBoxBotones = new HBox(50, botonAgregarCliente, botonBuscarCliente, botonRegresar);
		VBox layout = new VBox(20, tabla, idInput, nombreInput, numTelefonoInput, vBoxBotones);
		layout.setPadding(new Insets(20));
		Scene escenaGestionClientes = new Scene(layout, 800, 500);
		
		stage.setTitle("Sistema Bancario - Gestion de Clientes");
		stage.setScene(escenaGestionClientes);
		stage.show();
		
		new GestionClientesController(this, botonAgregarCliente, botonBuscarCliente, botonRegresar);
	}

	public TableView<Cliente> getTabla(){
		return tabla;
	}
	
	public ObservableList<Cliente> getClientes(){
		return clientes;
	}
	
	public TextField getIdInput() {
		return idInput;
	}
	
	public TextField getNombreInput() {
		return nombreInput;
	}
	
	public TextField getNumTelefonoInput() {
		return numTelefonoInput;
	}
	
	public Stage getStage() {
		return stageOriginal;
	}
	
	public Banco getBanco() {
		return bancoOriginal;
	}
}
