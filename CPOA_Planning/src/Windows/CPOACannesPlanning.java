/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;
import javax.swing.*;
import java.awt.*;


public class CPOACannesPlanning {
    public static void main(String[] args) {
        JFrame Fenetre = new JFrame();
        Fenetre.setSize(new Dimension(400, 300));
        
        Menu Menu = new Menu();
        Fenetre.add(Menu);
        Fenetre.setVisible(true);
        Menu.setVisible(true);
    }
   
}
