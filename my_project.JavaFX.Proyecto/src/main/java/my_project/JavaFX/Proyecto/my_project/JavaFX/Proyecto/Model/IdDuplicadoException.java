package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

public class IdDuplicadoException extends Exception{
	private int id;

	public IdDuplicadoException(int id) {
		super("El id '" + id + "'ya esta en uso");
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "IdDuplicadoException []: El id '" + id + "' se encuentra duplicado";
	}
}
