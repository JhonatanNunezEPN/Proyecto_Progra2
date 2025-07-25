package Proyecto.Grupo.Ejercicio1.view;

import Proyecto.Grupo.Ejercicio1.model.ProyectoEmprendimiento;
import java.util.List;

/**
 * Interfaz que define los métodos para gestionar proyectos de emprendimiento.
 * Sirve como contrato para cualquier clase que gestione proyectos, asegurando que implemente estas funcionalidades.
 */
public interface IProyectoService {
    /**
     * Añade un nuevo proyecto a la lista de proyectos.
     * @param proyecto El proyecto de emprendimiento a añadir.
     */
    void addProyecto(ProyectoEmprendimiento proyecto);

    /**
     * Obtiene la lista completa de proyectos almacenados.
     * @return Una lista de objetos ProyectoEmprendimiento.
     */
    List<ProyectoEmprendimiento> getProyectos();
}
