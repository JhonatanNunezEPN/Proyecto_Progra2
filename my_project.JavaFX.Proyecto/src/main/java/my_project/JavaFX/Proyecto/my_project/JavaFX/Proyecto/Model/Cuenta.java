package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

import java.util.List;

import javafx.beans.property.*;

public abstract class Cuenta {
	//Atributos
	private SimpleIntegerProperty numero;
	private SimpleDoubleProperty saldo;
	private Cliente cliente;
	private List<Transaccion> transacciones;
	
	//Constructor
	public Cuenta(int numero, double saldo, Cliente cliente, List<Transaccion> transacciones) {
		super();
		this.numero = new SimpleIntegerProperty(numero);
		this.saldo = new SimpleDoubleProperty(saldo);
		this.cliente = cliente;
		this.transacciones = transacciones;
	}

	public int getNumero() {
		return numero.get();
	}

	public void setNumero(int numero) {
		this.numero.set(numero);;
	}

	public double getSaldo() {
		return saldo.get();
	}

	public void setSaldo(double saldo) {
		this.saldo.set(saldo);;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}
	
	//Metodos
	public double deposito(double monto, Cliente cliente) {
		if(!this.checkCuenta()) {	//Verificamos las restricciones de la cuenta
			throw new RuntimeException("No se puede realizar el retiro.");
		}
		
		if(monto < 0) {		//Verificamos que el saldo sea suficiente
			throw new RuntimeException("Monto invalido");
		}
		
		this.setSaldo(this.getSaldo() + monto);	//Agregamos el monto
		
		Transaccion transaccionNueva = new Transaccion(TipoTransaccion.DEPOSITO, monto,
				Hora.getInstancia().today(), this, cliente);	//Creamos una transaccion
		
		transacciones.add(transaccionNueva);	//Agregamos la transaccion a la lista
		return this.getSaldo();
	}
	
	public double retiro(double monto, Cliente cliente) {
		if(!this.checkCuenta()) {	//Verificamos las restricciones de la cuenta
			throw new RuntimeException("No se puede realizar el retiro.");
		}
		
		if(monto > this.getSaldo()) {		//Verificamos que el saldo sea suficiente
			throw new RuntimeException("Saldo insuficiente");
		}
		
		this.setSaldo(this.getSaldo() - monto);		//Realizamos el retiro
		
		Transaccion transaccionNueva = new Transaccion(TipoTransaccion.RETIRO, monto,
				Hora.getInstancia().today(), this, cliente);	//Creamos una transaccion
		
		transacciones.add(transaccionNueva);	//Agregamos la transaccion a la lista
		return this.getSaldo();
	}
	
	public abstract boolean checkCuenta();
}
