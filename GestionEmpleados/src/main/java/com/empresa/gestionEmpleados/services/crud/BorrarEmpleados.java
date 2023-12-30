package com.empresa.gestionEmpleados.services.crud;

import com.empresa.gestionEmpleados.models.Empleado;
import com.empresa.gestionEmpleados.persistence.ControladoraPersistencia;
import static com.empresa.gestionEmpleados.services.EmpleadoService.GestionEmpleado;
import static com.empresa.gestionEmpleados.services.resources.LimpiarPantallaService.limpiarPantalla;
import java.util.Scanner;

public class BorrarEmpleados {

    public static void BorrarEmpleado() {

        ControladoraPersistencia controlPersis = new ControladoraPersistencia();

        Scanner sc = new Scanner(System.in);

        limpiarPantalla();

        System.out.println("\n\n");
        System.out.println("\t****************************************");
        System.out.println("\t*                                      *");
        System.out.println("\t*           Borrar Empleado            *");
        System.out.println("\t*                                      *");
        System.out.println("\t****************************************");

        boolean validacion = false;

        do {
            System.out.println("\n1. Borrar Empleado      2. Menú Principal     3. Salir");

            System.out.print("\nOpción a escoger: ");

            if (!sc.hasNextInt()) {
                System.out.println("\nNo ha ingresado un número válido. Por favor, ingrese un número.");
                sc.next();
                continue;
            }

            int opcionBorrar = sc.nextInt();

            switch (opcionBorrar) {
                // Obtener el ID del empleado a eliminar
                case 1:
                    System.out.print("\nQué empleado desea eliminar (ID): ");

                    if (!sc.hasNextInt()) {
                        System.out.println("\nNo ha ingresado un número válido. Por favor, ingrese un número.");
                        sc.next();
                        continue;
                    }

                    long id = sc.nextInt();
                    // Buscar el empleado en la base de datos
                    Empleado empleado = controlPersis.getEmpleado(id);

                    if (empleado != null) {
                        System.out.println("\n" + empleado);
                        System.out.print("\nConfirmar eliminar (b -> borrar / c -> cancelar): ");
                        // ...
                        String opcionEliminar = sc.next().toLowerCase();

                        switch (opcionEliminar) {
                            case "b":
                                // Eliminar el empleado de la base de datos
                                controlPersis.borrarEmpleado(id);
                                System.out.println("\nUsuario Borrado.");
                                break;
                            case "c":
                                System.out.println("\nOperación cancelada.");
                                break;
                            default:
                                System.out.println("\nOpción no válida. Ingrese 'b' para borrar o 'c' para cancelar.");
                                break;
                        }
                    } else {
                        System.out.println("\nEmpleado no encontrado para el ID proporcionado.");
                        break;
                    }
                // Ir al menú principal
                case 2:
                    validacion = true;
                    GestionEmpleado();
                    break;
                // Salir
                case 3:
                    System.out.println("\nAplicación finalizada.\n");
                    validacion = true;
                    break;

                default:
                    System.out.println("\nOpción no válida. Ingrese otra opción...");
            }

        } while (!validacion);

        sc.close();

    }

}
