package Proyecto.Grupo.Ejercicio1.model;

/**
 * Representa un investigador, extendiendo la clase Usuario con atributos adicionales.
 */
public class Investigador extends Usuario {
    private String paginaWeb;
    private String areaExperiencia;
    
    /**
     * Construye un Investigador con el nombre, sitio web y área de experiencia especificados.
     * @param nombre El nombre del investigador.
     * @param paginaWeb La URL del sitio web del investigador.
     * @param areaExperiencia El área de experiencia del investigador.
     */
    public Investigador(String nombre, String paginaWeb, String areaExperiencia) {
        super(nombre);
        this.paginaWeb = paginaWeb;
        this.areaExperiencia = areaExperiencia;
    }
    
    /**
     * Obtiene la URL del sitio web del investigador.
     * @return La URL del sitio web.
     */
    public String getPaginaWeb() {
        return paginaWeb;
    }
    
    /**
     * Establece la URL del sitio web del investigador.
     * @param paginaWeb La nueva URL del sitio web.
     */
    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
    
    /**
     * Obtiene el área de experiencia del investigador.
     * @return El área de experiencia.
     */
    public String getAreaExperiencia() {
        return areaExperiencia;
    }
    
    /**
     * Establece el área de experiencia del investigador.
     * @param areaExperiencia La nueva área de experiencia.
     */
    public void setAreaExperiencia(String areaExperiencia) {
        this.areaExperiencia = areaExperiencia;
    }
}