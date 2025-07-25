package Proyecto.Grupo.Ejercicio1.model;

/**
 * Representa un proyecto de investigación, extendiendo la clase Proyecto.
 */
public class ProyectoInvestigacion extends Proyecto {
    /**
     * Construye un ProyectoInvestigacion con los atributos especificados.
     * @param nombre El nombre del proyecto.
     * @param descripcion La descripción del proyecto.
     * @param urlVideo La URL del video explicativo del proyecto.
     * @param responsable El investigador responsable del proyecto.
     */
    public ProyectoInvestigacion(String nombre, String descripcion, String urlVideo, Investigador responsable) {
        super(nombre, descripcion, urlVideo, responsable);
    }
}