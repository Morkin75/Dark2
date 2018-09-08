package dark;

import static dark.Dark.con;
import static dark.Dark.ventanaInicio;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manueljesusgarcialopez
 */
public class Conector {
    
    File archivoRuta = new File(".");
    //File archivoRuta = Dark.ventanaInicio.abre;
    
    //Cadena para almacenar la URL de la base de datos
    String urlBBDD;
    
    //Objeto de conexión a la base de datos
    Connection connect;

    //Este es el constructor
    public Conector() {
      
    }
    
    public void connect(){
        
        //System.out.println(archivoRuta.toString());
        
        System.out.println(System.getProperty("os.name"));
        //Preguntamos por el Sistema Operativo para conocer la ruta del archivo
        if(System.getProperty("os.name").compareTo("Mac OS X") == 0) {
            urlBBDD = "../Dark/BBDD/BDDark.db"; //Para MAC
            System.out.println("Pasa por MAC");
        }
        if(System.getProperty("os.name").compareTo("Windows") == 0) {
            urlBBDD = "..\\DarkSceptreBeta\\BBDD\\BDDark.db"; //Para Windows
            System.out.println("Pasa por Windows");
        }
        //Comentar esto cuando no haya que usar el JFileChooser
        //urlBBDD = archivoRuta.getPath(); //Desde Archivo
        
        
        //A ver la ruta:
        System.out.println(archivoRuta.getAbsolutePath());
        //System.out.println(file.getPath());
        
 try {
     connect = DriverManager.getConnection("jdbc:sqlite:"+urlBBDD);
     if (connect!=null) {
         System.out.println("Conectado");
     }
 }catch (SQLException ex) {
     System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
 }
}
 public void close(){
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 
 public void mostrarAcciones(){
        ResultSet result = null;
        try {
            PreparedStatement st;
            st = con.connect.prepareStatement("Select * FROM Acciones");
            result = st.executeQuery();
            while (result.next()) {
                
            // Se crea un array que será una de las filas de la tabla. 
            Object [] fila = new Object[3]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
            for (int i=0;i<3;i++)
                fila[i] = result.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

            // Se añade al modelo la fila completa.
            ventanaInicio.acciones.addRow(fila);
            
            //modelo.addRow(fila); 
            
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
    public void mostrarPersonajes(){
        ResultSet result = null;
        try {
            PreparedStatement st;
            st = con.connect.prepareStatement("Select * FROM Personajes");
            result = st.executeQuery();
            while (result.next()) {
                
            // Se crea un array que será una de las filas de la tabla. 
            Object [] fila = new Object[10]; // Hay 10 columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
            //for (int i=0;i<10;i++)
                //fila[i] = result.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
            fila[0] = result.getObject("Nombre");
            fila[1] = result.getObject("PosX") + "-" + result.getObject("PosY");
            fila[2] = result.getObject("Rango");
            fila[3] = result.getObject("Fuerza");
            fila[4] = result.getObject("Velocidad");
            fila[5] = result.getObject("Energía");
            fila[6] = result.getObject("Agilidad");
            fila[7] = result.getObject("Magia");
            fila[8] = result.getObject("Vida");
            fila[9] = result.getObject("Oro");
            
            // Se añade al modelo la fila completa.
            Dark.ventanaInicio.personajes.addRow(fila);
            //modelo.addRow(fila); 
            
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
 
    
}
