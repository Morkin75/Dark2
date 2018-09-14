/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dark;

import static dark.Dark.ventanaInicio;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
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
    //public JLabel[][] casillasMapaGraficosPJ;
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
    Acciones panelObjetos;
    
    //Creamos un objeto del Mapa
    Mapa mapaFondo;
    //Creamos otro mapa para los PJs
    Mapa mapaPJs;
    //Creamos el mapa de los objetos
    Mapa mapaObjetos;
    //Creamos el mapa con los caminos
    Mapa mapaCaminos;
    
    //Graphics cuadrado = null;
    BufferedImage cuadrado;
    
    //Creamos El modelo de la tabla de Acciones
    DefaultTableModel acciones = new DefaultTableModel();
    
    //El modelo de la tabla de los Personajes
    DefaultTableModel personajes = new DefaultTableModel();
    
    //El modelo de la tabla de los Objetos
    DefaultTableModel objetos = new DefaultTableModel();
    
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
        
        //Creamos el objeto del panel objeto
        panelObjetos = new Acciones();
        this.add(panelObjetos);
        panelObjetos.setBounds(602, 392, 400, 234);
        panelObjetos.setVisible(false);
        
        //Creamos el objeto del Mapa
        mapaFondo = new Mapa();
        mapaFondo.setBounds(1, 1, 1056, 530);
        mapaFondo.setVisible(true);
        mapaFondo.inicializarMapaConTextoLabel();//Inicializamos
        mapaFondo.rellenarMapa(); //Rellenamos con las coordenadas
        this.jLayeredPane1.add(mapaFondo, new Integer(1));
        
        //Creamos el mapa con los caminos
        mapaCaminos = new Mapa();
        mapaCaminos.setBounds(1, 1, 1056, 530);
        mapaCaminos.inicializarMapaVacio();
        mapaCaminos.setVisible(true);
        mapaCaminos.rellenarMapaSinCoordenadas();
        mapaCaminos.inicializaCaminos();
        this.jLayeredPane1.add(mapaCaminos, new Integer(2));
        
        //Creamos el objeto del Mapa con los PJs
        mapaPJs = new Mapa();
        mapaPJs.setBounds(1, 1, 1056, 530);
        mapaPJs.inicializarMapaVacio();
        mapaPJs.setVisible(true);
        mapaPJs.rellenarMapaSinCoordenadas();
        
        this.jLayeredPane1.add(mapaPJs, new Integer(3));
        
        //Creamos el objeto del Mapa de los Objetos
        mapaObjetos = new Mapa();
        mapaObjetos.setBounds(1, 1, 1056, 530);
        mapaObjetos.inicializarMapaVacio();
        mapaObjetos.setVisible(true);
        mapaObjetos.rellenarMapaSinCoordenadas();
        this.jLayeredPane1.add(mapaObjetos, new Integer(4));
        //this.getContentPane().add(mapaObjetos, 2);
        
        
        
        
        //Casilla seleccionada del mapa
        posMapaX = 0;
        posMapaY = 0;
        
        //Inicializamos el separador. MEJORAR
        separador3 = new JSeparator();
        
        
        //cuadrado = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        
        //Creamos el mapa
        //casillasMapa = new JLabel[32][16];
        //casillasMapaGraficosPJ = new JLabel[32][16];
        //Inicializamos los JLabel
        //inicializarMapa();
        //Rellenamos los JLabel
        //rellenarMapa();
        //rellenarMapaPJ();
        
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
        
        //Preparamos el modelo de la tabla de Objetos
        objetos.addColumn("Nombre");
        objetos.addColumn("Descripción");
        
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
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
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dark Sceptre");
        setLocation(new java.awt.Point(20, 20));
        setLocationByPlatform(true);
        setName("miFrame"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollMapaMousePressed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1056, 530));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentMoved(evt);
            }
        });

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1056, 530));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jTable4.setModel(objetos);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable4MousePressed(evt);
            }
        });
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

        jToggleButton1.setSelected(true);
        jToggleButton1.setText("Personajes");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setSelected(true);
        jToggleButton2.setText("Objetos");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Mostrar Ordenes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(591, 591, 591)
                                .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 300, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(separador1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2)))
                .addGap(25, 25, 25)
                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                
        System.out.println("Label 0,0 está en: " + mapaFondo.casillasMapa[0][0].getLocation().toString());
        //Cambiamos de color la casilla marcada
        mapaFondo.limpiarMapa();
        mapaFondo.casillasMapa[posMapaX][posMapaY].setBackground(Color.CYAN);
        
        //Al presionar ratón, guardamos la posición del mismo
        //desplazarX = evt.getX();
        //desplazarY = evt.getY();
        
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
        //Dark.con.archivoRuta = abre; //ESTE
        //Dark.con.connect(); //ESTE
        //Dark.con.mostrarAcciones(); //ESTE
        //ventanaInicio.ordenes.cargarMenu(); //ESTE
        //ventanaInicio.ordenes.cargarMenuEscogerLugar(); //ESTA
        //ventanaInicio.ordenes.jComboBox1_1.setVisible(false); //ESTA
        //Dark.con.mostrarPersonajes(); //ESTE
        //Dark.con.mostrarObjetos();  //ESTA
        //ventanaInicio.mostrarPJs();  //ESTA
        //ventanaInicio.mostrarObjetos();  //ESTA
        //Dark.con.close(); //ESTE
        //IR A LA CLASE CONECTOR Y DESCOMENTAR LA ULTIMA LINEA PARA QUE LEA LA RUTA
        //Hasta aquí
    }//GEN-LAST:event_jMenuItem1MousePressed

    //Evento que se produce cuando se cambia de pestaña en el panel de personajes, objetos, etc...
    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        System.out.println("S:" + jTabbedPane1.getSelectedIndex());
        try {
            
            switch(jTabbedPane1.getSelectedIndex()) {
                case 0:
                    //this.jScrollInfo.setVisible(false);
                    panelAcciones.setVisible(false);
                    panelObjetos.setVisible(false);
                    ordenes.setVisible(true);
                    System.out.println("Pasa por pestaña 0");
                    break;
                case 2:
                    //this.jScrollInfo.setVisible(false);
                    panelAcciones.setVisible(false);
                    panelObjetos.setVisible(true);
                    ordenes.setVisible(false);
                    System.out.println("Pasa por pestaña 2");
                    break;
                case 3:
                    //this.jScrollInfo.setVisible(true);
                    panelAcciones.setVisible(true);
                    panelObjetos.setVisible(false);
                    ordenes.setVisible(false);
                    System.out.println("Pasa por pestaña 3");
                    break;
                default:
                    //this.jScrollInfo.setVisible(false);
                    panelAcciones.setVisible(false);
                    panelObjetos.setVisible(false);
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
        //ESTO ES PARA LA PESTAÑA 1
        if(ordenesPJ.get(PJ).accion1 < 0) { // Si la accion es menor que 0 significa que todavía no se ha indicado la accion de ese PJ
            Dark.ventanaInicio.ordenes.jComboBox1.setSelectedIndex(0); //Ponemos siempre la primera accion
            Dark.ventanaInicio.ordenes.jComboBox1.setEnabled(true); //Combo y boton aceptar actiado
            Dark.ventanaInicio.ordenes.jButtonOrdenar1.setEnabled(true); //Boton Aceptar Activado
            Dark.ventanaInicio.ordenes.jButtonCancelar1.setEnabled(false);//Boton desactivado
            System.out.println("Desde la ventana de inicio: " + ordenesPJ.get(PJ).accion1);
        } else { //Si entramos aquí es porque el PJ ya tiene acción adjudicada
            Dark.ventanaInicio.ordenes.jComboBox1.setEnabled(false); //Se anula el botón
            System.out.println("Desde la ventana de inicio P1: " + ordenesPJ.get(PJ).accion1);
            //Recuperamos la acción de ese PJ poniendola en el combobox
            int accion = ordenesPJ.get(PJ).accion1;
            Dark.ventanaInicio.ordenes.jComboBox1.setSelectedIndex(accion);
            //Ponemos botones en orden
            Dark.ventanaInicio.ordenes.jButtonOrdenar1.setEnabled(false); //Boton Aceptar Activado
            Dark.ventanaInicio.ordenes.jButtonCancelar1.setEnabled(true);//Boton desactivado
        }
        //ESTO ES PARA LA PESTAÑA 2
        if(ordenesPJ.get(PJ).accion2 < 0) { // Si la accion es menor que 0 significa que todavía no se ha indicado la accion de ese PJ
            Dark.ventanaInicio.ordenes.jComboBox2.setSelectedIndex(0); //Ponemos siempre la primera accion
            Dark.ventanaInicio.ordenes.jComboBox2.setEnabled(true); //Combo y boton aceptar actiado
            Dark.ventanaInicio.ordenes.jButtonOrdenar2.setEnabled(true); //Boton Aceptar Activado
            Dark.ventanaInicio.ordenes.jButtonCancelar2.setEnabled(false);//Boton desactivado
            System.out.println("Desde la ventana de inicio: " + ordenesPJ.get(PJ).accion2);
        } else { //Si entramos aquí es porque el PJ ya tiene acción adjudicada
            Dark.ventanaInicio.ordenes.jComboBox2.setEnabled(false); //Se anula el botón
            System.out.println("Desde la ventana de inicio P2: " + ordenesPJ.get(PJ).accion2);
            //Recuperamos la acción de ese PJ poniendola en el combobox
            int accion = ordenesPJ.get(PJ).accion2;
            Dark.ventanaInicio.ordenes.jComboBox2.setSelectedIndex(accion);
            //Ponemos botones en orden
            Dark.ventanaInicio.ordenes.jButtonOrdenar2.setEnabled(false); //Boton Aceptar Activado
            Dark.ventanaInicio.ordenes.jButtonCancelar2.setEnabled(true);//Boton desactivado
        }
        //ESTO ES PARA LA PESTAÑA 3
        if(ordenesPJ.get(PJ).accion3 < 0) { // Si la accion es menor que 0 significa que todavía no se ha indicado la accion de ese PJ
            Dark.ventanaInicio.ordenes.jComboBox3.setSelectedIndex(0); //Ponemos siempre la primera accion
            Dark.ventanaInicio.ordenes.jComboBox3.setEnabled(true); //Combo y boton aceptar actiado
            Dark.ventanaInicio.ordenes.jButtonOrdenar3.setEnabled(true); //Boton Aceptar Activado
            Dark.ventanaInicio.ordenes.jButtonCancelar3.setEnabled(false);//Boton desactivado
            System.out.println("Desde la ventana de inicio P3: " + ordenesPJ.get(PJ).accion3);
        } else { //Si entramos aquí es porque el PJ ya tiene acción adjudicada
            Dark.ventanaInicio.ordenes.jComboBox3.setEnabled(false); //Se anula el botón
            System.out.println("Desde la ventana de inicio: " + ordenesPJ.get(PJ).accion3);
            //Recuperamos la acción de ese PJ poniendola en el combobox
            int accion = ordenesPJ.get(PJ).accion3;
            Dark.ventanaInicio.ordenes.jComboBox3.setSelectedIndex(accion);
            //Ponemos botones en orden
            Dark.ventanaInicio.ordenes.jButtonOrdenar3.setEnabled(false); //Boton Aceptar Activado
            Dark.ventanaInicio.ordenes.jButtonCancelar3.setEnabled(true);//Boton desactivado
        }
        
        //Preguntamos la acción para actuar en consecuencia
        
        
        
        //Creamos el Borde
        Border border = LineBorder.createBlackLineBorder();
        
        //Seleccionamos el PJ en el mapa
        int coordenadaX = 0;
        int coordenadaY = 0;
        String coordenadas = (String) this.jTable2.getValueAt(PJ, 1);
        //Dividimos el campo de localización para quedarnos con las coordenadas por separado
        String[] partes = coordenadas.split("-");
        String parte1 = partes[0]; 
        String parte2 = partes[1]; 
        coordenadaX = Integer.valueOf(parte1);
        coordenadaY = Integer.valueOf(parte2);
        //Obtenemos la casilla del mapa perteneciente al personaje pulsado
        posMapaX = coordenadaX;
        posMapaY = coordenadaY;
        System.out.println("Personaje enmarcado: " + PJ);
        //Dibujamos en el mapa el PJ seleccionado
        mapaPJs.limpiarBordesMapa();
        
        //mapaFondo.casillasMapa[posMapaX][posMapaY].setBackground(Color.CYAN);
        mapaPJs.casillasMapa[posMapaX][posMapaY].setBorder(border);
        
        
    }//GEN-LAST:event_jTable2MousePressed

    private void jPanel1ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentMoved
        //Este evento se produce cuando se mueve el mapa con las barras despl.
        //System.out.println("SE MUEVE!!");
        mostrarPJs();
        mostrarObjetos();
        
    }//GEN-LAST:event_jPanel1ComponentMoved

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if(jToggleButton1.isSelected()) {
            mapaPJs.setVisible(true); 
        } else {
            mapaPJs.setVisible(false);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if(jToggleButton2.isSelected()) {
            mapaObjetos.setVisible(true); 
        } else {
            mapaObjetos.setVisible(false);
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        for(int x=0; x<20; x++) {
            System.out.println("Cerramos: " + ordenesPJ.get(x));
            //ordenesPJ.add(new EnviarOrdenes(-1, -1, -1, -1));
        }
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String mensaje = new String("");
        
        for(int x=0; x<20; x++) {
            System.out.println("Personaje:" + x + ": " + ordenesPJ.get(x).accion1
                                                + " " + ordenesPJ.get(x).accion2
                                                + " " + ordenesPJ.get(x).accion3);
            
            
            mensaje = mensaje + "Personaje" + x + ":   " + ordenesPJ.get(x).accion1
                                       + "   " + ordenesPJ.get(x).accion2
                                       + "   " + ordenesPJ.get(x).accion3 + "\n";
            
        }
        JOptionPane.showConfirmDialog(null, 
                    mensaje, "Comprobación", 
                                     JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MousePressed
        System.out.println(" " + jTable4.getSelectedRow());
        Dark.ventanaInicio.panelObjetos.jTextInfo.setText(" " + String.valueOf(objetos.getValueAt(jTable4.getSelectedRow(), 1)));        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JLayeredPane jLayeredPane1;
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

    
    
    
    
    
    
    
    
    public void mostrarPJs() {
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
        
            //Ponemos un color
            //mapafondo.casillasMapa[coordenadaX][coordenadaY].setBackground(new Color(255,255,255,100));
            
            //Indicamos el archivo del PJ
            String rutaImagenes = "/images/iconPJ01.png";
            java.net.URL url = this.getClass().getResource(rutaImagenes);
            //Cargamos el gráfico
            ImageIcon icon = new ImageIcon(url);
            //System.out.println("Coordx: " + coordenadaX);
            
            //Dibujamos el gráfico en el mapa
            mapaPJs.casillasMapa[coordenadaX][coordenadaY].setIcon(icon);
        }
    }
    
    public void mostrarObjetos() {
        int coordenadaX = 0;
        int coordenadaY = 0;
        
        for(int x=0; x<20; x++) {
            String coordenadas = (String) this.jTable2.getValueAt(x, 1);
            //Dividimos el campo de localización para quedarnos con las coordenadas por separado
            String[] partes = coordenadas.split("-");
            String parte1 = partes[0]; 
            String parte2 = partes[1]; 
            coordenadaX = Integer.valueOf(parte1) + 1;
            coordenadaY = Integer.valueOf(parte2);
        
            //Ponemos un color
            //mapafondo.casillasMapa[coordenadaX][coordenadaY].setBackground(new Color(255,255,255,100));
            
            //Indicamos el archivo del PJ
            String rutaImagenes = "/images/iconESPA.png";
            java.net.URL url = this.getClass().getResource(rutaImagenes);
            //Cargamos el gráfico
            ImageIcon icon = new ImageIcon(url);
            //System.out.println("Coord2x: " + coordenadaX);
            
            //Dibujamos el gráfico en el mapa
            mapaObjetos.casillasMapa[coordenadaX][coordenadaY].setIcon(icon);
        }
    }
    

}
