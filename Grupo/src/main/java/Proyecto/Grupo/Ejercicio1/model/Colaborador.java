package Proyecto.Grupo.Ejercicio1.model;

/**
 * Representa un colaborador que puede realizar donaciones, extendiendo la clase Usuario.
 */
public class Colaborador extends Usuario {
    /**
     * Construye un Colaborador con el nombre especificado.
     * @param nombre El nombre del colaborador.
     */
    public Colaborador(String nombre) {
        super(nombre);
    }
    
    /**
     * Realiza una donación al proyecto especificado.
     * @param proyecto El proyecto al que se dona.
     * @param monto El monto de la donación.
     * @throws IllegalArgumentException Si la donación excede la meta de financiación del proyecto.
     */
    public void donar(ProyectoEmprendimiento proyecto, double monto) {
        if (proyecto.puedeRecibirDonacion(monto)) {
            proyecto.recibirDonacion(monto);
        } else {
            throw new IllegalArgumentException("La donación excede el monto necesario");
        }
    }
}