package Proyecto.Grupo.Ejercicio1.model;

/**
 * Clase abstracta que representa un proyecto genérico con atributos y métodos comunes.
 */
public abstract class Proyecto {
    private String nombre;
    private String descripcion;
    private String urlVideo;
    private Investigador responsable;
    private Investigador[] asociados;
    
    /**
     * Construye un Proyecto con los atributos especificados.
     * @param nombre El nombre del proyecto.
     * @param descripcion La descripción del proyecto.
     * @param urlVideo La URL del video explicativo del proyecto.
     * @param responsable El investigador responsable del proyecto.
     */
    public Proyecto(String nombre, String descripcion, String urlVideo, Investigador responsable) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlVideo = urlVideo;
        this.responsable = responsable;
        this.asociados = new Investigador[4];
    }
    
    /**
     * Agrega un investigador asociado al proyecto.
     * @param investigador El investigador a añadir.
     * @return true si el investigador se añadió exitosamente, false si no hay espacio disponible.
     */
    public boolean agregarAsociado(Investigador investigador) {
        for (int i = 0; i < asociados.length; i++) {
            if (asociados[i] == null) {
                asociados[i] = investigador;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Obtiene el nombre del proyecto.
     * @return El nombre del proyecto.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del proyecto.
     * @param nombre El nuevo nombre del proyecto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la descripción del proyecto.
     * @return La descripción del proyecto.
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Establece la descripción del proyecto.
     * @param descripcion La nueva descripción del proyecto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Obtiene la URL del video explicativo del proyecto.
     * @return La URL del video.
     */
    public String getUrlVideo() {
        return urlVideo;
    }
    
    /**
     * Establece la URL del video explicativo del proyecto.
     * @param urlVideo La nueva URL del video.
     */
    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }
    
    /**
     * Obtiene el investigador responsable del proyecto.
     * @return El investigador responsable.
     */
    public Investigador getResponsable() {
        return responsable;
    }
    
    /**
     * Establece el investigador responsable del proyecto.
     * @param responsable El nuevo investigador responsable.
     */
    public void setResponsable(Investigador responsable) {
        this.responsable = responsable;
    }
    
    /**
     * Obtiene el arreglo de investigadores asociados.
     * @return El arreglo de investigadores asociados.
     */
    public Investigador[] getAsociados() {
        return asociados;
    }
}