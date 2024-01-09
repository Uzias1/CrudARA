/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author 
 */
public class Carga extends JFrame {
    public Carga(){
        ventana();
    }
    public void ventana(){
        this.setSize(860, 573);
        this.setUndecorated(true);
        //Icono
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/kirby.png"));
        this.setIconImage(icono.getImage());
        //Para centrar
        this.setLocationRelativeTo(null);
        PCarga obj = new PCarga();
        this.add(obj);
    }
}
