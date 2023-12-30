
package com.empresa.gestionEmpleados.services.resources;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class LimpiarPantallaService {
    
    // Método para limpiar la pantalla de la consola. Utiliza Robot que nos permite simular el evento de presionar las teclas. En este caso simulamos apretar y soltar Control+L, lo que hace borrar la pantalla. En este caso he aplicado tambien un delay de 100 milisegundos para que de tiempo a que la interfaz gráfica se pueda imprimir en pantalla sin cortes.
    
    public static void limpiarPantalla(){
        try{
            Robot limpiar = new Robot();
            limpiar.keyPress(KeyEvent.VK_CONTROL);
            limpiar.keyPress(KeyEvent.VK_L);
            limpiar.keyRelease(KeyEvent.VK_CONTROL);
            limpiar.keyRelease(KeyEvent.VK_L);
            limpiar.delay(100);
            
        }  catch (AWTException e) {
            System.out.println("Error al limpiar la pantalla"+e.getMessage());
        }
    }
    
}
