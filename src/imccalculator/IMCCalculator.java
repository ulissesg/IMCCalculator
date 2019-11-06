/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imccalculator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ulisses
 */
public class IMCCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    try {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
        
        new Frame();
 
//        ImcCalculator gui = new ImcCalculator();  //descomentar para a janela 
//                                                  //feita com a ferramenta do netbeans
//        gui.setVisible(true);
          
    }
    
}
