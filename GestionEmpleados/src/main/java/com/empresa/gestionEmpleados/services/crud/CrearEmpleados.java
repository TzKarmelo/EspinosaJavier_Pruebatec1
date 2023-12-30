package com.empresa.gestionEmpleados.services.crud;

import com.empresa.gestionEmpleados.models.Empleado;
import com.empresa.gestionEmpleados.persistence.ControladoraPersistencia;
import static com.empresa.gestionEmpleados.services.EmpleadoService.GestionEmpleado;
import static com.empresa.gestionEmpleados.services.resources.LimpiarPantallaService.limpiarPantalla;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Scanner;

public class CrearEmpleados {

    public static void CrearEmpleado() {

        ControladoraPersistencia controlPersis = new ControladoraPersistencia();

        limpiarPantalla();

        Empleado empleado = new Empleado();

        Scanner sc = new Scanner(System.in);

        System.out.println("\n\n");
        System.out.println("\t****************************************");
        System.out.println("\t*                                      *");
        System.out.println("\t*            Crear Empleado            *");
        System.out.println("\t*                                      *");
        System.out.println("\t****************************************");

        boolean validacionMenu = false;

        do {
            System.out.println("\n1. Crear Empleado       2. Menú Principal      3. Salir");

            System.out.print("\nOpción a escoger: ");

            if (!sc.hasNextInt()) {
                System.out.println("\nNo ha ingresado un número válido. Por favor, ingrese un número.");
                sc.next();
                continue;
            }

            int opcionCrear = sc.nextInt();

            switch (opcionCrear) {
                case 1:
                    
                    // NOMBRE //////////////////////////////////

                    boolean validacionNombre = false;
                    // Validación y captura de nombre
                    do {
                        System.out.print("\n\tNombre: ");
                        String nombre = sc.next();

                        if (nombre.trim().isEmpty()) {
                            System.out.println("\nNo ha ingresado nada. Por favor, ingrese un nombre válido.");
                        } else {
                            if (!nombre.matches(".*\\d.*") && nombre.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
                                validacionNombre = true;
                            } else {
                                System.out.println("\nEl nombre contiene dígitos o caracteres especiales. Ingrese un nombre válido.");
                            }
                        }
                        
                        empleado.setNombre(nombre);

                    } while (!validacionNombre);

                    // APELLIDO //////////////////////////////////
                    
                    boolean validacionApellido = false;
                    // Validación y captura de apellido
                    do {
                        System.out.print("\n\tApellido: ");
                        String apellido = sc.nextLine();

                        if (apellido.trim().isEmpty()) {
                            System.out.println("\nNo ha ingresado nada. Por favor, ingrese un apellido válido.");
                        } else {
                            if (!apellido.matches(".*\\d.*") && apellido.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
                                validacionApellido = true;
                            } else {
                                System.out.println("\nEl apellido contiene dígitos o caracteres especiales. Ingrese un apellido válido.");
                            }
                        }

                        empleado.setApellido(apellido);

                    } while (!validacionApellido);

                    // CARGO //////////////////////////////////
                    
                    boolean validacionCargo = false;
                    // Validación y captura de cargo
                    do {
                        System.out.print("\n\tCargo: ");
                        String cargo = sc.nextLine();

                        if (cargo.trim().isEmpty()) {
                            System.out.println("\nNo ha ingresado nada. Por favor, ingrese un cargo válido.");
                        } else {
                            if (!cargo.matches(".*\\d.*") && cargo.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
                                validacionCargo = true;
                            } else {
                                System.out.println("\nEl cargo contiene dígitos o caracteres especiales. Ingrese un cargo válido.");
                            }
                        }

                        empleado.setCargo(cargo);

                    } while (!validacionCargo);

                    // SALARIO //////////////////////////////////
                    
                    boolean validacionSalario = false;
                    // Validación y captura de salario
                    int salario = 0;
                    do {
                        System.out.print("\n\tSalario: ");
                        String input = sc.nextLine();

                        if (input.isEmpty()) {
                            System.out.println("\nNo ha ingresado nada. Por favor, ingrese un salario válido.");
                        } else {
                            if (input.matches("[0-9]+")) {
                                salario = Integer.parseInt(input);
                                validacionSalario = true;
                            } else {
                                System.out.println("\nEl salario contiene caracteres no válidos. Ingrese un salario válido.");
                            }
                        }

                        empleado.setSalario(salario);

                    } while (!validacionSalario);

                    // FECHA_INICIO //////////////////////////////////
                    
                    boolean validacionFecha = false;

                    LocalDate fechaInicio = null;
                    // Validación y captura de fecha de inicio
                    do {
                        System.out.print("\n\tFecha Inicio ->\n");
                        System.out.print("\n\t\tDia: ");
                        int dia = sc.nextInt();
                        System.out.print("\t\tMes: ");
                        int mes = sc.nextInt();
                        System.out.print("\t\tAño: ");
                        int anio = sc.nextInt();

                        if (anio > 0 && mes >= 1 && mes <= 12) {
                            int maxDiasEnMes = YearMonth.of(anio, mes).lengthOfMonth();
                            if (dia >= 1 && dia <= maxDiasEnMes) {
                                fechaInicio = LocalDate.of(anio, mes, dia);
                                validacionFecha = true;
                            } else {
                                System.out.println("\nEl día ingresado no es válido para el mes y año proporcionados. Ingrese una fecha válida.");
                            }
                        } else {
                            System.out.println("\nLa fecha ingresada no es válida. Ingrese una fecha válida.");
                        }

                        empleado.setFecha_inicio(fechaInicio);

                    } while (!validacionFecha);

                    // CREACION EMPLEADO //////////////////////////////////
                    
                    List<Empleado> listaEmpleados = controlPersis.traerEmpleados();
                    boolean empleadoDuplicado = false;
                    // Verificación de duplicados
                    for (Empleado empleadoLista : listaEmpleados) {
                        if (empleadoLista.getNombre().equals(empleado.getNombre())
                                && empleadoLista.getApellido().equals(empleado.getApellido())
                                && empleadoLista.getCargo().equals(empleado.getCargo())
                                && empleadoLista.getSalario() == empleado.getSalario()
                                && empleadoLista.getFecha_inicio().equals(empleado.getFecha_inicio())) {

                            empleadoDuplicado = true;
                            System.out.println("\nEmpleado duplicado");
                            break;
                        }
                    }
                    // Si no es un duplicado, se agrega el empleado
                    if (!empleadoDuplicado) {
                        controlPersis.modificarEmpleado(empleado);
                        System.out.println("\nEmpleado creado.");
                    }

                    // MENU SALIDA ////////////////////////////////////////  
                    
                    boolean validacion = false;

                    do {
                        System.out.println("\n1. Añadir Otro    2. Menú Principal   3. Salir");
                        System.out.print("\n\tElige opción: ");

                        if (!sc.hasNextInt()) {
                            System.out.println("\nNo ha ingresado un número válido. Por favor, ingrese un número.");
                            sc.next();
                            continue;
                        }

                        int opcion = sc.nextInt();

                        switch (opcion) {
                            case 1 -> {
                                CrearEmpleado();
                                validacion = true;
                                break;
                            }

                            case 2 -> {
                                GestionEmpleado();
                                validacion = true;
                                break;
                            }

                            case 3 -> {
                                System.out.println("\nAplicación finalizada.\n");
                                validacion = true;
                                break;
                            }

                            default ->
                                System.out.println("\nOpción inválida. Por favor, elige una opción válida.");
                        }
                    } while (!validacion);
                    break;

                case 2:
                    GestionEmpleado();
                    validacionMenu = true;
                    break;

                case 3:
                    System.out.println("\nAplicación finalizada.\n");
                    validacionMenu = true;
                    break;

                default:
                    System.out.println("\nOpción inválida. Por favor, elige una opción válida.");
            }        
        } while (!validacionMenu); 
        sc.close();
    }
        
}