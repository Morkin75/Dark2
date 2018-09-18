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
public class Constantes {
    
    //Rutas con las casillas
    static String casilla01 = "/images/casillaNorte.png";
    static String casilla02 = "/images/casillaEste.png";
    static String casilla03 = "/images/casillaSur.png";
    static String casilla04 = "/images/casillaOeste.png";
    static String casilla05 = "/images/casillaNorteEste.png";
    static String casilla06 = "/images/casillaNorteSur.png";
    static String casilla07 = "/images/casillaOesteNorte.png";
    static String casilla08 = "/images/casillaEsteSur.png";
    static String casilla09 = "/images/casillaEsteOeste.png";
    static String casilla10 = "/images/casillaSurOeste.png";
    static String casilla11 = "/images/casillaSEN.png";
    static String casilla12 = "/images/casillaESO.png";
    static String casilla13 = "/images/casillaNOS.png";
    static String casilla14 = "/images/casillaONE.png";
    
    //Mapa de inicio
    
    public static int mapaConCaminos[][] = {
        {0,0,0,0,8,6,11,6,11,6,11,5,0,0,0,0},
        {0,0,0,0,12,5,9,8,7,0,10,7,0,0,0,0},
        {0,8,6,11,7,12,7,12,11,11,6,11,6,6,5,0},
        {0,12,6,7,2,9,0,4,10,14,0,9,8,6,14,0},
        {2,12,6,5,9,9,0,8,5,10,6,14,10,6,14,2},
        {9,12,6,13,14,9,8,14,12,6,6,13,6,6,14,9},
        {9,9,0,0,9,12,13,7,12,6,5,0,8,6,7,9},
        {9,9,0,0,10,7,0,2,12,1,10,5,10,11,11,7},
        {9,12,6,6,6,11,11,14,12,6,11,7,8,7,10,5},
        {9,12,5,0,0,12,7,10,7,0,9,8,7,8,5,9},
        {10,7,10,6,5,10,6,6,5,8,7,10,6,14,12,7},
        {0,0,0,0,9,8,6,5,9,9,8,6,6,7,9,2},
        {0,0,8,6,7,10,5,9,10,13,13,5,8,11,7,9},
        {8,5,10,6,11,11,7,9,0,0,0,9,9,9,8,7},
        {9,12,11,11,7,9,8,13,6,6,6,13,13,13,13,5},
        {9,9,9,10,5,10,14,8,6,6,6,6,6,5,8,7},
        {9,9,9,0,9,0,9,9,8,11,11,6,5,9,9,0},
        {9,10,14,0,10,11,14,9,10,7,12,11,14,10,13,5},
        {9,8,14,0,0,10,14,9,8,5,9,9,9,8,11,7},
        {9,9,10,11,5,0,9,4,9,9,9,9,10,7,9,0},
        {9,10,5,10,14,0,10,11,7,10,7,12,6,6,14,0},
        {9,0,9,0,10,11,6,7,0,0,8,7,0,8,7,0},
        {9,0,9,0,0,10,5,0,0,0,10,5,0,9,0,0},
        {10,5,9,0,8,5,10,11,6,6,5,9,0,10,5,0},
        {0,10,13,5,9,12,6,7,0,8,13,13,5,0,9,0},
        {0,0,8,13,7,4,0,8,5,9,3,5,12,6,7,0},
        {0,0,10,6,6,11,6,7,9,10,6,7,12,5,0,0},
        {0,0,0,0,0,9,0,0,10,5,0,0,10,14,0,0},
        {0,0,0,8,6,7,8,6,6,14,0,0,0,10,5,0},
        {0,0,8,7,8,6,7,0,8,14,0,0,0,8,7,0},
        {0,0,10,6,7,0,0,0,10,13,6,6,6,7,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    
}
