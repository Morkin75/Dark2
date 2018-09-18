/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dark;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 *
 * @author manueljesusgarcialopez
 */
public class Dark {

    //URL para indicar Ruta
    static java.net.URL url;
    static String rutaImagenes;
    
    public static Icon imageCalle;
    public static JLabel calle = new JLabel(imageCalle);
    
    //Ventana de inicio
    static VentanaInicio ventanaInicio = new VentanaInicio();
    
    //Objeto de conexion
    static Conector con = new Conector();
        //Intentamos la conexion con la BBDD
        //Creamos el conector
        //con = new Conector();
    
    //Mapa de inicio
    public int[][] mapa = new int[32][16];
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //Indicamos la imagen del label
        //imageCalle = new ImageIcon("../Dark/Imagenes/CalleUD.png");
        
        //Ponemos la imagen en nuestro label
        //calle.setIcon(imageCalle);
        //Podemos el label en una casilla en el mapa
        //Indicamos el archivo del PJ
        
        //Indicamos la ruta de la imagen a poner
        rutaImagenes = "/images/CalleUD.png";   
        url = ventanaInicio.getClass().getResource(rutaImagenes);
        
        
        /*  NO BORRAR - ASÍ SE CARGAN LOS GRÁFICOS EN LOS LABELS
        //Cargamos el gráfico
        ImageIcon icon = new ImageIcon(url);
        //ventanaInicio.casillasMapa[5][6].setBackground(Color.black);
        ventanaInicio.mapaFondo.casillasMapa[5][6].setHorizontalAlignment(JLabel.CENTER);
        ventanaInicio.mapaFondo.casillasMapa[5][6].setText("");//Para alinear el gráfico no puede haber texto en el label
        
        ventanaInicio.mapaFondo.casillasMapa[5][6].setIcon(icon);
        */
        
        //Inicializamos y mostramos la ventana
        ventanaInicio.getContentPane().setBackground(Color.LIGHT_GRAY);
        //ventanaInicio.setSize(1024, 724);
        ventanaInicio.setResizable(false);
        ventanaInicio.setVisible(true);
        
        ventanaInicio.jScrollMapa.setBackground(Color.red);
        //ventanaInicio.jPanel1.setPreferredSize(new Dimension(400, 200));
        
        //Este panel se muestra cuando estamos en las pestañas de acciones o...
        //Desde la clase lo mostramos y aquí lo escondemos para mostrarlo cuando se pulse la pestaa adecuada
        
        
        
        
        /* De aquí para abajo, comentado si usamos JFileChooser*/
        //Abrimos la conexión automática. Comentar todas las llamadas de con cuando haya que cargar con el JFileChoose
        
        con.connect(); //ESTA
        
        //Cargamos la tabla de las acciones. Comentamos esto cuando queramos usar el JFileChoose
        con.mostrarAcciones(); //ESTA
        
        
        //Cargamos la tabla de los personajes - PJs antes que acciones
        con.mostrarPersonajes();  //ESTA
        //Cargamos las acciones de los menus
        ventanaInicio.ordenes.cargarMenu(); //ESTA
        //Si la acción es la de mover...
        ventanaInicio.ordenes.cargarMenuEscogerLugar(); //ESTA
        ventanaInicio.ordenes.jComboBox1_1.setVisible(false); //ESTA
        
        
        
        
        
        //Cargamos la tabla de los objetos
        con.mostrarObjetos();  //ESTA
        
        //Vamos a pintar las casillas con PJs
        ventanaInicio.mostrarPJs();  //ESTA
        ventanaInicio.mostrarObjetos();  //ESTA
        
        
        
        //Cerramos la conexión
        con.close();  //ESTA
        
        
        
    }
    
    
    
}
