package Proyecto.Grupo.Ejercicio1.model;

/**
 * Representa un proyecto de emprendimiento con atributos de financiación, extendiendo la clase Proyecto.
 */
public class ProyectoEmprendimiento extends Proyecto {
    private double montoTotal;
    private double montoRecaudado;
    
    /**
     * Construye un ProyectoEmprendimiento con los atributos especificados.
     * @param nombre El nombre del proyecto.
     * @param descripcion La descripción del proyecto.
     * @param urlVideo La URL del video explicativo del proyecto.
     * @param responsable El investigador responsable del proyecto.
     * @param montoTotal La meta de financiación total del proyecto.
     */
    public ProyectoEmprendimiento(String nombre, String descripcion, String urlVideo, Investigador responsable, double montoTotal) {
        super(nombre, descripcion, urlVideo, responsable);
        this.montoTotal = montoTotal;
        this.montoRecaudado = 0.0;
    }
    
    /**
     * Verifica si el proyecto puede aceptar una donación del monto especificado.
     * @param monto El monto de la donación a verificar.
     * @return true si la donación no excede la meta de financiación total, false en caso contrario.
     */
    public boolean puedeRecibirDonacion(double monto) {
        return (montoRecaudado + monto) <= montoTotal;
    }
    
    /**
     * Registra una donación al proyecto.
     * @param monto El monto de la donación a añadir.
     */
    public void recibirDonacion(double monto) {
        montoRecaudado += monto;
    }
    
    /**
     * Obtiene la meta de financiación total.
     * @return La meta de financiación total.
     */
    public double getMontoTotal() {
        return montoTotal;
    }
    
    /**
     * Establece la meta de financiación total.
     * @param montoTotal La nueva meta de financiación total.
     */
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    /**
     * Obtiene el monto recaudado hasta el momento.
     * @return El monto recaudado.
     */
    public double getMontoRecaudado() {
        return montoRecaudado;
    }
    
    /**
     * Devuelve una representación en cadena del proyecto, incluyendo el nombre y los fondos restantes.
     * @return El nombre del proyecto y el monto de financiación restante.
     */
    @Override
    public String toString() {
        return getNombre() + " ($" + (montoTotal - montoRecaudado) + " restante)";
    }
}