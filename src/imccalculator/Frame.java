/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imccalculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ulisses
 */

// Esse eu fiz na raça 
// nao consegui mexer nas bordas envolta da janela

public class Frame extends JFrame {
    
    public void frameCaller() {
        
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
        
        
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        frame.setTitle("IMC Calculator");
        frame.setLocationRelativeTo(null);
                
        

//        -------------------------------------------------------

        JPanel input = new JPanel(new GridLayout(2, 1, 30, 30));
        JLabel weight = new JLabel("Weight :");
        JTextField inputWeight = new JTextField(5);
        JLabel height = new JLabel("Height :");
        JTextField inputHeight = new JTextField(8);
 
        input.add( weight);
        input.add(inputWeight);
        
        input.add(height);
        input.add(inputHeight);
     
       
      
//        --------------------------------------------------
        
        JPanel buttons = new JPanel();
        JButton clear = new JButton("Clear");
        JButton calculate = new JButton("Calculate");

        buttons.add(clear);
        buttons.add(calculate);
        
//        -------------------------------------------------

        JPanel result = new JPanel(new BorderLayout(5, 5));
        JLabel resultText = new JLabel("Result:");
        JTextArea resultArea = new JTextArea();
        resultArea.setRows(13);
        
        result.add(BorderLayout.CENTER, resultText);
        result.add(BorderLayout.SOUTH, resultArea);
        
        
//       -------------------------------------------------------
        Container container = frame.getContentPane();
       
        container.add(BorderLayout.NORTH, input);

        container.add(BorderLayout.CENTER, buttons);
        
        container.add(BorderLayout.SOUTH, result);
        
       
        pack();
        frame.setVisible(true);
    }

}
