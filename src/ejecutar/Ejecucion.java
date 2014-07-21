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
	   
      pruebaTablas.cargarBBDD_A_Mezclar("restauracion.csv");
      
      
      
      //pruebaTablas.normalizarComillas ();
      
      pruebaTablas.mostrarBBDD_A_Mezclar();
      
      
      
      pruebaTablas.eliminarRegistrosVaciosBBDD_A_Mezclar(2);
      
      pruebaTablas.mostrarBBDD_A_Mezclar();
      
      pruebaTablas.separarCampoGEOJason(2);
      
      pruebaTablas.mostrarBBDD_A_Mezclar();
      
      pruebaTablas.guardarBBDD_A_Mezclar("restauracion2.csv");
      //pruebaTablas.mostrarBBDD_A_Mezclar();
      
      //VentanaPrincipal pruebaVentana = new VentanaPrincipal ();
   }
}
