/**
 * 
 */
package ejecutar;

import vista.VentanaPrincipal;
import modelo.TablasDatos;

/**
 * @author Guillermo Rodriguez Pardo
 *
 */
public class Ejecucion {

   /**
    * 
    */
   public Ejecucion() {
		// TODO Auto-generated constructor stub
   }

   /**
    * @param args
    */
   public static void main(String[] args) {

      TablasDatos pruebaTablas = new TablasDatos();
	   
      pruebaTablas.cargarBBDD("playas.csv");
      
      pruebaTablas.mostrarBBDD();
      
      pruebaTablas.eliminarRegistrosVaciosBBDD(2);
      
      pruebaTablas.mostrarBBDD();
      
      VentanaPrincipal pruebaVentana = new VentanaPrincipal ();
   }
}
