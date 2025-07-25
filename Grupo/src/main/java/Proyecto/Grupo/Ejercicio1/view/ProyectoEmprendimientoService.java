package Proyecto.Grupo.Ejercicio1.view;

import Proyecto.Grupo.Ejercicio1.model.Investigador;
import Proyecto.Grupo.Ejercicio1.model.ProyectoEmprendimiento;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz IProyectoService para gestionar los proyectos de emprendimiento.
 * Almacena y administra la lista de proyectos, inicializándola con datos de ejemplo.
 */
public class ProyectoEmprendimientoService implements IProyectoService {
    private List<ProyectoEmprendimiento> proyectos;

    /**
     * Constructor que inicializa la lista de proyectos con datos de ejemplo.
     * Crea una lista vacía y añade tres proyectos ficticios para pruebas.
     */
    public ProyectoEmprendimientoService() {
        proyectos = new ArrayList<>();
        // Inicializa la lista con proyectos de ejemplo compatibles con el modelo.
        proyectos.add(new ProyectoEmprendimiento("Energía Solar", "Paneles solares innovadores", "http://solar.com",
            new Investigador("Ana López"), 10000.0));
        proyectos.add(new ProyectoEmprendimiento("Agua Limpia", "Filtros de agua portátiles", "http://water.com",
            new Investigador("Carlos Ruiz"), 5000.0));
        proyectos.add(new ProyectoEmprendimiento("EdTech", "Plataforma educativa", "http://edtech.com",
            new Investigador("María Gómez"), 15000.0));
    }

    /**
     * Añade un nuevo proyecto a la lista de proyectos.
     * @param proyecto El proyecto de emprendimiento a añadir.
     */
    @Override
    public void addProyecto(ProyectoEmprendimiento proyecto) {
        proyectos.add(proyecto);
    }

    /**
     * Obtiene la lista completa de proyectos almacenados.
     * @return Una lista de objetos ProyectoEmprendimiento.
     */
    @Override
    public List<ProyectoEmprendimiento> getProyectos() {
        return new ArrayList<>(proyectos); // Devuelve una copia para evitar modificaciones externas.
    }
}
