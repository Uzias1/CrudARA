/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Control.Consultas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author 
 */
public class PMenu extends JPanel{
    //Fuentes
    Font tit = new Font("Impact", Font.PLAIN, 80);
    Font fec = new Font("Impact", Font.PLAIN, 50);
    Font txt = new Font("Arial Narrow", Font.PLAIN, 30);
    Font txt2 = new Font("Arial Narrow", Font.PLAIN, 20);
    //Colores
    Color blanco = new Color(239,235,224);
    Color rosa = new Color(251,141,160);
    Color rosaFuerte = new Color(251,107,144);
    Color fucsia = new Color(251,69,112);
    Color negro = new Color(0,0,0);
    
    //Boton de ejecutar
    JButton ejecutar = new JButton("Seleccionar");
    
    //Cuadros de texto para cada atributo
    JTextPane aa1 = new JTextPane();
    JTextPane aa2 = new JTextPane();
    JTextPane aa3 = new JTextPane();
    JTextPane aa4 = new JTextPane();
    JTextPane aa5 = new JTextPane();
    JTextPane aa6 = new JTextPane();
    JTextPane aa7 = new JTextPane();
    JTextPane aa8 = new JTextPane();
    JTextPane aa9 = new JTextPane();
    JTextPane aa0 = new JTextPane();
    public PMenu(){
        //llamada a los componentes, con el fin de mejor organizacion
        Componentes();
        //dimensiones de ventana
        this.setPreferredSize(new Dimension(900, 700));
        this.setLayout(null);
    }
    
    //Para los colores del fondo es mas facil hacer una imagen que diseñar labels 
    @Override
    public void paintComponent(Graphics g){
        Dimension tamanio = getSize();
        ImageIcon fondo = new ImageIcon(getClass().getResource("/img/fondo.png"));
        g.drawImage(fondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
    
    private void Componentes() {
        //Boolean para indicar la conexion con la bd
        boolean conexion = true;
        ejecutar.setEnabled(false);
        JLabel logo = new JLabel(new ImageIcon(getClass().getResource("/img/chiquito.png")));
        logo.setBounds(310,10,300,80);   //Posicion en x, Posicion en y, tamaño en X, tamaño en Y
        this.add(logo);
        
        JLabel titulo = new JLabel("  BD GUI");
        titulo.setFont(tit);
        titulo.setForeground(blanco);
        titulo.setBounds(610,10,290,80);
        this.add(titulo);
        
        JLabel menu = new JLabel("Menu");
        menu.setFont(tit);
        menu.setForeground(blanco);
        menu.setBounds(50,10,200,80);
        this.add(menu);
        
        JLabel ins = new JLabel("Por favor seleccione una opcion del menu de la izquierda");
        ins.setFont(txt2);
        ins.setForeground(negro);
        ins.setBounds(375,350,450,20);
        this.add(ins);
        
        //Instrucciones que estarán ocultas hasta elegir una opcion
        JLabel inst = new JLabel();
        inst.setFont(txt);
        inst.setForeground(negro);
        inst.setBounds(310,100,590,70);
        this.add(inst);
        
        //Obtener un arreglo con el numero de tablas posibles
        Consultas con = new Consultas();
        int n = con.obtenerTablas();
        if(n == -1){
            conexion = false;
        }
        String[] tablas = new String[n];
        tablas = con.obtenerTablasName();
        //Seleccionador para el numero de Tablas posibles a elegir
        JComboBox combo = new JComboBox<>(tablas);
        combo.setFont(txt);
        combo.setBackground(rosaFuerte);
        combo.setBounds(310,180,200,50);
        combo.setVisible(false);
        this.add(combo);
        
        //Confirmador de tabla elegida
        JLabel tabla = new JLabel("La tabla que ha elegido es: ");
        tabla.setFont(txt2);
        tabla.setForeground(negro);
        tabla.setBounds(520,180,590,50);
        tabla.setVisible(false);
        this.add(tabla);
        
        //Seleccionador de crud escondido
        JLabel cr = new JLabel("nada");
        this.add(cr);
        
        //Objetos que serán ocultados dependiendo del caso
        JLabel pk = new JLabel("Ingrese la PK del registro a modificar: "); //PK para abreviar y que alcance el espacio
        pk.setFont(txt);
        pk.setForeground(negro);
        pk.setBounds(310,240,470,50);
        pk.setVisible(false);
        this.add(pk);
        
        //Cuadro de texto
        JTextPane primary = new JTextPane();
        primary.setFont(txt);
        primary.setBounds(730,240,150,50);
        primary.setVisible(false);
        this.add(primary);
        
        //Mostrar atributos 
        JLabel att = new JLabel("Ingrese los atributos correspondientes:");
        att.setFont(txt);
        att.setForeground(negro);
        att.setBounds(310,300,470,50);
        att.setVisible(false);
        this.add(att);
        
        //Etiquetas para los 10 atributos maximos posibles
        JLabel a1 = new JLabel("Att 1:");
        JLabel a2 = new JLabel("Att 2:");
        JLabel a3 = new JLabel("Att 3:");
        JLabel a4 = new JLabel("Att 4:");
        JLabel a5 = new JLabel("Att 5:");
        JLabel a6 = new JLabel("Att 6:");
        JLabel a7 = new JLabel("Att 7:");
        JLabel a8 = new JLabel("Att 8:");
        JLabel a9 = new JLabel("Att 9:");
        JLabel a0 = new JLabel("Att 10:");
        
        a1.setFont(txt);
        a2.setFont(txt);
        a3.setFont(txt);
        a4.setFont(txt);
        a5.setFont(txt);
        a6.setFont(txt);
        a7.setFont(txt);
        a8.setFont(txt);
        a9.setFont(txt);
        a0.setFont(txt);
        
        a1.setForeground(negro);
        a2.setForeground(negro);
        a3.setForeground(negro);
        a4.setForeground(negro);
        a5.setForeground(negro);
        a6.setForeground(negro);
        a7.setForeground(negro);
        a8.setForeground(negro);
        a9.setForeground(negro);
        a0.setForeground(negro);
        
        a1.setBounds(310, 370, 80, 50);
        a2.setBounds(310, 420, 80, 50);
        a3.setBounds(310, 470, 80, 50);
        a4.setBounds(310, 520, 80, 50);
        a5.setBounds(310, 570, 80, 50);
        a6.setBounds(610, 370, 80, 50);
        a7.setBounds(610, 420, 80, 50);
        a8.setBounds(610, 470, 80, 50);
        a9.setBounds(610, 520, 80, 50);
        a0.setBounds(610, 570, 80, 50);
        
        a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        a7.setVisible(false);
        a8.setVisible(false);
        a9.setVisible(false);
        a0.setVisible(false);
        
        this.add(a1);
        this.add(a2);
        this.add(a3);
        this.add(a4);
        this.add(a5);
        this.add(a6);
        this.add(a7);
        this.add(a8);
        this.add(a9);
        this.add(a0);
        
        
        
        aa1.setFont(txt);
        aa2.setFont(txt);
        aa3.setFont(txt);
        aa4.setFont(txt);
        aa5.setFont(txt);
        aa6.setFont(txt);
        aa7.setFont(txt);
        aa8.setFont(txt);
        aa9.setFont(txt);
        aa0.setFont(txt);
        
        aa1.setBounds(390, 370, 180, 45);
        aa2.setBounds(390, 420, 180, 45);
        aa3.setBounds(390, 470, 180, 45);
        aa4.setBounds(390, 520, 180, 45);
        aa5.setBounds(390, 570, 180, 45);
        aa6.setBounds(690, 370, 180, 45);
        aa7.setBounds(690, 420, 180, 45);
        aa8.setBounds(690, 470, 180, 45);
        aa9.setBounds(690, 520, 180, 45);
        aa0.setBounds(690, 570, 180, 45);
        
        aa1.setVisible(false);
        aa2.setVisible(false);
        aa3.setVisible(false);
        aa4.setVisible(false);
        aa5.setVisible(false);
        aa6.setVisible(false);
        aa7.setVisible(false);
        aa8.setVisible(false);
        aa9.setVisible(false);
        aa0.setVisible(false);
        
        this.add(aa1);
        this.add(aa2);
        this.add(aa3);
        this.add(aa4);
        this.add(aa5);
        this.add(aa6);
        this.add(aa7);
        this.add(aa8);
        this.add(aa9);
        this.add(aa0);
        
        //CRUD : Create Read Update Delete **************************************
        JButton create = new JButton("Create");
        create.setFont(txt);
        create.setForeground(negro);
        create.setBackground(rosaFuerte);
        create.setBounds(0,100,300,50);
        create.addActionListener( (ActionEvent e) -> {
            ins.setText("");
            inst.setText("<html>Ha elegido CREATE, seleccione una tabla para <br> insertar un registro");
            combo.setVisible(true);
            tabla.setText("La tabla que ha elegido es: ");
            ejecutar.setEnabled(true);
            cr.setText("create");
            
            //Extras
            pk.setEnabled(false);
            primary.setEnabled(false);
            
            att.setVisible(true);
            att.setEnabled(true);
            
            a1.setVisible(true);
            a2.setVisible(true);
            a3.setVisible(true);
            a4.setVisible(true);
            a5.setVisible(true);
            a6.setVisible(true);
            a7.setVisible(true);
            a8.setVisible(true);
            a9.setVisible(true);
            a0.setVisible(true);
            
            aa1.setVisible(true);
            aa2.setVisible(true);
            aa3.setVisible(true);
            aa4.setVisible(true);
            aa5.setVisible(true);
            aa6.setVisible(true);
            aa7.setVisible(true);
            aa8.setVisible(true);
            aa9.setVisible(true);
            aa0.setVisible(true);
            
            aa1.setText("");
            aa2.setText("");
            aa3.setText("");
            aa4.setText("");
            aa5.setText("");
            aa6.setText("");
            aa7.setText("");
            aa8.setText("");
            aa9.setText("");
            aa0.setText("");
            
            ejecutar.setText("Seleccionar");
        });
        this.add(create);
        
        JButton read = new JButton("Read");
        read.setFont(txt);
        read.setForeground(negro);
        read.setBackground(rosaFuerte);
        read.setBounds(0,150,300,50);
        read.addActionListener( (ActionEvent e) -> {
            ins.setText("");
            inst.setText("<html>Ha elegido READ, seleccione una tabla para<br> hacer una consulta");
            combo.setVisible(true);
            tabla.setText("La tabla que ha elegido es: ");
            ejecutar.setEnabled(true);
            cr.setText("read");
            
            //Extras
            pk.setEnabled(false);
            primary.setEnabled(false);
            
            att.setEnabled(false);
            
            a1.setVisible(false);
            a2.setVisible(false);
            a3.setVisible(false);
            a4.setVisible(false);
            a5.setVisible(false);
            a6.setVisible(false);
            a7.setVisible(false);
            a8.setVisible(false);
            a9.setVisible(false);
            a0.setVisible(false);
            
            aa1.setVisible(false);
            aa2.setVisible(false);
            aa3.setVisible(false);
            aa4.setVisible(false);
            aa5.setVisible(false);
            aa6.setVisible(false);
            aa7.setVisible(false);
            aa8.setVisible(false);
            aa9.setVisible(false);
            aa0.setVisible(false);
            
            ejecutar.setText("Seleccionar");
        });
        this.add(read);
        
        JButton ud = new JButton("Update");
        ud.setFont(txt);
        ud.setForeground(negro);
        ud.setBackground(rosaFuerte);
        ud.setBounds(0,200,300,50);
        ud.addActionListener( (ActionEvent e) -> {
            ins.setText("");
            inst.setText("<html>Ha elegido UPDATE, seleccione una tabla para<br> modificar un registro");
            combo.setVisible(true);
            tabla.setText("La tabla que ha elegido es: ");
            ejecutar.setEnabled(true);
            cr.setText("update");
            
            //Componentes extra
            pk.setVisible(true);
            pk.setEnabled(true);
            primary.setVisible(true);
            primary.setEnabled(true);
            
            att.setVisible(true);
            att.setEnabled(true);
            
            a1.setVisible(true);
            a2.setVisible(true);
            a3.setVisible(true);
            a4.setVisible(true);
            a5.setVisible(true);
            a6.setVisible(true);
            a7.setVisible(true);
            a8.setVisible(true);
            a9.setVisible(true);
            a0.setVisible(true);
            
            aa1.setVisible(true);
            aa2.setVisible(true);
            aa3.setVisible(true);
            aa4.setVisible(true);
            aa5.setVisible(true);
            aa6.setVisible(true);
            aa7.setVisible(true);
            aa8.setVisible(true);
            aa9.setVisible(true);
            aa0.setVisible(true);
            
            aa1.setText("");
            aa2.setText("");
            aa3.setText("");
            aa4.setText("");
            aa5.setText("");
            aa6.setText("");
            aa7.setText("");
            aa8.setText("");
            aa9.setText("");
            aa0.setText("");
            
            ejecutar.setText("Seleccionar");
        });
        this.add(ud);
        
        JButton del = new JButton("Delete");
        del.setFont(txt);
        del.setForeground(negro);
        del.setBackground(rosaFuerte);
        del.setBounds(0,250,300,50);
        del.addActionListener( (ActionEvent e) -> {
            ins.setText("");
            inst.setText("<html>Ha elegido DELETE, seleccione una tabla para<br> borrar un registro");
            combo.setVisible(true);
            tabla.setText("La tabla que ha elegido es: ");
            ejecutar.setEnabled(true);
            cr.setText("delete");
            
            //Componentes extra
            pk.setVisible(true);
            pk.setEnabled(true);
            primary.setVisible(true);
            primary.setEnabled(true);
            
            att.setEnabled(false);
            
            a1.setVisible(false);
            a2.setVisible(false);
            a3.setVisible(false);
            a4.setVisible(false);
            a5.setVisible(false);
            a6.setVisible(false);
            a7.setVisible(false);
            a8.setVisible(false);
            a9.setVisible(false);
            a0.setVisible(false);
            
            aa1.setVisible(false);
            aa2.setVisible(false);
            aa3.setVisible(false);
            aa4.setVisible(false);
            aa5.setVisible(false);
            aa6.setVisible(false);
            aa7.setVisible(false);
            aa8.setVisible(false);
            aa9.setVisible(false);
            aa0.setVisible(false);
            
            ejecutar.setText("Seleccionar");
        });
        this.add(del);
        
        //Boton para ejecutar la consulta / cambio, etc
        ejecutar.setFont(txt);
        ejecutar.setForeground(negro);
        ejecutar.setBackground(rosaFuerte);
        ejecutar.setBounds(450,620,300,70);
        ejecutar.addActionListener((ActionEvent e) -> {
            //Agarrar opcion
            String seleccion = (String) combo.getSelectedItem();
            tabla.setText("La tabla que ha elegido es: "+seleccion);
            tabla.setVisible(true);
            //Objeto de consultas
            Consultas cons = new Consultas();
            //Revisar cada una de las opciones del menu
            String eleccion = cr.getText();
            
            if(eleccion.equals("create")){
                if(seleccion.equals("autor")){
                    //Leer 3 atributos, el primero es int, ninguno null
                    try {
                        //Revisar que ninguno sea null para este caso
                        if(aa1.getText().isEmpty() || aa2.getText().isEmpty() || aa3.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Asegurese de ingresar los 3 atributos necesarios", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                           int num = Integer.parseInt(aa1.getText());
                            //llamar a la funcion en consultas
                            boolean operacion = cons.insertarAutor(num, aa2.getText(), aa3.getText());
                            
                            if(operacion){
                                JOptionPane.showMessageDialog(null, "Registro ingresado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Algo falló, no se insertó el registro", "Error", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Asegurese de ingresar un numero como PK para la tabla de autor", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                } else if(seleccion.equals("creditos")){
                    //Leer 8 atributos, el primero es no null, todos String
                    //Validar que no esté vacio el campo 1
                    if(aa1.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Asegurese de ingresar al menos el primer atributo para la tabla creditos", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        //Llamar a la funcion
                        boolean ex = cons.insertarCreditos(aa1.getText(), aa2.getText(), aa3.getText(), aa4.getText(), aa5.getText(), aa6.getText(), aa7.getText(), aa8.getText());
                        if(ex ){
                           JOptionPane.showMessageDialog(null, "Registro ingresado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Algo falló, no se insertó el registro, recuerde que debe existir un documental con el mismo nombre y no se pueden duplicar", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else if(seleccion.equals("documental")){
                    //Leer 10 atributos, String not null, int not null, String, int not null, todo lo demas String null
                    //Comprobar los campos que no deben ser not null
                    if(aa1.getText().isEmpty() || aa2.getText().isEmpty() || aa4.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Asegurese de ingresar los atributos 1, 2 y 4 al menos para documental", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        //comprobar los enteros
                        try {
                            int ent1 = Integer.parseInt(aa2.getText());
                            int ent2 = Integer.parseInt(aa4.getText());
                            
                            //Mandar a llamar a la función que hará el registro
                            boolean exito = cons.insertarDocumental(ent1, ent2, aa1.getText(), aa3.getText(), aa5.getText(), aa6.getText(), aa7.getText(), aa8.getText(), aa9.getText(), aa0.getText());
                            if(exito ){
                                JOptionPane.showMessageDialog(null, "Registro ingresado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                             } else {
                                 JOptionPane.showMessageDialog(null, "Algo falló, no se insertó el registro", "Error", JOptionPane.WARNING_MESSAGE);
                             }
                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Asegurese de ingresar un numero para los campos 2 y 4", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else if(seleccion.equals("festival")){
                    //Leer 5 atributos, el primero not null, el ultimo int
                    //Comprobar que el primero es not null
                    if(aa1.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Asegurese de ingresar el primer atributo para la tabla festival", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        //Verificar que el quinto es entero
                        try {
                            int e1 = Integer.parseInt(aa5.getText());
                            //mandar a llamar a la funcion de insertar
                            boolean exito = cons.insertarFestival(aa1.getText(), aa2.getText(), aa3.getText(), aa4.getText(), e1);
                            if(exito ){
                                JOptionPane.showMessageDialog(null, "Registro ingresado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                             } else {
                                 JOptionPane.showMessageDialog(null, "Algo falló, no se insertó el registro", "Error", JOptionPane.WARNING_MESSAGE);
                             }
                        } catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "Asegurese de ingresar un numero para el campo 5 y una fecha de la forma aaaa-mm-dd en el campo 3", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else if(seleccion.equals("secciones")){
                    //Leer 5 atributos, todos String, el tercero y el quinto pueden ser null
                    try {
                        //Verificar que no estén vacios los atributos necesarios
                        if(aa1.getText().isEmpty() || aa2.getText().isEmpty() ||aa4.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Asegurese de ingresar los atributos 1, 2 y 4 al menos para la tabla secciones", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            //insertar en la funcion
                            boolean exito = cons.insertarSeccion(aa1.getText(), aa2.getText(), aa3.getText(), aa4.getText(), aa5.getText());
                            if(exito ){
                                JOptionPane.showMessageDialog(null, "Registro ingresado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                             } else {
                                 JOptionPane.showMessageDialog(null, "Algo falló, no se insertó el registro", "Error", JOptionPane.WARNING_MESSAGE);
                             }
                        }
                    } catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Asegurese de ingresar una fecha de la forma aaaa-mm-dd en el campo 2, un nombre de documental valido en el campo 4 y un nombre de festival valido en el campo 5", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else if(eleccion.equals("read")){
                //De acuerdo con la tabla elegida, seleccionar los parametros
                String leido = "";
                if(seleccion.equals("autor")){
                    leido += "AutorID | Nombre | Ap_Paterno\n";
                } else if(seleccion.equals("creditos")){
                    leido += "TITULO | Fotografias | Produccion | Guion | Produccion_Ejecutiva | Edicion | Sonido | Compania_Productora\n";
                } else if(seleccion.equals("documental")){
                    leido += "Titulo | Año | Paises | Duracion_en_minutos | Director | Sinopsis | Semblanza | Iniciativas | TEMATICA | Festivales_y_premios\n";
                } else if(seleccion.equals("festival")){
                    leido += "Nombre | Lugar | Fecha | Descripcion | Costo\n";
                } else if(seleccion.equals("secciones")){
                    leido += "Nombre_de_la_seccion | Calendario | Descripcion | Documental | Festival\n";
                }
                
                leido += cons.consultaTabla(seleccion);
                
                JTextArea textArea = new JTextArea(leido);
                textArea.setFont(txt);
                JScrollPane scrollPane = new JScrollPane(textArea);  
                textArea.setLineWrap(true);  
                textArea.setWrapStyleWord(true); 
                scrollPane.setPreferredSize( new Dimension( 1000, 500 ) );
                JOptionPane.showMessageDialog(null, scrollPane, "Resultado consulta",JOptionPane.INFORMATION_MESSAGE);
            } else if(eleccion.equals("update")){
                //ejecutar.setText("Seleccionar");
                //Primero seleccionar la tabla y la PK para setear los JTextPane
                //Revisar que la PK no sea nula
                if(primary.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Por favor ingrese la PK", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    //Consultar en base a la tabla
                    if(seleccion.equals("autor")){
                        String[] consulta = new String[3];
                        //Verificar que el PK sea int
                        try {
                            int id = Integer.parseInt(primary.getText());
                            //regresar el arreglo
                            consulta = cons.consultaAutor(id);
                            //Revisar que no sea null para continuar
                            if(consulta != null){
                                //Set los valores a lo correspondiente
                                if(!ejecutar.getText().equals("MODIFICAR")){
                                    aa1.setText(consulta[0]);
                                    aa2.setText(consulta[1]);
                                    aa3.setText(consulta[2]);
                                }
                                
                                //Cambiar el nombre del botón a Modificar info
                                ejecutar.setText("MODIFICAR");
                                //Validaciones para los campos como en create
                                
                                //Metodo para update
                                updateAutor();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al hacer la consulta", "Error", JOptionPane.WARNING_MESSAGE);
                            }
                            
                        } catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "Por favor ingrese un numero valido en la PK", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                        
                    } else if(seleccion.equals("creditos")){
                        String[] consulta = new String[8];
                        //Verificar que el PK sea int
                        try {
                            //int id = Integer.parseInt(primary.getText());
                            //regresar el arreglo
                            consulta = cons.consultaCreditos(primary.getText());
                            //Revisar que no sea null para continuar
                            if(consulta != null){
                                //Set los valores a lo correspondiente
                                if(!ejecutar.getText().equals("MODIFICAR")){
                                    aa1.setText(consulta[0]);
                                    aa2.setText(consulta[1]);
                                    aa3.setText(consulta[2]);
                                    aa4.setText(consulta[3]);
                                    aa5.setText(consulta[4]);
                                    aa6.setText(consulta[5]);
                                    aa7.setText(consulta[6]);
                                    aa8.setText(consulta[7]);
                                }
                                
                                //Cambiar el nombre del botón a Modificar info
                                ejecutar.setText("MODIFICAR");
                                //Validaciones para los campos como en create
                                
                                //Metodo para update
                                updateCreditos();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al hacer la consulta", "Error", JOptionPane.WARNING_MESSAGE);
                            }
                            
                        } catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "Por favor ingrese un numero valido en la PK", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    } else if(seleccion.equals("documental")){
                        String[] consulta = new String[10];
                        //Verificar que el PK sea int
                        try {
                            //int id = Integer.parseInt(primary.getText());
                            //regresar el arreglo
                            consulta = cons.consultaDocumental(primary.getText());
                            //Revisar que no sea null para continuar
                            if(consulta != null){
                                //Set los valores a lo correspondiente
                                if(!ejecutar.getText().equals("MODIFICAR")){
                                    aa1.setText(consulta[0]);
                                    aa2.setText(consulta[1]);
                                    aa3.setText(consulta[2]);
                                    aa4.setText(consulta[3]);
                                    aa5.setText(consulta[4]);
                                    aa6.setText(consulta[5]);
                                    aa7.setText(consulta[6]);
                                    aa8.setText(consulta[7]);
                                    aa9.setText(consulta[8]);
                                    aa0.setText(consulta[9]);
                                }
                                
                                //Cambiar el nombre del botón a Modificar info
                                ejecutar.setText("MODIFICAR");
                                //Validaciones para los campos como en create
                                
                                //Metodo para update
                                updateDocumental();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al hacer la consulta", "Error", JOptionPane.WARNING_MESSAGE);
                            }
                            
                        } catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "Por favor ingrese un numero valido en la PK", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    } else if(seleccion.equals("festival")){
                        String[] consulta = new String[5];
                        //Verificar que el PK sea int
                        try {
                            //int id = Integer.parseInt(primary.getText());
                            //regresar el arreglo
                            consulta = cons.consultaFestival(primary.getText());
                            //Revisar que no sea null para continuar
                            if(consulta != null){
                                //Set los valores a lo correspondiente
                                if(!ejecutar.getText().equals("MODIFICAR")){
                                    aa1.setText(consulta[0]);
                                    aa2.setText(consulta[1]);
                                    aa3.setText(consulta[2]);
                                    aa4.setText(consulta[3]);
                                    aa5.setText(consulta[4]);
                                }
                                
                                //Cambiar el nombre del botón a Modificar info
                                ejecutar.setText("MODIFICAR");
                                //Validaciones para los campos como en create
                                
                                //Metodo para update
                                updateFestival();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al hacer la consulta", "Error", JOptionPane.WARNING_MESSAGE);
                            }
                            
                        } catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "Por favor ingrese un numero valido en la PK", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    } else if(seleccion.equals("secciones")){
                        String[] consulta = new String[5];
                        //Verificar que el PK sea int
                        try {
                            //int id = Integer.parseInt(primary.getText());
                            //regresar el arreglo
                            consulta = cons.consultaSecciones(primary.getText());
                            //Revisar que no sea null para continuar
                            if(consulta != null){
                                //Set los valores a lo correspondiente
                                if(!ejecutar.getText().equals("MODIFICAR")){
                                    aa1.setText(consulta[0]);
                                    aa2.setText(consulta[1]);
                                    aa3.setText(consulta[2]);
                                    aa4.setText(consulta[3]);
                                    aa5.setText(consulta[4]);
                                }
                                
                                //Cambiar el nombre del botón a Modificar info
                                ejecutar.setText("MODIFICAR");
                                //Validaciones para los campos como en create
                                
                                //Metodo para update
                                updateSecciones();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al hacer la consulta", "Error", JOptionPane.WARNING_MESSAGE);
                            }
                            
                        } catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "Por favor ingrese un numero valido en la PK", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }   
                }
            } else {
                //Delete
                //Obtener el valor de la llave 
                String llave = primary.getText();
                if(seleccion.equals("autor")){
                    //Comprobar que la llave sea numero
                    try {
                        int key = Integer.parseInt(llave);
                        boolean exito = cons.borrarAutor(llave);
                        
                        if(exito){
                            JOptionPane.showMessageDialog(null, "Registro borrado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Algo falló, no se borró el registro", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Asegurese de ingresar un numero como PK para la tabla de autor", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }  else if(seleccion.equals("creditos")){
                    boolean exito = cons.borrarCreditos(llave);  
                    if(exito){
                        JOptionPane.showMessageDialog(null, "Registro borrado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Algo falló, no se borró el registro", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                } else if(seleccion.equals("documental")){
                    boolean exito = cons.borrarDocumental(llave);  
                    if(exito){
                        JOptionPane.showMessageDialog(null, "Registro borrado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Algo falló, no se borró el registro", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                } else if(seleccion.equals("festival")){
                    boolean exito = cons.borrarFestival(llave);  
                    if(exito){
                        JOptionPane.showMessageDialog(null, "Registro borrado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Algo falló, no se borró el registro", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                } else if(seleccion.equals("secciones")){
                    boolean exito = cons.borrarSecciones(llave);  
                    if(exito){
                        JOptionPane.showMessageDialog(null, "Registro borrado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Algo falló, no se borró el registro", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        this.add(ejecutar);
    }
    
    public void updateAutor(){
        //Leer 3 atributos, el primero es int, ninguno null
        try {
            Consultas cons = new Consultas();
            //Revisar que ninguno sea null para este caso
            if(aa1.getText().isEmpty() || aa2.getText().isEmpty() || aa3.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Asegurese de ingresar los 3 atributos necesarios", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
               int num = Integer.parseInt(aa1.getText());
                //llamar a la funcion en consultas, PERO AQUI EN VEZ DE INSERTAR SERÁ UPDATE
                boolean operacion = cons.updateAutor(num, aa2.getText(), aa3.getText());

                if(operacion){
                    JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Algo falló, no se insertó el registro", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Asegurese de ingresar un numero como PK para la tabla de autor", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateSecciones(){
        //Leer 5 atributos, todos String, el tercero y el quinto pueden ser null
        try {
            Consultas cons = new Consultas();
            //Verificar que no estén vacios los atributos necesarios
            if(aa1.getText().isEmpty() || aa2.getText().isEmpty() ||aa4.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Asegurese de ingresar los atributos 1, 2 y 4 al menos para la tabla secciones", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                //insertar en la funcion
                boolean exito = cons.updateSecciones(aa1.getText(), aa2.getText(), aa3.getText(), aa4.getText(), aa5.getText());
                if(exito ){
                    JOptionPane.showMessageDialog(null, "Registro ingresado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                 } else {
                     JOptionPane.showMessageDialog(null, "Algo falló, no se insertó el registro", "Error", JOptionPane.WARNING_MESSAGE);
                 }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Asegurese de ingresar una fecha de la forma aaaa-mm-dd en el campo 2, un nombre de documental valido en el campo 4 y un nombre de festival valido en el campo 5", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateCreditos(){
        //Leer 8 atributos, el primero es no null, todos String
        //Validar que no esté vacio el campo 1
        Consultas cons = new Consultas();
        if(aa1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Asegurese de ingresar al menos el primer atributo para la tabla creditos", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            //Llamar a la funcion
            boolean ex = cons.updateCreditos(aa1.getText(), aa2.getText(), aa3.getText(), aa4.getText(), aa5.getText(), aa6.getText(), aa7.getText(), aa8.getText());
            if(ex ){
               JOptionPane.showMessageDialog(null, "Registro ingresado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Algo falló, no se insertó el registro, recuerde que debe existir un documental con el mismo nombre y no se pueden duplicar", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    public void updateDocumental(){
        //Leer 10 atributos, String not null, int not null, String, int not null, todo lo demas String null
        //Comprobar los campos que no deben ser not null
        Consultas cons = new Consultas();
        if(aa1.getText().isEmpty() || aa2.getText().isEmpty() || aa4.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Asegurese de ingresar los atributos 1, 2 y 4 al menos para documental", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            //comprobar los enteros
            try {
                int ent1 = Integer.parseInt(aa2.getText());
                int ent2 = Integer.parseInt(aa4.getText());

                //Mandar a llamar a la función que hará el registro
                boolean exito = cons.updateDocumental(aa1.getText(), aa3.getText(), aa5.getText(), aa6.getText(), aa7.getText(), aa8.getText(), aa9.getText(), aa0.getText(), ent1, ent2);
                if(exito ){
                    JOptionPane.showMessageDialog(null, "Registro ingresado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                 } else {
                     JOptionPane.showMessageDialog(null, "Algo falló, no se insertó el registro", "Error", JOptionPane.WARNING_MESSAGE);
                 }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Asegurese de ingresar un numero para los campos 2 y 4", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    public void updateFestival(){
        //Leer 5 atributos, el primero not null, el ultimo int
        //Comprobar que el primero es not null
        Consultas cons = new Consultas();
        if(aa1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Asegurese de ingresar el primer atributo para la tabla festival", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            //Verificar que el quinto es entero
            try {
                int e1 = Integer.parseInt(aa5.getText());
                //mandar a llamar a la funcion de insertar
                boolean exito = cons.updateFestival(aa1.getText(), aa2.getText(), aa3.getText(), aa4.getText(), e1);
                if(exito ){
                    JOptionPane.showMessageDialog(null, "Registro ingresado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                 } else {
                     JOptionPane.showMessageDialog(null, "Algo falló, no se insertó el registro", "Error", JOptionPane.WARNING_MESSAGE);
                 }
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Asegurese de ingresar un numero para el campo 5 y una fecha de la forma aaaa-mm-dd en el campo 3", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
