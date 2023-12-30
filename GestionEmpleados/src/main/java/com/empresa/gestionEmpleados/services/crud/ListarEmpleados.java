package com.empresa.gestionEmpleados.services.crud;

import com.empresa.gestionEmpleados.models.Empleado;
import com.empresa.gestionEmpleados.persistence.ControladoraPersistencia;
import static com.empresa.gestionEmpleados.services.EmpleadoService.GestionEmpleado;
import static com.empresa.gestionEmpleados.services.resources.LimpiarPantallaService.limpiarPantalla;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ListarEmpleados {

    public static void ListarEmpleado() {

        ControladoraPersistencia controlPersis = new ControladoraPersistencia();

        Scanner sc = new Scanner(System.in);

        limpiarPantalla();

        System.out.println("\n\n");
        System.out.println("\t\t\t\t\t*********************************");
        System.out.println("\t\t\t\t\t*                               *");
        System.out.println("\t\t\t\t\t*      Listado de Empleados     *");
        System.out.println("\t\t\t\t\t*                               *");
        System.out.println("\t\t\t\t\t*********************************\n");
        // Obtiene la lista de empleados desde la capa de persistencia
        List<Empleado> listaEmpleados = controlPersis.traerEmpleados();
        // Ordena la lista de empleados por ID
        Collections.sort(listaEmpleados, Comparator.comparingLong(Empleado::getId));
        // Imprime cada empleado en la lista
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado.toString() + "\n");
        }

        boolean validacion = false;

        do {
            System.out.println("\n1. Menú Principal    2. Salir");
            System.out.print("\n\tElige opción: ");
            // Verifica si la entrada es un número
            if (!sc.hasNextInt()) {
                System.out.println("\nNo ha ingresado un número válido. Por favor, ingrese un número.");
                sc.next(); 
                continue;
            }

            int opcionListar = sc.nextInt();
            // Menu salida...
            switch (opcionListar) {
                case 1 -> {
                        GestionEmpleado();
                        validacion=true;
                        break;
                    }

                case 2 -> {
                    System.out.println("\nAplicación finalizada.\n");
                    validacion = true;
                    break;
                }

                default -> System.out.println("\nOpción inválida. Por favor, elige una opción válida.");
            }

        } while (!validacion);

        sc.close();

    }

}
