package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleStringProperty;

public class Cliente {
	//Atributos
	private int id;
	private SimpleStringProperty nombre;
	private String telefono;
	private List<Cuenta> cuentas;
	
	//Constructor
	public Cliente(int id, String nombre, String telefono) {
		super();
		this.id = id;
		this.nombre = new SimpleStringProperty(nombre);
		this.telefono = telefono;
		this.cuentas = new ArrayList<Cuenta>();
	}

	//Encapsulamiento
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	//Metodos
	public void agregarCuenta(Cuenta cuentaNueva) {
		cuentas.add(cuentaNueva);
	}
	
	public double deposito(double monto, int numCuenta) {
		Cuenta cuentaEncontrar = cuentas.stream().filter(c -> c.getNumero() == numCuenta).findFirst().orElse(null);
		if(cuentaEncontrar == null) {
			throw new RuntimeException("Cuenta no encontrada");
		}
		
		
		
		return cuentaEncontrar.deposito(monto, this);
	}
	
	public double retiro(double monto, Cuenta cuenta) {
		if(!cuentas.contains(cuenta)) {
			throw new RuntimeException("Cuenta no encontrada");
		}
		return cuenta.retiro(monto, this);
	}
}
