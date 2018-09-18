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
import javax.swing.JOptionPane;

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
        if(System.getProperty("os.name").compareTo("Windows 10") == 0) {
            urlBBDD = "..\\Dark2\\BBDD\\BDDark.db"; //Para Windows
            System.out.println("Pasa por Windows");
        }
        if(System.getProperty("os.name").compareTo("Linux") == 0) {
            urlBBDD = "../Dark2/BBDD/BDDark.db"; //Para LINUX
            System.out.println("Pasa por Linux");
        }
      
        //Comentar esto cuando no haya que usar el JFileChooser
        //urlBBDD = archivoRuta.getPath(); //Desde Archivo ESTA
        
        
        
        //A ver la ruta:
        System.out.println(archivoRuta.getAbsolutePath());
        //System.out.println(file.getPath());
        
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+urlBBDD);
            if (connect!=null) {
                System.out.println("Conectado");
            } 
        } catch (Exception ex) {
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
        int registro = 0;
        try {
            PreparedStatement st;
            st = con.connect.prepareStatement("Select * FROM Personajes");
            result = st.executeQuery();
            while (result.next()) {
                
                //Ahora añadimos el Personaje en nuestro Arralist de objetos
            Dark.ventanaInicio.personajesBando1.add(new Personajes
                (registro,
                 result.getString("Nombre"),
                 result.getInt("Fuerza"),
                 result.getInt("Velocidad"),
                 result.getInt("Energía"),
                 result.getInt("Agilidad"),
                 result.getInt("Magia"),
                 result.getInt("Vida"),
                 result.getString("Rango"),
                 result.getInt("Oro"),
                 result.getInt("PosX"),
                 result.getInt("PosY"),
                 result.getInt("Mov")));
                
            // Se crea un array que será una de las filas de la tabla. 
            Object [] fila = new Object[10]; // Hay 10 columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en el Array de los PJs.
            fila[0] = Dark.ventanaInicio.personajesBando1.get(registro).getNombre();
            fila[1] = Dark.ventanaInicio.personajesBando1.get(registro).getPosX() + "-" + Dark.ventanaInicio.personajesBando1.get(registro).getPosY();
            fila[2] = Dark.ventanaInicio.personajesBando1.get(registro).getRango();
            fila[3] = Dark.ventanaInicio.personajesBando1.get(registro).getFuerza();
            fila[4] = Dark.ventanaInicio.personajesBando1.get(registro).getVelocidad();
            fila[5] = Dark.ventanaInicio.personajesBando1.get(registro).getEnergia();
            fila[6] = Dark.ventanaInicio.personajesBando1.get(registro).getAgilidad();
            fila[7] = Dark.ventanaInicio.personajesBando1.get(registro).getMagia();
            fila[8] = Dark.ventanaInicio.personajesBando1.get(registro).getVida();
            fila[9] = Dark.ventanaInicio.personajesBando1.get(registro).getOro();
            
                        // Se añade al modelo la fila completa.
            Dark.ventanaInicio.personajes.addRow(fila);
            //modelo.addRow(fila); 
            
            registro++;
            
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void mostrarObjetos(){
        ResultSet result = null;
        try {
            PreparedStatement st;
            st = con.connect.prepareStatement("Select * FROM Objetos");
            result = st.executeQuery();
            while (result.next()) {
                
            // Se crea un array que será una de las filas de la tabla. 
            Object [] fila = new Object[2]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
            for (int i=0;i<2;i++)
                fila[i] = result.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

            // Se añade al modelo la fila completa.
            ventanaInicio.objetos.addRow(fila);
            
            //modelo.addRow(fila); 
            
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
    
    public String[] cargarBandos(){
        // Se crea un array que será una de las filas de la tabla. 
        String [] fila = new String[7]; // Solo me interesan los valores de la columna 1
        ResultSet result = null;
        try {
            PreparedStatement st;
            st = con.connect.prepareStatement("Select Bando FROM Bandos");
            result = st.executeQuery();
            int i = 0; //Empezamos por el Elemento 0
            while (result.next()) {
            
            // Se rellena cada posición del array con la columna de los Bandos.
            fila[i] = result.getObject("Bando").toString();
            System.out.println("FILA1: " + fila[i]);
            
            i++; 
            
            
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        //Se devuelve el array de String
        return fila;
    }
 
    
}
