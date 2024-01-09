/*
 * Por convención, el proyecto se encuentra dividido en 4 paquetes
 * Control: Incluye todas las clases que se necesiten para que el proyecto se relacione entre sí
 * Modelo: El modelo de negocio (de momento sin utilizar)
 * Vista: Interfaz gráfica del programa | Aquellas clases que inicien con "P" indicarán que se trata de una clase que extiende de JPanel
 * img: Imagenes del proyecto 

La paleta de colores del proyecto será la siguiente:
#EFEBE0 - White
#FB8DA0 - Pink
#FB6B90 - Hot Pink
#FB4570 - Fuchsia
 */
package Control;

import Vista.Carga;
import Vista.Menu;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class CRUDAra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicio del programa, hilo para llamar a la "pantalla de carga"
        try {
            Runnable ejecutable = new Runnable(){
                public void run (){
                    Carga bienvenida = new Carga();
                    bienvenida.setVisible(true);
                    try {
                        //Tiempo de duración del hilo
                        Thread.sleep(3 * 1000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    bienvenida.dispose();
                    //se crea un objeto de la primer ventana y se muestra
                    Menu ventana = new Menu();
                    ventana.setVisible(true);
                }
            };
            Thread tarea = new Thread(ejecutable);
            tarea.start();
        }catch(Exception e){
            //Excepcion en caso de que falle la creacion del hilo
            JOptionPane.showMessageDialog(null, "Algo falló", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
