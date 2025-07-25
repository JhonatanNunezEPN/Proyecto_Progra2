package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

import java.util.List;

public class CuentaCorriente extends Cuenta {
	//Constructor
	public CuentaCorriente(int numero, Cliente cliente) {
		super(numero, cliente);
	}

	@Override
	public boolean checkCuenta() {
		return true;
	}
}
