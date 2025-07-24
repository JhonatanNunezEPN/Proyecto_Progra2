package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

import java.time.LocalDateTime;

public class Transaccion {
	//Atributos
	private TipoTransaccion tipo;
	private double monto;
	private LocalDateTime fecha;
	private Cuenta cuenta;
	private Cliente cliente;
	
	//Constructor
	public Transaccion(TipoTransaccion tipo, double monto, LocalDateTime fecha, Cuenta cuenta, Cliente cliente) {
		super();
		this.tipo = tipo;
		this.monto = monto;
		this.fecha = fecha;
		this.cuenta = cuenta;
		this.cliente = cliente;
	}
	
	public Transaccion(TipoTransaccion tipo, double monto, Cuenta cuenta, Cliente cliente) {
		this.tipo = tipo;
		this.monto = monto;
		this.cliente = cliente;
		this.cuenta = cuenta;
		fecha = Hora.getInstancia().today();
	}
	
	//Encapsulamiento
	public TipoTransaccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransaccion tipo) {
		this.tipo = tipo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
