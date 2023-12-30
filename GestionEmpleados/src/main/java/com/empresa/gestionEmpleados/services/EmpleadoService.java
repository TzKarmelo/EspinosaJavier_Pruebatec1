
package com.empresa.gestionEmpleados.services;

import static com.empresa.gestionEmpleados.services.resources.LimpiarPantallaService.limpiarPantalla;
import static com.empresa.gestionEmpleados.services.crud.BorrarEmpleados.BorrarEmpleado;
import static com.empresa.gestionEmpleados.services.crud.BuscarEmpleados.BuscarEmpleado;
import static com.empresa.gestionEmpleados.services.crud.CrearEmpleados.CrearEmpleado;
import static com.empresa.gestionEmpleados.services.crud.ListarEmpleados.ListarEmpleado;
import static com.empresa.gestionEmpleados.services.crud.ModificarEmpleados.ModificarEmpleado;
import java.util.Scanner;

public class EmpleadoService {
    
    public static void GestionEmpleado() {
        
        limpiarPantalla();
       
        Scanner sc = new Scanner(System.in);
        
        // Menu principal de la aplicación
        
        System.out.println("\n\n");
        System.out.println("****************************************");
        System.out.println("*                                      *");
        System.out.println("*          Gestión Empleados           *");
        System.out.println("*                                      *");
        System.out.println("****************************************");
        System.out.println("*                                      *");
        System.out.println("*         1. Crear empleados           *");
        System.out.println("*         2. Listar empleados          *");
        System.out.println("*         3. Borrar empleados          *");
        System.out.println("*         4. Modificar empleados       *");
        System.out.println("*         5. Buscar empleados          *");
        System.out.println("*         9. Salir                     *");
        System.out.println("*                                      *");
        System.out.println("****************************************");
        
        boolean validacion = false;
        
        do {            
            System.out.print("\nIngrese la opción deseada: ");
            // Comprueba si es un numero la opcion igresada
            if (!sc.hasNextInt()) {
                System.out.println("\nNo ha ingresado un número válido. Por favor, ingrese un número.");
                sc.next(); 
                continue;
            }
            
            int opcion = sc.nextInt();
            // Acceso a las opciones del menu
            switch (opcion) {
                case 1 -> {
                    CrearEmpleado();
                    validacion=true;
                    break;
                }
                
                case 2 -> {
                    ListarEmpleado();
                    validacion=true;
                    break;
                }
                
                case 3 -> {
                    BorrarEmpleado();
                    validacion=true;
                    break;
                }

                case 4 -> {
                    ModificarEmpleado();
                    validacion=true;
                    break;
                }
                case 5 -> {
                    BuscarEmpleado();
                    validacion=true;
                    break;
                }
                case 9 -> {
                    System.out.println("\nAplicación finalizada.\n");
                    validacion=true;
                    break;
                }
                
                default -> System.out.println("\nOpción inválida. Por favor, elige una opción válida.");            
            }
        } while (!validacion);
        
        sc.close(); // Cierre del Scanner
        
    }
    
}