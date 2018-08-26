/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dark;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.Border;

/**
 *
 * @author manueljesusgarcialopez
 */
public class VentanaInicio extends javax.swing.JFrame {

    //Array de casillas del mapa
    public JLabel[][] casillasMapa;
    
    //Graphics cuadrado = null;
    BufferedImage cuadrado;
    
    int posMapaX, posMapaY;
    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
        initComponents();
        
        //Casilla seleccionada del mapa
        posMapaX = 0;
        posMapaY = 0;
        
        //getGraphics().drawLine(10, 10, 200, 200);
        //repaint();
        
        cuadrado = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        
        //Creamos el mapa
        casillasMapa = new JLabel[32][16];
        //Inicializamos los JLabel
        inicializarMapa();
        //Rellenamos los JLabel
        rellenarMapa();
        
        
        
        
    }
    
    @Override
    public void paint(Graphics g) {
        
        super.paint(g);
        
        //Lineas Horizontales
        //g.setColor(new Color(20,20,20)); g.drawLine(70, 82, 870, 82); g.drawLine(70, 102, 870, 102);
        //g.drawLine(70, 122, 870, 122); g.drawLine(70, 142, 870, 142); g.drawLine(70, 162, 870, 162);
        //g.drawLine(70, 182, 870, 182); g.drawLine(70, 202, 870, 202); g.drawLine(70, 222, 870, 222);
        //g.drawLine(70, 242, 870, 242); g.drawLine(70, 262, 870, 262); g.drawLine(70, 282, 870, 282);
        //g.drawLine(70, 302, 870, 302); g.drawLine(70, 322, 870, 322); g.drawLine(70, 342, 870, 342);
        //g.drawLine(70, 362, 870, 362);
        
        //Lineas Verticales
        //g.drawLine(95, 62, 95, 381); g.drawLine(120, 62, 120, 381); g.drawLine(145, 62, 145, 381);
        //g.drawLine(170, 62, 170, 381); g.drawLine(195, 62, 195, 381); g.drawLine(220, 62, 220, 381);
        //g.drawLine(245, 62, 245, 381); g.drawLine(270, 62, 270, 381); g.drawLine(295, 62, 295, 381);
        //g.drawLine(320, 62, 320, 381); g.drawLine(345, 62, 345, 381); g.drawLine(370, 62, 370, 381);
        //g.drawLine(395, 62, 395, 381); g.drawLine(420, 62, 420, 381); g.drawLine(445, 62, 445, 381);
        //g.drawLine(470, 62, 470, 381); g.drawLine(495, 62, 495, 381); g.drawLine(520, 62, 520, 381);
        //g.drawLine(545, 62, 545, 381); g.drawLine(570, 62, 570, 381); g.drawLine(595, 62, 595, 381);
        //g.drawLine(620, 62, 620, 381); g.drawLine(645, 62, 645, 381); g.drawLine(670, 62, 670, 381);
        //g.drawLine(695, 62, 695, 381); g.drawLine(720, 62, 720, 381); g.drawLine(745, 62, 745, 381);
        //g.drawLine(770, 62, 770, 381); g.drawLine(795, 62, 795, 381); g.drawLine(820, 62, 820, 381);
        //g.drawLine(845, 62, 845, 381);
        
        //No se usa
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(20, 20));
        setName("miFrame"); // NOI18N

        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("PJ1"));
        panel1.setToolTipText("Personaje1");
        panel1.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane1MousePressed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1056, 530));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(290, 290, 290)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(386, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MousePressed
        System.out.println("Pulsado:" + jPanel1.getMousePosition().toString() + " - " 
                + jPanel1.getMousePosition().x + ":" + jPanel1.getMousePosition().y);
        posMapaX = jPanel1.getMousePosition().x/33;
        posMapaY = jPanel1.getMousePosition().y/33;
        System.out.println("Casilla: "+ posMapaX + "," + posMapaY);
                //.getMousePosition().toString());
                
        System.out.println("Label 0,0 está en: " + casillasMapa[0][0].getLocation().toString());
        //Cambiamos de color la casilla marcada
        limpiarMapa();
        casillasMapa[posMapaX][posMapaY].setBackground(Color.CYAN);
    }//GEN-LAST:event_jScrollPane1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables

    public void inicializarMapa() {
    
        for(int x=0;x<32;x++) {
            for(int y=0;y<16;y++) {
                casillasMapa[x][y] = new JLabel("Label"+x+""+y);
                casillasMapa[x][y].setHorizontalAlignment(CENTER);
                casillasMapa[x][y].setForeground(Color.RED);
                casillasMapa[x][y].setOpaque(true);
                casillasMapa[x][y].setBackground(Color.LIGHT_GRAY);
                //casillasMapa[x][y].setBorder();
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
    
    public void rellenarMapa() {
    
        for(int x=0;x<32;x++) {
            for(int y=0;y<16;y++) {
                //casillasMapa[x][y] = null;
                casillasMapa[x][y].setText(""+x+""+y);
                casillasMapa[x][y].setSize(32, 32);
                casillasMapa[x][y].setLocation(x+(32*x), y+(32*y));
                
                
                
                //Añadimos las casillas al mapa-jPanel1
                jPanel1.add(casillasMapa[x][y]);
            }
        }
        
        
    }

}
