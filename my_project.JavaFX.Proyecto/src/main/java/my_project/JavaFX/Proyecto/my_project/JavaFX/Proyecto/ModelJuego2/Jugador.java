package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.ModelJuego2;

public class Jugador {
    private String nombre;
    private FichaColor color;

    public Jugador(String nombre, FichaColor color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public FichaColor getColor() {
        return color;
    }
}
