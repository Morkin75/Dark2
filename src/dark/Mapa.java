/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dark;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author manueljesusgarcialopez
 */
public class Mapa extends javax.swing.JLayeredPane {

    //Variables para desplazar el mapa al pulsar y arrastrar el ratón
    int desplazarX;
    int desplazarY;
    
    //Casillas del Mapa
    public JLabel[][] casillasMapa;
    /**
     * Creates new form CasillasMapa
     */
    public Mapa() {
        initComponents();
        
        //Creamos el mapa
        casillasMapa = new JLabel[32][16];
        
        
        //Variables para desplazar el raton
        desplazarX = 0;
        desplazarY = 0;
        //Inicializamos los JLabel
        //inicializarMapa();
        //Rellenamos los JLabel
        //rellenarMapa();
        //rellenarMapaPJ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    /*private void formMousePressed(java.awt.event.MouseEvent evt) {                                  
        //Al presionar ratón, guardamos la posición del mismo
        //desplazarX = evt.getX();
        //desplazarY = evt.getY();
    }                                 

    private void formMouseDragged(java.awt.event.MouseEvent evt) {                                  
        //Point point = MouseInfo.getPointerInfo().getLocation();
        //setLocation(point.x - desplazarX, point.y - desplazarY);
    } */
                                     

                                        
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    public void inicializarMapaConTextoLabel() {
    
        Color color = new Color(255, 255, 255, 0);
        
        for(int x=0;x<32;x++) {
            for(int y=0;y<16;y++) {
                casillasMapa[x][y] = new JLabel("Label"+x+""+y);
                casillasMapa[x][y].setHorizontalAlignment(CENTER);
                casillasMapa[x][y].setForeground(Color.WHITE);
                casillasMapa[x][y].setOpaque(true);
                casillasMapa[x][y].setBackground(Color.LIGHT_GRAY);//
                //casillasMapa[x][y].setComponentZOrder(this, 1);
                //casillasMapaGraficosPJ[x][y].setComponentZOrder(this, 2);
                //casillasMapa[x][y].setBorder();
            }
        }
    }
    
    public void inicializarMapaVacio() {
    
        Color color = new Color(255, 255, 255, 0);
        
        for(int x=0;x<32;x++) {
            for(int y=0;y<16;y++) {
                casillasMapa[x][y] = new JLabel("");
                casillasMapa[x][y].setHorizontalAlignment(JLabel.CENTER);
                casillasMapa[x][y].setForeground(new Color(220, 220, 220, 220));
                casillasMapa[x][y].setOpaque(false);
                casillasMapa[x][y].setBackground(new Color(220, 220, 220, 0));//
                //casillasMapa[x][y].setHorizontalAlignment(JLabel.CENTER);
               
            }
        }
    }

    public void limpiarMapa() {
        for(int x=0;x<32;x++) {
            for(int y=0;y<16;y++) {
                casillasMapa[x][y].setBackground(Color.LIGHT_GRAY);
            }
        }
    }
    
    public void limpiarBordesMapa() {
        Border border = LineBorder.createBlackLineBorder();
        for(int x=0;x<32;x++) {
            for(int y=0;y<16;y++) {
                casillasMapa[x][y].setBorder(null);
            }
        }
    }
    
    public void rellenarMapa() {
    
        for(int x=0;x<32;x++) {
            for(int y=0;y<16;y++) {
                //casillasMapa[x][y] = null;
                casillasMapa[x][y].setText(""+x+""+y);
                casillasMapa[x][y].setSize(32, 32);
                casillasMapa[x][y].setLocation(x+(32*x), y+(32*y));
                
                //casillasMapa[x][y].setText(""+x+""+y);
                     
                //Añadimos las casillas al mapa-jPanel1
                this.add(casillasMapa[x][y]);
                //jPanel1.add(casillasMapa[x][y]);
                
            }
        }
    }
    
    public void rellenarMapaSinCoordenadas() {
    
        for(int x=0;x<32;x++) {
            for(int y=0;y<16;y++) {
                //casillasMapa[x][y] = null;
                casillasMapa[x][y].setText("");
                casillasMapa[x][y].setSize(32, 32);
                casillasMapa[x][y].setLocation(x+(32*x), y+(32*y));
                
                //casillasMapa[x][y].setText(""+x+""+y);
                     
                //Añadimos las casillas al mapa-jPanel1
                this.add(casillasMapa[x][y]);
                //jPanel1.add(casillasMapa[x][y]);
                
            }
        }
    }
    
    public void inicializaCaminos() {
        String rutaImagenes = "";
        java.net.URL url = null;
        ImageIcon icon = null;
        for(int x=0;x<32;x++) {
            for(int y=0;y<16;y++) {
                //casillasMapa[x][y] = null;
                casillasMapa[x][y].setText("");
                casillasMapa[x][y].setSize(32, 32);
                casillasMapa[x][y].setLocation(x+(32*x), y+(32*y));
                
                casillasMapa[x][y].setHorizontalAlignment(JLabel.CENTER);
                casillasMapa[x][y].setForeground(new Color(220, 220, 220, 220));
                //casillasMapa[x][y].setOpaque(false);
                casillasMapa[x][y].setBackground(new Color(220, 220, 220, 0));//
                //casillasMapa[x][y].setText(""+x+""+y);
                
                //System.out.println("MAPA: " + x + ":" + y);
                //System.out.println("MAPAI: " + Constantes.mapaConCaminos[x][y]);
                switch(Constantes.mapaConCaminos[x][y]) {
                    case 1:
                        rutaImagenes = "/images/casillaNorte.png";
                        break;
                    case 2:
                        rutaImagenes = "/images/casillaEste.png";
                        break;
                    case 3:
                        rutaImagenes = "/images/casillaSur.png";
                        break;
                    case 4:
                        rutaImagenes = "/images/casillaOeste.png";
                        break;
                    case 5:
                        rutaImagenes = "/images/casillaNorteEste.png";
                        break;
                    case 6:
                        rutaImagenes = "/images/casillaNorteSur.png";
                        break;
                    case 7:
                        rutaImagenes = "/images/casillaOesteNorte.png";
                        break;
                    case 8:
                        rutaImagenes = "/images/casillaEsteSur.png";
                        break;
                    case 9:
                        rutaImagenes = "/images/casillaEsteOeste.png";
                        break;
                    case 10:
                        rutaImagenes = "/images/casillaSurOeste.png";
                        break;
                    case 11:
                        rutaImagenes = "/images/casillaSEN.png";
                        break;
                    case 12:
                        rutaImagenes = "/images/casillaESO.png";
                        break;
                    case 13:
                        rutaImagenes = "/images/casillaNOS.png";
                        break;
                    case 14:
                        rutaImagenes = "/images/casillaONE.png";
                        break;
                    default:
                        rutaImagenes = "/images/casillaVacia.png";
                        break;
                }
                
                url = this.getClass().getResource(rutaImagenes);
                //Cargamos el gráfico
                icon = new ImageIcon(url);
                //System.out.println("Coord2x: " + coordenadaX);
            
                //Dibujamos el gráfico en el mapa
                casillasMapa[x][y].setIcon(icon);
                
                
                //Añadimos las casillas al mapa-jPanel1
                //this.add(casillasMapa[x][y]);
                //jPanel1.add(casillasMapa[x][y]);
                
            }
        }
    }
    
    void rellenaRuta(int posx, int posy) { //Método para rellenar la ruta de los posibles caminos
        casillasMapa[posx][posy].setBackground(new Color(100, 200, 200, 255));
        //System.out.println("RELLENAMAPA: " + posx + ":" + posy);
    }
    

}
