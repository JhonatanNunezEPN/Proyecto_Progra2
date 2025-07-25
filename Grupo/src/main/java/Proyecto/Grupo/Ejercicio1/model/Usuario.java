package Proyecto.Grupo.Ejercicio1.model;

/**
 * Clase abstracta que representa un usuario genérico con un nombre.
 */
public abstract class Usuario {
    private String nombre;
    
    /**
     * Construye un Usuario con el nombre especificado.
     * @param nombre El nombre del usuario.
     */
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del usuario.
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}