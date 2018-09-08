/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dark;

import static dark.Dark.ventanaInicio;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author manueljesusgarcialopez
 */
public class VentanaInicio extends javax.swing.JFrame {

    //Vemos alto y ancho de la pantalla
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
    //Variable que almacena el PJ seleccionado en la tabla de personajes
    public int PJ;
    
    //Array de casillas del mapa
    public JLabel[][] casillasMapa;
    public JSeparator separador3;
    
    //Creamos un array para almacenar las ordenes de los personajes
    //public EnviarOrdenes[] ordenesPJ;
    public ArrayList<EnviarOrdenes> ordenesPJ = new ArrayList<>();
    
    
    //Objeto para saber la ruta del archivo de la BBDD
    public File abre;
    
    //Creamos un objeto del panel de Ordenes
    Ordenes ordenes;
    
    //Creamos un objeto del panel de Acciones
    Acciones panelAcciones;
    
    //Graphics cuadrado = null;
    BufferedImage cuadrado;
    
    //Creamos El modelo de la tabla de Acciones
    DefaultTableModel acciones = new DefaultTableModel();
    
    //El modelo de la tabla de los Personajes
    DefaultTableModel personajes = new DefaultTableModel();
    
    //Coordenadas donde hemos pulsado para ver la casilla del mapa
    int posMapaX, posMapaY;
    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
        initComponents();
        this.setBounds((ancho/2) - (this.getWidth()/2), (alto/2) - (this.getHeight()/2), 1024, 768);
        
        //Creamos un objeto del panel de Ordenes
        ordenes = new Ordenes();
        //Añadimos el objeto a este formulario
        this.add(ordenes);
        //Establecemos el tamaño y posición del objeto, y lo hacemos visible
        ordenes.setBounds(602, 392, 400, 234);
        ordenes.setVisible(true);

        //Creamos el objeto del panel acciones
        panelAcciones = new Acciones();
        //Añadimos el objeto al formulario
        this.add(panelAcciones);
        panelAcciones.setBounds(602, 392, 400, 234);
        panelAcciones.setVisible(false);
        
        //Casilla seleccionada del mapa
        posMapaX = 0;
        posMapaY = 0;
        
        //Inicializamos el separador. MEJORAR
        separador3 = new JSeparator();
        
        //cuadrado = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        
        //Creamos el mapa
        casillasMapa = new JLabel[32][16];
        //Inicializamos los JLabel
        inicializarMapa();
        //Rellenamos los JLabel
        rellenarMapa();
        
        //Indicamos el color del separador
        separador1.setBackground(Color.BLUE);
        separador2.setOpaque(true);
        separador2.setBackground(Color.BLUE);
        separador2.setOrientation(SwingConstants.VERTICAL);
        
        separador2.setSize(12, 255);
        separador2.setLocation(606, 400);
        
        //Preparamos el modelo de la tabla de Acciones
        acciones.addColumn("Número");
        acciones.addColumn("Acción");
        acciones.addColumn("Descripción");
        
        //Preparamos el modelo de la tabla de Personajes
        //personajes.addColumn("ID");
        personajes.addColumn("Nombre");
        personajes.addColumn("Localización");
        personajes.addColumn("Rango");
        personajes.addColumn("Fuerza");
        personajes.addColumn("Velocidad");
        personajes.addColumn("Energía");
        personajes.addColumn("Agilidad");
        personajes.addColumn("Magia");
        personajes.addColumn("Vida");
        personajes.addColumn("Oro");
        
        //Vamos a centrar o justificar las diferentes columnas
        //Creamos un objeto de renderizado de tabla para poder centrar
        DefaultTableCellRenderer tcrL = new DefaultTableCellRenderer();
        //Ponemos la alineación horizontal a la izquierda para la columna o
        tcrL.setHorizontalAlignment(SwingConstants.LEFT);
        jTable2.getColumnModel().getColumn(0).setCellRenderer(tcrL);
        DefaultTableCellRenderer tcrC = new DefaultTableCellRenderer();
        //Centramos para la columna 1
        tcrC.setHorizontalAlignment(SwingConstants.CENTER);
        jTable2.getColumnModel().getColumn(1).setCellRenderer(tcrC);
        DefaultTableCellRenderer tcrR = new DefaultTableCellRenderer();
        //A la derecha para el resto de tablas
        tcrR.setHorizontalAlignment(SwingConstants.RIGHT);
        for(int x=2; x<10; x++)
            jTable2.getColumnModel().getColumn(x).setCellRenderer(tcrR);
        
        //Vamos con el ancho de las columnas
        TableColumn columna1 = jTable2.getColumn("Nombre");
        columna1.setPreferredWidth(100);
        
        
        //Este panel se muestra cuando estamos en las pestañas de acciones o...
        //this.jScrollInfo.setVisible(true);
        
        //Creamos el array de objetos con las acciones
        for(int x=0; x<20; x++) {
            ordenesPJ.add(new EnviarOrdenes(-1, -1, -1, -1));
        }
        
        //inicializamos el array de las órdenes a enviar
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollMapa = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        separador1 = new javax.swing.JSeparator();
        separador2 = new javax.swing.JSeparator();
        jScrollJuego = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(20, 20));
        setName("miFrame"); // NOI18N

        jScrollMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollMapaMousePressed(evt);
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

        jScrollMapa.setViewportView(jPanel1);

        separador1.setOpaque(true);

        separador2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jScrollJuego.setName("jScrollJuego"); // NOI18N

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setName("Componentes");
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(475, 200));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(personajes);
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable2MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Personajes", jScrollPane2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jTabbedPane1.addTab("Dominios", jScrollPane3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jTabbedPane1.addTab("Objetos", jScrollPane4);

        jTable5.setModel(acciones);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable5MousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jTabbedPane1.addTab("Acciones", jScrollPane5);

        jScrollJuego.setViewportView(jTabbedPane1);
        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        jToggleButton1.setText("Ver Objetos");

        jToggleButton2.setText("Ver Enemigos");

        jMenu1.setText("File");

        jMenuItem1.setText("Cargar (Load)");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Guardar (Save)");
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        jMenuItem3.setText("Salir (Exit)");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separador1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(288, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2)))
                .addGap(31, 31, 31)
                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 438, Short.MAX_VALUE)
                        .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento que se dispara cuando seleccionamos las casillas del mapa
    private void jScrollMapaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollMapaMousePressed
        System.out.println("Pulsado:" + jPanel1.getMousePosition().toString() + " - " 
                + jPanel1.getMousePosition().x + ":" + jPanel1.getMousePosition().y);
        //Obtenemos la casilla del mapa pulsada
        posMapaX = jPanel1.getMousePosition().x/33;
        posMapaY = jPanel1.getMousePosition().y/33;
        System.out.println("Casilla: "+ posMapaX + "," + posMapaY);
                
        System.out.println("Label 0,0 está en: " + casillasMapa[0][0].getLocation().toString());
        //Cambiamos de color la casilla marcada
        limpiarMapa();
        casillasMapa[posMapaX][posMapaY].setBackground(Color.CYAN);
    }//GEN-LAST:event_jScrollMapaMousePressed

    private void jTable5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MousePressed
        System.out.println(" " + jTable5.getSelectedRow());
        Dark.ventanaInicio.panelAcciones.jTextInfo.setText(" " + String.valueOf(acciones.getValueAt(jTable5.getSelectedRow(), 2)));
    }//GEN-LAST:event_jTable5MousePressed

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        System.out.println("Quieres abrir el archivo");
        /**llamamos el metodo que permite cargar la ventana*/
        JFileChooser file=new JFileChooser();
        file.showOpenDialog(this);
        /**abrimos el archivo seleccionado*/
        abre = file.getSelectedFile();
        //A ver la ruta:
        System.out.println(abre.getPath());
        //Comentar esto cuando queramos abrir la BBDD directamente:
        //Dark.con.archivoRuta = abre;
        //Dark.con.connect();
        //Dark.con.mostrarAcciones();
        //ventanaInicio.ordenes.cargarMenu();
        //Dark.con.mostrarPersonajes();
        //Dark.con.close();
        //Hasta aquí
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        System.out.println("S:" + jTabbedPane1.getSelectedIndex());
        try {
            
            switch(jTabbedPane1.getSelectedIndex()) {
                case 0:
                    //this.jScrollInfo.setVisible(false);
                    panelAcciones.setVisible(false);
                    ordenes.setVisible(true);
                    System.out.println("Pasa por pestaña 0");
                    break;
                case 3:
                    //this.jScrollInfo.setVisible(true);
                    panelAcciones.setVisible(true);
                    ordenes.setVisible(false);
                    System.out.println("Pasa por pestaña 3");
                    break;
                default:
                    //this.jScrollInfo.setVisible(false);
                    panelAcciones.setVisible(false);
                    ordenes.setVisible(false);
                    System.out.println("NO Pasa por aqui"); 
                    break;
            }
            
            //System.out.println("Componentes: "+jTable5.getValueAt(1, 2));
        } catch (NullPointerException ex) { //Excepcion porque al ser un evento, Java piensa que el objeto puede ser nulo
            System.out.println("dark.VentanaInicio.jTabbedPane1StateChanged()");
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
        //Vamos a ver qué PJ hemos seleccionado
        PJ = jTable2.getSelectedRow();
        System.out.println("PJ: " + PJ);
        //Indicamos el PJ al cual le vamos a dar las órdenes
        ventanaInicio.ordenes.jLabel4.setText(jTable2.getValueAt(PJ, 0).toString());
        ventanaInicio.ordenes.jLabel5.setText(jTable2.getValueAt(PJ, 0).toString());
        ventanaInicio.ordenes.jLabel6.setText(jTable2.getValueAt(PJ, 0).toString());
        ventanaInicio.ordenes.jLabel7.setText(jTable2.getValueAt(PJ, 0).toString());
        
        //Si seleccionamos un Thrall, anulamos las acciones dos y tres
        String textoSeleccionado = (String) jTable2.getValueAt(PJ, 2);
        if(textoSeleccionado.equals("Thrall")) { //Desactivamos y cambiamos de color
            ventanaInicio.ordenes.jTabbedPane1.setEnabledAt(1, false);
            ventanaInicio.ordenes.jTabbedPane1.setBackgroundAt(1, Color.darkGray);
            ventanaInicio.ordenes.jTabbedPane1.setEnabledAt(2, false);
            ventanaInicio.ordenes.jTabbedPane1.setBackgroundAt(2, Color.darkGray);
            ventanaInicio.ordenes.jTabbedPane1.setSelectedIndex(0); //Vamos a la primera pestaña
        } else {
            ventanaInicio.ordenes.jTabbedPane1.setEnabledAt(1, true);
            ventanaInicio.ordenes.jTabbedPane1.setBackgroundAt(1, Color.white);
            ventanaInicio.ordenes.jTabbedPane1.setEnabledAt(2, true);
            ventanaInicio.ordenes.jTabbedPane1.setBackgroundAt(2, Color.white);
        }
        //Cada vez que seleccionamos un personaje, tenemos que ver si tiene las órdenes
        //Empezamos a trabajar aquí con el objeto-lista que almacenas las órdenes de cada PJ
        //Preguntamos por el PJ seleccionado para anular el combobox o no
        if(ordenesPJ.get(PJ).accion1 < 0) { // Si la accion es menor que 0 significa que todavía no se ha indicado la accion de ese PJ
            Dark.ventanaInicio.ordenes.jComboBox1.setSelectedIndex(0); //Ponemos siempre la primera accion
            Dark.ventanaInicio.ordenes.jComboBox1.setEnabled(true); //Combo y boton aceptar actiado
            Dark.ventanaInicio.ordenes.jButtonOrdenar1.setEnabled(true); //Boton Aceptar Activado
            Dark.ventanaInicio.ordenes.jButtonCancelar1.setEnabled(false);//Boton desactivado
            System.out.println("Desde la ventana de inicio: " + ordenesPJ.get(PJ).accion1);
        } else { //Si entramos aquí es porque el PJ ya tiene acción adjudicada
            Dark.ventanaInicio.ordenes.jComboBox1.setEnabled(false); //Se anula el botón
            System.out.println("Desde la ventana de inicio: " + ordenesPJ.get(PJ).accion1);
            //Recuperamos la acción de ese PJ poniendola en el combobox
            int accion = ordenesPJ.get(PJ).accion1;
            Dark.ventanaInicio.ordenes.jComboBox1.setSelectedIndex(accion);
            //Ponemos botones en orden
            Dark.ventanaInicio.ordenes.jButtonOrdenar1.setEnabled(false); //Boton Aceptar Activado
            Dark.ventanaInicio.ordenes.jButtonCancelar1.setEnabled(true);//Boton desactivado
        }
    }//GEN-LAST:event_jTable2MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JMenuItem jMenuItem3;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollJuego;
    public javax.swing.JScrollPane jScrollMapa;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JPopupMenu.Separator jSeparator1;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTable2;
    public javax.swing.JTable jTable3;
    public javax.swing.JTable jTable4;
    public javax.swing.JTable jTable5;
    public javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JToggleButton jToggleButton2;
    public javax.swing.JSeparator separador1;
    public javax.swing.JSeparator separador2;
    // End of variables declaration//GEN-END:variables

    public void inicializarMapa() {
    
        for(int x=0;x<32;x++) {
            for(int y=0;y<16;y++) {
                casillasMapa[x][y] = new JLabel("Label"+x+""+y);
                casillasMapa[x][y].setHorizontalAlignment(CENTER);
                casillasMapa[x][y].setForeground(Color.RED);
                casillasMapa[x][y].setOpaque(true);
                casillasMapa[x][y].setBackground(Color.LIGHT_GRAY);//
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
    
    public void seleccionarCasillasConPJs() {
        int coordenadaX = 0;
        int coordenadaY = 0;
        
        for(int x=0; x<20; x++) {
            String coordenadas = (String) this.jTable2.getValueAt(x, 1);
            //Dividimos el campo de localización para quedarnos con las coordenadas por separado
            String[] partes = coordenadas.split("-");
            String parte1 = partes[0]; 
            String parte2 = partes[1]; 
            coordenadaX = Integer.valueOf(parte1);
            coordenadaY = Integer.valueOf(parte2);
        
            casillasMapa[coordenadaX][coordenadaY].setBackground(Color.white);
        }
    }

}
