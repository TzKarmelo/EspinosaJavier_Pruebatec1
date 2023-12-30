package com.empresa.gestionEmpleados.services.crud;

import com.empresa.gestionEmpleados.models.Empleado;
import com.empresa.gestionEmpleados.persistence.ControladoraPersistencia;
import static com.empresa.gestionEmpleados.services.EmpleadoService.GestionEmpleado;
import static com.empresa.gestionEmpleados.services.resources.LimpiarPantallaService.limpiarPantalla;
import java.util.List;
import java.util.Scanner;

public class BuscarEmpleados {

    public static void BuscarEmpleado() {
        
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();

        Scanner sc = new Scanner(System.in);

        limpiarPantalla();

        System.out.println("\n\n");
        System.out.println("\t\t\t****************************************");
        System.out.println("\t\t\t*                                      *");
        System.out.println("\t\t\t*           Buscar Empleado            *");
        System.out.println("\t\t\t*                                      *");
        System.out.println("\t\t\t****************************************");

        boolean validacion = false;
        
        do {                        
            System.out.println("\n1. Buscar por Id       2. Buscar por cargo       3. Menú Principal      4. Salir");
            
            System.out.print("\nOpción a escoger: ");
            
            if (!sc.hasNextInt()) {
                System.out.println("\nNo ha ingresado un número válido. Por favor, ingrese un número.");
                sc.next();
                continue;
            }
            
            int opcionBuscar = sc.nextInt();
            
            switch (opcionBuscar) {
                case 1:
                    System.out.print("\nQué empleado desea buscar (ID): ");
                    
                    long id = sc.nextInt();
                    // Buscar empleado por id
                    Empleado empleado = controlPersis.getEmpleado(id);
                    
                    if (empleado != null) {
                        
                        System.out.println("\n" + empleado);
                                                
                    } else {
                        System.out.println("\nEmpleado no encontrado.");
                    }
                    break;
                    
                case 2:
                    System.out.print("\nQué empleado desea buscar (cargo): ");
                    String cargo = sc.next();
                    // Buscar empleado por cargo
                    List<Empleado> listaEmpleados = controlPersis.getEmpleado(cargo);
                    // Comprobar si existe el cargo
                    if (!listaEmpleados.isEmpty()) {
                        for (Empleado listaEmpleado : listaEmpleados) {
                            System.out.println("\n" + listaEmpleado);
                        }
                        break;
                    } else {
                        System.out.println("\nEl cargo no existe.");
                        break;
                    }
                    
                case 3:
                    // Salir menu principal
                    validacion=true;
                    GestionEmpleado();
                    break;
                    
                case 4:
                    // Salir de la aplicacion
                    System.out.println("\nAplicación finalizada.\n");
                    validacion=true;
                    break;
                    
                default:
                    System.out.println("\nOpción no válida. Ingrese otra opción...");
            }
            
        } while (!validacion);

    }

}