package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

import java.util.List;

public class CuentaCorriente extends Cuenta {
	//Constructor
	public CuentaCorriente(int numero, double saldo, Cliente cliente, List<Transaccion> transacciones) {
		super(numero, saldo, cliente, transacciones);
	}

	@Override
	public boolean checkCuenta() {
		return true;
	}
}
