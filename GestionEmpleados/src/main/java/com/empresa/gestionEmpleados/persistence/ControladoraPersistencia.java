package com.empresa.gestionEmpleados.persistence;

import com.empresa.gestionEmpleados.models.Empleado;
import com.empresa.gestionEmpleados.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    
    // Metodo para crear empleados.
    
    public void crearEmpleado(Empleado emp) {
        empleJPA.create(emp);
    }
    
    // Metodo creado para borrar al empleado.
    
    public void borrarEmpleado(Long id) {
        try {
            empleJPA.destroy(id);
        }catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Metodo creado para listar a los empleados.
    
    public List<Empleado> traerEmpleados () {
        return empleJPA.findEmpleadoEntities();
    }
    
    // Metodo creado para modificar al empleado.
    
    public void modificarEmpleado(Empleado emp) {
        try {
            empleJPA.edit(emp);
        } catch (Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Metodo creado para buscar por id.
    
    public Empleado getEmpleado(Long id) {
        
        return empleJPA.findEmpleado(id);
    }
    
    // Metodo creado para buscar por cargo.
    
    public List<Empleado> getEmpleado(String cargo) {
        
        return empleJPA.findEmpleadoByCargo(cargo);
    }
        
}