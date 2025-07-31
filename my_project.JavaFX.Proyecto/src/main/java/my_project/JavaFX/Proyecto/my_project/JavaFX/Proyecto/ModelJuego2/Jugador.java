package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.ModelJuego2;

public class Jugador {
	//Atributos
    private String nombre;
    private FichaColor color;
    
    //Constructor
    public Jugador(String nombre, FichaColor color) {
        this.nombre = nombre;
        this.color = color;
    }
    
    //Getters
    public String getNombre() {
        return nombre;
    }

    public FichaColor getColor() {
        return color;
    }
}
