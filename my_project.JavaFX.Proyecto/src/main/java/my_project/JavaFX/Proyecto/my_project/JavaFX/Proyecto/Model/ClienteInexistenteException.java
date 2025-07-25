package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

public class ClienteInexistenteException extends Exception{
	private int id;
	
	public ClienteInexistenteException(int id) {
		super("El cliente con la id '" + id + "'no existe");
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "ClienteInexistenteException []: El cliente con la id '" + id + "' no se ha creado";
	}
}
