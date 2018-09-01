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
    static VentanaInicio ventanaInicio;
    
    //Mapa de inicio
    public int[][] mapa = new int[32][16];
    
    //Objeto de conexion
    public static Conector con;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Intentamos la conexion con la BBDD
        //Creamos el conector
        con = new Conector();
        //Abrimos la conexión
        con.connect();
                
        Graphics g = null;
        
        // creamos la instancia de la ventana
        ventanaInicio = new VentanaInicio();
        
        //Inicializamos y mostramos la ventana
        ventanaInicio.getContentPane().setBackground(Color.LIGHT_GRAY);
        ventanaInicio.setSize(1024, 724);
        ventanaInicio.setResizable(false);
        ventanaInicio.setVisible(true);
        
        ventanaInicio.jScrollMapa.setBackground(Color.red);
        //ventanaInicio.jPanel1.setPreferredSize(new Dimension(400, 200));
        
        //ventanaInicio.dibujaLinea(g);
        
        //ventanaInicio.panel1.paintComponents();
        
        //Cargamos la tabla de las acciones
        con.mostrarAcciones();
        
        //Cerramos la conexión
        con.close();
        
    }
    
    
    
    
}
