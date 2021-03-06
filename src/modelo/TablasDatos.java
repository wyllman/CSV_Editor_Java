/**
 * 
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 * @author Guillermo Rodriguez Pardo
 *
 */

public class TablasDatos {
   public enum TYPE_BBDD {BIG, LITE, AUX};
   
   private Vector<String []> _BBDD;
   private Vector<String []> _BBDD_Lite;
   private Vector<String []> _BBDD_A_Mezclar;
   
   public TablasDatos() {
      _BBDD = new Vector<String[]>();
      _BBDD_Lite = new Vector<String[]>();
      _BBDD_A_Mezclar = new Vector<String[]>();
   }

   //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
   
   //----------------------------------------------------------------------------------
   // Metodos p�blicos.(Inicio) -------------------------------------------------------
   public void guardarBBDD (String archivo) {
      guardar (archivo, TYPE_BBDD.BIG);
   }
   public void guardarBBDD_Lite (String archivo) {
      guardar (archivo, TYPE_BBDD.LITE);
   }
   public  void guardarBBDD_A_Mezclar (String archivo) {
      guardar (archivo, TYPE_BBDD.AUX);
   }
   /*
    * Descripci�n: Funciones espec�ficas para la eliminaci�n de registros con el campo 
    *              de control especificado vacio.
    */
   public void eliminarRegistrosVaciosBBDD (int posCampoControl) {
      eliminarRegistrosVacios (TYPE_BBDD.BIG, posCampoControl);
   }
   public void eliminarRegistrosVaciosBBDD_Lite (int posCampoControl) {
      eliminarRegistrosVacios (TYPE_BBDD.LITE, posCampoControl);
   }
   public  void eliminarRegistrosVaciosBBDD_A_Mezclar (int posCampoControl) {
      eliminarRegistrosVacios (TYPE_BBDD.AUX, posCampoControl);
   }
   /*
    * Descripci�n: Funciones espec�ficas para mostrar los datos contenidos en cada una
    *              de las tres bases de datos.
    */
   final boolean EXTENDIDO = false;
   
   public void mostrarBBDD () {
      mostrar (TYPE_BBDD.BIG, EXTENDIDO);
   }
   public void mostrarBBDD_Lite () {
      mostrar (TYPE_BBDD.LITE, EXTENDIDO);
   }
   public  void mostrarBBDD_A_Mezclar () {
      mostrar ( TYPE_BBDD.AUX, EXTENDIDO);
   }
   /*
    * Descripci�n: Funciones espec�ficas para cargar, desde fichero, los datos en cada
    *              una de las tres bases de datos.
    */
   public void cargarBBDD (String archivo) {
      cargar (archivo, TYPE_BBDD.BIG);
   }
   public void cargarBBDD_Lite (String archivo) {
      cargar (archivo, TYPE_BBDD.LITE);
   }
   public  void cargarBBDD_A_Mezclar (String archivo) {
      cargar (archivo, TYPE_BBDD.AUX);
   }
   /*
    * Descripci�n: M�todo para la separaci�n de un campo de tipo GEOJason en dos campos
    *              Latitud, Longitud
    *              
    */
   public void separarCampoGEOJason (int posCampo) {
      String campoASeparar;
      String [] latitudLongitud;
      String [] temporal;
      for (int i = 0; i < _BBDD_A_Mezclar.size(); ++i) {
         campoASeparar = _BBDD_A_Mezclar.get(i)[posCampo];
         temporal = new String [_BBDD_A_Mezclar.get(i).length + 1];
         for (int j = 0; j < temporal.length; ++j) {
           if (j < posCampo) {
              temporal[j] = _BBDD_A_Mezclar.get(i)[j];
           } else if (j > posCampo + 1) {
              temporal[j] = _BBDD_A_Mezclar.get(i)[j - 1];
           }
         }
         
         if ( i >= 1) {
            latitudLongitud = campoASeparar.split(",");
            latitudLongitud[0] = latitudLongitud[0].substring(2);
            latitudLongitud[1] = latitudLongitud[1].substring(0, latitudLongitud[1].length() - 3);
            temporal[posCampo] = "\"" + latitudLongitud[0] + "\"";
            temporal[posCampo + 1]= "\"" + latitudLongitud[1] + "\"";
            
         } else {
            temporal[posCampo] = "latitud";
            temporal[posCampo + 1] = "longitud";
         }
         
         _BBDD_A_Mezclar.remove(i);
         _BBDD_A_Mezclar.add(i, temporal);
      }
   }
   /*
    * Descripci�n: M�todo general para trasladar los datos de la bbdd auxiliar a la bbdd
    *              del servidor. Se utiliza un vector de pares de enteros para indicar la
    *              correlaci�n entre las columnas de la bbdd auxiliar y la del servidor.
    */
   public void trasladarDatos () {
      for (int i = 1; i < _BBDD_A_Mezclar.size(); ++i) {
         _BBDD.add(_BBDD_A_Mezclar.get(i));
      }
   }
   public void trasladarDatos (Vector<int []> pares) { 
      String [] temporal; //= new String [_BBDD.get(0).length];
      
      for (int i = 1; i < _BBDD_A_Mezclar.size(); ++i) {
         temporal = new String [_BBDD.get(0).length];
         for (int j = 0; j < temporal.length; ++j) {
            temporal[j] = "\"\"";
         }
         
         
         for (int j = 0; j < pares.size(); ++j) {
            temporal[pares.get(j)[1]] = _BBDD_A_Mezclar.get(i)[pares.get(j)[0]]; 
         }
         _BBDD.add(temporal);
      }
   }
   public void normalizarComillas () {
      for (int i = 0; i < _BBDD_A_Mezclar.size(); ++i) {
         for (int j = 1; j < _BBDD_A_Mezclar.get(i).length; ++j) {
            if (_BBDD_A_Mezclar.get(i)[j].compareTo("") == 0 || _BBDD_A_Mezclar.get(i)[j] == null) {
               System.out.println("normalizando comillas...............");
               _BBDD_A_Mezclar.get(i)[j] = "\"" + _BBDD_A_Mezclar.get(i)[j] + "\"";
            }
         }
      }
   }
   /*
    * Descripci�n:
    */
   public void numerarCampo (TYPE_BBDD tipo, int posCampo) {
      Vector<String []> temporal = null;
      switch (tipo) {
         case BIG:
            temporal = _BBDD;
            break;
         case LITE:
            temporal = _BBDD_Lite;
            break;
         case AUX:
            temporal = _BBDD_A_Mezclar;
            break;
         default:
            break;
      }
      
      for (int i = 1; i < temporal.size(); ++i) {
         temporal.get(i)[posCampo] = "\"" + i + "\"";
      }
   }
   /*
    * Descripci�n:
    */
   public void rellenarCampo (TYPE_BBDD tipo, int posCampo, String contenido) {
      Vector<String []> temporal = null;
      switch (tipo) {
         case BIG:
            temporal = _BBDD;
            break;
         case LITE:
            temporal = _BBDD_Lite;
            break;
         case AUX:
            temporal = _BBDD_A_Mezclar;
            break;
         default:
            break;
      }
      
      for (int i = 1; i < temporal.size(); ++i) {
         temporal.get(i)[posCampo] = "\"" + contenido + "\"";
      }
   }
   /*
    * Descripci�n:
    */
   public void eliminarCampoTexto (TYPE_BBDD tipo, int posCampo, String textoComp) {
      Vector<String []> temporal = null;
      switch (tipo) {
         case BIG:
            temporal = _BBDD;
            break;
         case LITE:
            temporal = _BBDD_Lite;
            break;
         case AUX:
            temporal = _BBDD_A_Mezclar;
            break;
         default:
            break;
      }
      
      for (int i = 0; i < temporal.size(); ++i) {
         if (temporal.get(i)[posCampo].compareToIgnoreCase(textoComp) == 0){
            temporal.remove(i);
            --i;
         }
      }
   }
   /*
    * Descripci�n:
    */
   public void cambiarCampo (TYPE_BBDD tipo, int posCampoCom, String textoCom, int posCampoDest, String contenido) {
      Vector<String []> temporal = null;
      switch (tipo) {
         case BIG:
            temporal = _BBDD;
            break;
         case LITE:
            temporal = _BBDD_Lite;
            break;
         case AUX:
            temporal = _BBDD_A_Mezclar;
            break;
         default:
            break;
      }
      for (int i = 0; i < temporal.size(); ++i) {
          if (temporal.get(i)[posCampoCom].compareToIgnoreCase(textoCom) == 0){
             temporal.get(i)[posCampoDest] = "\"" + contenido + "\"";
          }
       }
   }
   // Metodos publicos.(Fin) ----------------------------------------------------------
   //----------------------------------------------------------------------------------
   
   //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
   
   //----------------------------------------------------------------------------------
   // Metodos privados.(Inicio) -------------------------------------------------------
  
   /*
    * Descripci�n:
    */
   private void guardar (String nombreArchivo, TYPE_BBDD tipo) {
      Vector<String []> temporal = null;
      String linea;
      FileWriter fichero = null;
      PrintWriter pw = null;
      try {
         fichero = new FileWriter(nombreArchivo);
         pw = new PrintWriter(fichero);
         
         switch (tipo) {
            case BIG:
               temporal = _BBDD;
               break;
            case LITE:
               temporal = _BBDD_Lite;
               break;
            case AUX:
               temporal = _BBDD_A_Mezclar;
               break;
            default:
               break;
         }
         
         for (int i = 0; i < temporal.size(); ++i) {
            linea = "";
            for (int j = 0; j < temporal.get(i).length; ++j) {
               if (j < temporal.get(i).length - 1) {
                 linea += temporal.get(i)[j] + ",";
               } else {
                 linea += temporal.get(i)[j];
               }
            }
            pw.println(linea);
         }
         
      } catch (IOException e) {
         System.out.println("Error abriendo archivo...");
         e.printStackTrace();
      } finally {
          try {
             if (null != fichero)
                fichero.close();
          } catch (Exception e2) {
             e2.printStackTrace();
          }
       }
   }
   
   /*
    * Descripci�n: M�todo general para eliminar los registros con el campo de control
    *              vac�o.
    */
   private void eliminarRegistrosVacios (TYPE_BBDD tipo, int posCampoControl) {
      Vector<String []> temporal = null;
      switch (tipo) {
         case BIG:
            temporal = _BBDD;
            break;
         case LITE:
            temporal = _BBDD_Lite;
            break;
         case AUX:
            temporal = _BBDD_A_Mezclar;
            break;
         default:
            break;
      }
      
      for (int i = 0; i < temporal.size(); ++i) {
         if (temporal.get(i).length > posCampoControl)
         if (temporal.get(i)[posCampoControl].matches("\"\b*\"|\b+")) {
            System.out.println("+++++++++ENCONTRADO+++++++++++++++");
            temporal.remove(i);
            --i;
         }
      }
   }
   /*
    * Descripci�n: M�todo general para mostrar por consola el contenido de los tres 
    *              tipos de BBDD internas.
    */
   private void mostrar (TYPE_BBDD tipo, boolean extendido) {
      Vector<String []> temporal = null;
      String cadenaTemporal = "";
      switch (tipo) {
         case BIG:
            System.out.println("Base de datos servidor: ");
            System.out.println("   - N�mero registros: " + _BBDD.size());
            temporal = _BBDD;
            break;
         case LITE:
            System.out.println("Base de datos telefono: ");
            System.out.println("   - N�mero registros: " + _BBDD_Lite.size());
            temporal = _BBDD_Lite;
            break;
         case AUX:
            System.out.println("Base de datos auxiliar: ");
            System.out.println("   - N�mero registros: " + _BBDD_A_Mezclar.size());
            temporal = _BBDD_A_Mezclar;
            break;
         default:
            break;
      }
      
      if (extendido && temporal != null) {
         for (int i = 0; i < temporal.size(); ++i) {
            cadenaTemporal = "";
            for (int j = 0; j < temporal.get(i).length; ++j) {
               cadenaTemporal += temporal.get(i)[j] + ",";
            }
            System.out.println(cadenaTemporal);
         }
      }
   }
   
   /*
    * Descripci�n: M�todo general para la carga de los datos de los tres tipos de BBDD
    *              internas.
    */
   private void cargar (String nombreArchivo, TYPE_BBDD tipo) {
      File archivo = new File (nombreArchivo);
      FileReader fr = null;
      BufferedReader br = null;
      String linea;
      String [] tokens = null;
      
      try {
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         while((linea = br.readLine()) != null) {
             tokens = parsearLinea (linea);
             switch (tipo) {
                case BIG:
                   _BBDD.add(tokens);
                   break;
                case LITE:
                   _BBDD_Lite.add(tokens);
                   break;
                case AUX:
                   _BBDD_A_Mezclar.add(tokens);
                   break;
                default:
                   break;
            }
         }
      } catch (FileNotFoundException e) {
         System.out.println("Error abriendo archivo...");
         e.printStackTrace();
      } catch (IOException e) {
         System.out.println("Error leyendo linea de archivo...");
         e.printStackTrace();
      } finally {
          try {                   
             if( null != fr ) {  
                fr.close();    
             }                 
             if ( null != br) {
                br.close();
             }
          }catch (Exception e2) {
             e2.printStackTrace();
          }
       }
   }
   
   /*
    * Descripci�n: M�todo que parsea un registro de tipo CSV guardado en un string y 
    *              retorna un array de string con los campos del registro por separado.
    */
   private String[] parsearLinea (String linea) {
      String otherThanQuote = " [^\"] ";
      String quotedString = String.format(" \" %s* \" ", otherThanQuote);
      String regex = String.format("(?x) "+ // enable comments, ignore white spaces
              ",                         "+ // match a comma
              "(?=                       "+ // start positive look ahead
              "  (                       "+ //   start group 1
              "    %s*                   "+ //     match 'otherThanQuote' zero or more times
              "    %s                    "+ //     match 'quotedString'
              "  )*                      "+ //   end group 1 and repeat it zero or more times
              "  %s*                     "+ //   match 'otherThanQuote'
              "  $                       "+ // match the end of the string
              ")                         ", // stop positive look ahead
              otherThanQuote, quotedString, otherThanQuote);
      String [] tokens;
      tokens = linea.split(regex, -1);
      
      return (tokens);
   }
   // Metodos privados.(Fin) ----------------------------------------------------------
   //----------------------------------------------------------------------------------
}

