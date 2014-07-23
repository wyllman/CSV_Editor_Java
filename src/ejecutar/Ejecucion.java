/**
 * 
 */
package ejecutar;

import java.util.Vector;

import vista.VentanaPrincipal;
import modelo.TablasDatos;
import modelo.TablasDatos.TYPE_BBDD;

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
      
      pruebaTablas.cargarBBDD("Base-Total6.csv");
      pruebaTablas.mostrarBBDD();
      pruebaTablas.cargarBBDD_A_Mezclar("base-iass-4.csv");
      
      pruebaTablas.trasladarDatos();
      pruebaTablas.mostrarBBDD();
      pruebaTablas.guardarBBDD("Base-Total7.csv");
      //pruebaTablas.mostrarBBDD();
      
      
      
      /*pruebaTablas.mostrarBBDD_A_Mezclar();
      pruebaTablas.eliminarRegistrosVaciosBBDD_A_Mezclar (23);
      pruebaTablas.mostrarBBDD_A_Mezclar();
      pruebaTablas.guardarBBDD_A_Mezclar("base-restauracion6.csv");*/
      
      
      
      /*pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Restaurante\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Restaurante\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Bar\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Bar\"", 23, "84");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Cafetería\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Cafetería\"", 23, "83");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Cafetería-Restaurante\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Cafetería-Restaurante\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Pizzería\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Pizzería\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Vegetariano\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Vegetariano\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Marisquería\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Marisquería\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Zumería\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Zumería\"", 23, "84");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Gastronomía Canaria\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Gastronomía Canaria\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Cervecería\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Cervecería\"", 23, "84");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Churrasquería\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Churrasquería\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Churrería\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Churrería\"", 23, "83");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Self-Service\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Self-Service\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Guachinche\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Guachinche\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Bar-Cafetería\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Bar-Cafetería\"", 23, "83");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Mesón-Taberna\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Mesón-Taberna\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Arepera\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Arepera\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Tasca\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Tasca\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Hamburguesería\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Hamburguesería\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Autobar\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Autobar\"", 23, "84");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Pub\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Pub\"", 23, "84");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Asador-Parrilla\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Asador-Parrilla\"", 23, "82");
      
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Buffett\"", 22, "81");
      pruebaTablas.cambiarCampo(TYPE_BBDD.AUX, 23, "\"Buffett\"", 23, "82");
      
      pruebaTablas.mostrarBBDD_A_Mezclar();
      pruebaTablas.guardarBBDD_A_Mezclar("base-restauracion5.csv");*/
      
      
      
      /*pruebaTablas.mostrarBBDD_A_Mezclar();
      pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"Kiosko\"");
      pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"Dulcería-Pastelería\"");
      pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"Snack\"");
      pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"Heladería\"");
      pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"Sin Clasificar\"");
      //pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"VIOLENCIA SERVICIOS\"");
      //pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"MAYORES SERVICIOS\"");
      //pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"MAYORES RECURSOS\"");
      //pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"DISCAPACIDAD RECURSOS\"");
      //pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"DISCAPACIDAD SERVICIOS\"");
      //pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"ADMINISTRACION\"");
      //pruebaTablas.eliminarCampoTexto(TYPE_BBDD.AUX, 23, "\"CENTROEDUCATIVO\"");
      pruebaTablas.mostrarBBDD_A_Mezclar();
      pruebaTablas.guardarBBDD_A_Mezclar("base-restauracion4.csv");*/
      
      
      /*pruebaTablas.rellenarCampo(TYPE_BBDD.AUX, 14, "+34"); // Pa�s
      pruebaTablas.rellenarCampo(TYPE_BBDD.AUX, 15, "Santa Cruz de Tenerife"); // Provincia
      /*pruebaTablas.rellenarCampo(TYPE_BBDD.AUX, 22, "81"); // Categor�a
      pruebaTablas.rellenarCampo(TYPE_BBDD.AUX, 23, "42"); // Subcategor�a
      */
      
      //pruebaTablas.guardarBBDD_A_Mezclar("base-iass-4.csv");
      
      
      /*Vector<int []> pares = new Vector<int []> ();
      int par[] = new int [2];
      par[0] = 0;
      par[1] = 9;
      
      pares.add(par);
      
      par = new int [2];
      par[0] = 0;
      par[1] = 23;
      
      pares.add(par);
      
      par = new int [2];
      par[0] = 1;
      par[1] = 16;
      
      pares.add(par);
      
      par = new int [2];
      par[0] = 2;
      par[1] = 9;
      
      pares.add(par);
      
      par = new int [2];
      par[0] = 3;
      par[1] = 10;
      
      pares.add(par);
      
      par = new int [2];
      par[0] = 5;
      par[1] = 17;
      
      pares.add(par);
      
      par = new int [2];
      par[0] = 10;
      par[1] = 11;
      
      pares.add(par);
      
      par = new int [2];
      par[0] = 11;
      par[1] = 12;
      
      pares.add(par);
      
      
      par = new int [2];
      par[0] = 16;
      par[1] = 20;
      
      pares.add(par);
      
      
      par = new int [2];
      par[0] = 17;
      par[1] = 19;
      
      pares.add(par);
      
      
      /*par = new int [2];
      par[0] = 13;
      par[1] = 23;
      
      pares.add(par);
      
      pruebaTablas.trasladarDatos(pares);
      
      pruebaTablas.mostrarBBDD();
      pruebaTablas.guardarBBDD("base-iass.csv");*/
      
      
      
      
      
      //pruebaTablas.normalizarComillas ();
      
      //pruebaTablas.mostrarBBDD_A_Mezclar();
      
      //pruebaTablas.guardarBBDD_A_Mezclar("base-restauracion4.csv");
      
      /*pruebaTablas.eliminarRegistrosVaciosBBDD_A_Mezclar(2);
      
      pruebaTablas.mostrarBBDD_A_Mezclar();
      
      pruebaTablas.separarCampoGEOJason(2);
      
      pruebaTablas.mostrarBBDD_A_Mezclar();
      
      pruebaTablas.guardarBBDD_A_Mezclar("restauracion2.csv");
      //pruebaTablas.mostrarBBDD_A_Mezclar();
      
      //VentanaPrincipal pruebaVentana = new VentanaPrincipal ();
       
       */
   }
}
