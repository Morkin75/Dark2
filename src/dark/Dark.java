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
/**
 *
 * @author manueljesusgarcialopez
 */
public class Dark {

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
        
        
        // creamos la instancia de la ventana
        //ventanaInicio = new VentanaInicio();
        
        //Inicializamos y mostramos la ventana
        ventanaInicio.getContentPane().setBackground(Color.LIGHT_GRAY);
        ventanaInicio.setSize(1024, 724);
        ventanaInicio.setResizable(false);
        ventanaInicio.setVisible(true);
        
        ventanaInicio.jScrollMapa.setBackground(Color.red);
        //ventanaInicio.jPanel1.setPreferredSize(new Dimension(400, 200));
        
        //Este panel se muestra cuando estamos en las pestañas de acciones o...
        //Desde la clase lo mostramos y aquí lo escondemos para mostrarlo cuando se pulse la pestaa adecuada
        ventanaInicio.jScrollInfo.setVisible(false);
        
        
        
        
        //Abrimos la conexión automática. Comentar todas las llamadas de con cuando haya que cargar con el JFileChoose
        con.connect();
        
        //Cargamos la tabla de las acciones. Comentamos esto cuando queramos usar el JFileChoose
        con.mostrarAcciones();
        
        //Cargamos las acciones de los menus
        ventanaInicio.ordenes.cargarMenu();
        
        //Cargamos la tabla de los personajes
        con.mostrarPersonajes();
        
        //Cerramos la conexión
        con.close();
        
    }
    
    
}
