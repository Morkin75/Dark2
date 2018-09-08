/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dark;

/**
 *
 * @author manueljesusgarcialopez
 */

//Clase usada para crear objetos que almacenen las ordenes de los personajes
public class EnviarOrdenes {

    public int ID = 0; //Este es el ID del PJ
    public int accion1 = 0; //Estos son los IDs de las acciones
    public int accion2 = 0;
    public int accion3 = 0;

    
    EnviarOrdenes(int id, int a1, int a2, int a3) {
        
        this.ID = id;
        this.accion1 = a1;
        this.accion2 = a2;
        this.accion3 = a3;
        
    }
    
    
    
}
