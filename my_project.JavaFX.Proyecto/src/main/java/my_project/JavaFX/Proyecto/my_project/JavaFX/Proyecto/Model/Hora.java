package my_project.JavaFX.Proyecto.my_project.JavaFX.Proyecto.Model;

import java.time.LocalDateTime;

public class Hora {
	//Atributos
    private static Hora instancia;

    //Constructor
    private Hora() {
    	
    }

    public static Hora getInstancia() {
        if (instancia == null) {
            instancia = new Hora();
        }
        return instancia;
    }

    //Metodos
    public LocalDateTime today() {
        return LocalDateTime.now();
    }

    public int year(LocalDateTime fecha) {
        return fecha.getYear();
    }
}

