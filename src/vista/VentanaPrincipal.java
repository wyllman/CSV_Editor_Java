/**
 * 
 */
package vista;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author tenerent
 *
 */
public class VentanaPrincipal extends JFrame {

	
	private JTable tbl;
	/**
	 * 
	 */
   public VentanaPrincipal() {
      super ("Editor CSV para TTG");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setBounds(50, 10, 1000, 650);
      
      cargarContenido();
      
      setVisible(true);
   }
   
   public void cargarContenido () {
   Vector columnas = new Vector();

   	columnas.add("Columna A");
   	columnas.add("Columna B");
   	columnas.add("Columna C");
   	columnas.add("columna D");
   	columnas.add("columna D");
   	columnas.add("columna D");
   	columnas.add("columna D");
   	columnas.add("columna D");
   	
   	Vector filas = new Vector();

   	Vector fila = new Vector();
   	
   	fila.add("X");
   	fila.add("Y");
   	fila.add("Z");

   	filas.add(fila);
   	filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);
   	filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);
   	filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);
   	
   	//DefaultTableModel modelo = new DefaultTableModel();
   	//JTable tbl = new JTable(modelo);
   	
   	tbl = new JTable(filas,columnas);
   	JScrollPane panel = new JScrollPane(tbl
                                        , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
                                        , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    tbl.setFillsViewportHeight(true);
    tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    tbl.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row =  tbl.rowAtPoint(evt.getPoint());
            int col =  tbl.columnAtPoint(evt.getPoint());
            System.out.println("Clickeando en celda: (" + row + ", " + col + ")");
            if (row >= 0 && col >= 0) {
                System.out.println("Clickeando en celda: (" + row + ", " + col + ")");

            }
        }
   });
   add(panel);
   }
}
