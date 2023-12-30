package com.empresa.gestionEmpleados.services.crud;

import com.empresa.gestionEmpleados.models.Empleado;
import com.empresa.gestionEmpleados.persistence.ControladoraPersistencia;
import static com.empresa.gestionEmpleados.services.EmpleadoService.GestionEmpleado;
import static com.empresa.gestionEmpleados.services.resources.LimpiarPantallaService.limpiarPantalla;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class ModificarEmpleados {

    public static void ModificarEmpleado() {

        ControladoraPersistencia controlPersis = new ControladoraPersistencia();

        Scanner sc = new Scanner(System.in);

        limpiarPantalla();

        System.out.println("\n\n");
        System.out.println("\t****************************************");
        System.out.println("\t*                                      *");
        System.out.println("\t*         Modificar Empleado           *");
        System.out.println("\t*                                      *");
        System.out.println("\t****************************************");

        boolean validacion = false;

        do {
            System.out.println("\n1. Modificar Usuario      2. Menú Principal     3. Salir");

            System.out.print("\nOpción a escoger: ");

            if (!sc.hasNextInt()) {
                System.out.println("\nNo ha ingresado un número válido. Por favor, ingrese un número.");
                sc.next();
                continue;
            }

            int opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("\nQué empleado desea modificar (ID): ");

                    if (!sc.hasNextInt()) {
                        System.out.println("\nNo ha ingresado un número válido. Por favor, ingrese un número.");
                        sc.next();
                        continue;
                    }

                    long id = sc.nextInt();
                    // Buscar empleado por Id
                    Empleado empleado = controlPersis.getEmpleado(id);

                    System.out.println("\n" + empleado);

                    System.out.println("\n1. Nombre     2. Apellido     3. Cargo     4. Salario     5.Fecha de Inicio     6. Volver     7. Salir");

                    System.out.print("\nOpción a modificar: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("\nNo ha ingresado un número válido. Por favor, ingrese un número.");
                        sc.next();
                        continue;
                    }

                    int opcionModificar = sc.nextInt();

                    switch (opcionModificar) {
                        // Modificar nombre
                        case 1:
                            System.out.print("\nCon que nombre modifica: ");
                            String nombre = sc.next();
                            System.out.print("\nCambiar nombre " + empleado.getNombre() + " a " + nombre + " (s/n): ");
                            String validarNombre = sc.next().toLowerCase();
                            if ("s".equals(validarNombre)) {
                                empleado.setNombre(nombre);
                                controlPersis.modificarEmpleado(empleado);
                                System.out.println("\nNombre cambiado: " + empleado);
                            } else {
                                System.out.println("\nModificación cancelada.");
                                ModificarEmpleado();
                            }
                            break;
                        // Modificar apellido
                        case 2:
                            System.out.print("\nCon que apellido modifica: ");
                            String apellido = sc.next();
                            System.out.print("\nCambiar apellido " + empleado.getApellido() + " a " + apellido + " (s/n): ");
                            String validarApellido = sc.next().toLowerCase();
                            if ("s".equals(validarApellido)) {
                                empleado.setApellido(apellido);
                                controlPersis.modificarEmpleado(empleado);
                                System.out.println("\nApellido cambiado: " + empleado);
                            } else {
                                System.out.println("\nModificación cancelada.");
                                ModificarEmpleado();
                            }
                            break;
                        // Modificar cargo
                        case 3:
                            System.out.print("\nCon que cargo modifica: ");
                            String cargo = sc.next();
                            System.out.print("\nCambiar cargo " + empleado.getCargo() + " a " + cargo + " (s/n): ");
                            String validarCargo = sc.next().toLowerCase();
                            if ("s".equals(validarCargo)) {
                                empleado.setCargo(cargo);
                                controlPersis.modificarEmpleado(empleado);
                                System.out.println("\nCargo cambiado: " + empleado);
                            } else {
                                System.out.println("\nModificación cancelada.");
                                ModificarEmpleado();
                            }
                            break;
                        // Modificar salario  
                        case 4:
                            System.out.print("\nCon que salario modifica: ");
                            int salario = sc.nextInt();
                            System.out.print("\nCambiar salario " + empleado.getSalario() + " a " + salario + " (s/n): ");
                            String validarSalario = sc.next().toLowerCase();
                            if ("s".equals(validarSalario)) {
                                empleado.setSalario(salario);
                                controlPersis.modificarEmpleado(empleado);
                                System.out.println("\nSalario cambiado: " + empleado);
                            } else {
                                System.out.println("\nModificación cancelada.");
                                ModificarEmpleado();
                            }
                            break;
                        // Modificar Fecha de inicio
                        case 5:
                            System.out.println("\nCon que fecha modifica: ");
                            System.out.println("\n\tFecha Inicio ->");
                            System.out.print("\n\t\tDia: ");
                            int dia = sc.nextInt();
                            System.out.print("\t\tMes: ");
                            int mes = sc.nextInt();
                            System.out.print("\t\tAño: ");
                            int anio = sc.nextInt();

                            LocalDate fechaInicio = null;
                            // Validacion fecha
                            if (anio > 0 && mes >= 1 && mes <= 12) {
                                int maxDiasEnMes = YearMonth.of(anio, mes).lengthOfMonth();
                                if (dia >= 1 && dia <= maxDiasEnMes) {
                                    fechaInicio = LocalDate.of(anio, mes, dia);
                                    System.out.print("\nCambiar fecha de inicio " + empleado.getFecha_inicio() + " a " + fechaInicio + " (s/n): ");
                                    String validarFecha = sc.next().toLowerCase();
                                    if ("s".equals(validarFecha)) {
                                        empleado.setFecha_inicio(fechaInicio);
                                        controlPersis.modificarEmpleado(empleado);
                                        System.out.println("\nFecha cambiada: " + fechaInicio);
                                    } else {
                                        System.out.println("\nModificación cancelada.");
                                        ModificarEmpleado();
                                    }
                                } else {
                                    System.out.println("\nEl día ingresado no es válido para el mes y año proporcionados. Ingrese una fecha válida.");
                                }
                            } else {
                                System.out.println("\nLa fecha ingresada no es válida. Ingrese una fecha válida.");
                            }

                            break;

                        case 6:
                            validacion = true;
                            GestionEmpleado();
                            break;

                        case 7:
                            System.out.println("\nAplicación finalizada.\n");
                            validacion = true;
                            break;

                        default:
                            System.out.println("\nOpción no válida. Ingrese otra opción...");

                    }
                    break;
                    
                case 2:                    
                    validacion=true;
                    GestionEmpleado();
                    break;
                    
                case 3:
                    System.out.println("\nAplicación finalizada.\n");
                    validacion=true;
                    break;
            }

        } while (!validacion);

    }

}
