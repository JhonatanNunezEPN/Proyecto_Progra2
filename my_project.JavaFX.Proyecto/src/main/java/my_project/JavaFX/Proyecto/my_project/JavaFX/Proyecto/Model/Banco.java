package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	//Atributos
	private List<Cliente> clientes;

	//Constructor
	public Banco() {
		clientes = new ArrayList<Cliente>();
	}

	//Encapsulamiento
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	//Metodos
	public void agregarCliente(Cliente clienteNuevo) {
		clientes.add(clienteNuevo);
	}
	
	public double deposito(double monto, int idCliente, int numCuenta) {
		Cliente clienteEncontrar = clientes.stream().filter(c -> c.getId() == idCliente).findFirst().orElse(null);
		if(clienteEncontrar == null) {
			throw new RuntimeException("Cliente no encontrado");
		}
		return clienteEncontrar.deposito(monto, numCuenta);
	}
	
	public double retiro(double monto, Cuenta cuenta, Cliente cliente) {
		if(!clientes.contains(cliente)) {
			throw new RuntimeException("Cliente no encontrado");
		}
		return cliente.retiro(monto, cuenta);
	}
}
