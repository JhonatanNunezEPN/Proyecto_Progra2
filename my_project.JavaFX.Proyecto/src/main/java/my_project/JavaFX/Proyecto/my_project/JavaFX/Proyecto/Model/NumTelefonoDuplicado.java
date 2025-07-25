package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

public class NumTelefonoDuplicado extends Exception {
	private String numTelefono;

	public NumTelefonoDuplicado(String numTelefono) {
		super("El numero de telefono '" + numTelefono + "'ya esta en uso");
		this.numTelefono = numTelefono;
	}

	public String getNumTelefono() {
		return numTelefono;
	}
	
	@Override
	public String toString() {
		return "NumTelefonoDuplicado []: El numero de telefono '" + numTelefono + "' se encuentra duplicado";
	}
}
