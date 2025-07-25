package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

public class NumCuentaDuplicadoException extends Exception {
	public int numCuenta;
	
	public NumCuentaDuplicadoException(int numCuenta) {
		super("El numero de cuenta '" + numCuenta + "' ya esta en uso");
		this.numCuenta = numCuenta;
	}
	
	public int getNumCuenta() {
		return numCuenta;
	}

	@Override
	public String toString() {
		return "NumCuentaDuplicadoException []: El numero de cuenta '" + numCuenta + "' se encuentra duplicado";
	}
}
