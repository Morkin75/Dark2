/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dark;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ManuSobremesa
 */
public class CrearFichero implements Serializable {
    
    static void guardarArrayList(ArrayList<SubOrdenes> ordenes) {
        
        String fichero = "../ordenes.dat";
        ObjectOutputStream ficheroSalida = null;
        
        try {
           
            ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
            ficheroSalida.writeObject(ordenes);
            ficheroSalida.flush();
            //ficheroSalida.close();
            System.out.println("Órdenes guardas correctamente... ");
        } catch (FileNotFoundException fnfe) {
            System.out.println("El archivo no existe E1: " + fnfe);
        } catch (IOException ioe) {
            System.out.println("El archivo no existe E2: " + ioe);
        } 
        
        try {
            ficheroSalida.close();
        } catch (IOException ex) {
            Logger.getLogger(CrearFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
