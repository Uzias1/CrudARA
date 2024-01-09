/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author 
 */
public class Menu extends JFrame{
    public Menu(){
        //Mandar a llamar al metodo que define la ventana
        proceso();
        //Mandar a llamar al JPanel correspondiente y cargarlo 
        PMenu menu = new PMenu();
        this.add(menu, BorderLayout.CENTER);
        //Para forzar el tamaño de ventana
        this.setResizable(false);
        //elegimos el icono de la ventana 
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/kirby.png"));
        this.setIconImage(icono.getImage());
        this.pack();
        //Centramos la ventana
        this.setLocationRelativeTo(null);
        
    }
    
    private void proceso(){
        //Accion al presionar la "X" en la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //Titulo de la ventana
        setTitle("Vista principal");
        //Agregar al contenido
        pack();
    }
}
