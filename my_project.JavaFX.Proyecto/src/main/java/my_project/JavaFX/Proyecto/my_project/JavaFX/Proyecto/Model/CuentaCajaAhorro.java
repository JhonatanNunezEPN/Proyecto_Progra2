package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

import java.util.List;

public class CuentaCajaAhorro extends Cuenta {
	//Atributos
	private int movAnuales;
	
	//Constructor
	public CuentaCajaAhorro(int numero, Cliente cliente, int movAnuales) {
		super(numero, cliente);
		this.movAnuales = movAnuales;
	}

	//Encapsulamiento
	public int getMovAnuales() {
		return movAnuales;
	}

	public void setMovAnuales(int movAnuales) {
		this.movAnuales = movAnuales;
	}

	@Override
	public boolean checkCuenta() {
		int yearActual = Hora.getInstancia().year(Hora.getInstancia().today());
		
		int cantMovActuales = (int) this.getTransacciones().stream().
				filter(transaccion -> Hora.getInstancia().year(transaccion.getFecha()) == yearActual).
				count();
		
		return cantMovActuales < movAnuales;
	}

}
