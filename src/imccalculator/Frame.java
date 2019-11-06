/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imccalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ulisses
 */

// Esse eu fiz na raça 
// nao consegui mexer nas bordas envolta da janela

public class Frame extends JFrame implements ActionListener{

    JPanel input = new JPanel(new GridLayout(2, 1, 30, 30));
    JLabel weight = new JLabel("Weight :");
    JTextField inputWeight = new JTextField(10);
    JLabel height = new JLabel("Height :");
    JTextField inputHeight = new JTextField(10);
    
    JPanel buttons = new JPanel();
    JButton clear = new JButton("Clear");
    JButton calculate = new JButton("Calculate");
    
    JPanel result = new JPanel(new BorderLayout(5, 5));
    JLabel resultText = new JLabel("Result:");
    JTextArea resultArea = new JTextArea();
    
    String inputWeights;
    String inputHeights;
    
    public Frame(){
        
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,400);
        setTitle("IMC Calculator");
        setLocationRelativeTo(null);
                
        

//        -------------------------------------------------------
        inputWeight.addActionListener(this);
        inputHeight.addActionListener(this);
           

        input.add( weight);
        input.add(inputWeight);
        
        input.add(height);
        input.add(inputHeight);

//        --------------------------------------------------
        buttons.setBackground(Color.red);
        buttons.setLayout(null);
        buttons.setSize(300, 50);
        buttons.setBounds(10, 200, 300, 50);

        clear.addActionListener(this);
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                inputHeights = inputHeight.getText().replace(",", ".");
                inputWeights = inputWeight.getText().replace(",", ".");
                double result;
                String resultText;
                
                result = calculateImc(Double.parseDouble(inputWeights), Double.parseDouble(inputHeights));
                resultText = classifyImc(result);
                resultArea.setText(resultText);
            }
        });
        
        clear.setBounds(10, 10, 100,30);
        calculate.setBounds(120, 10, 100,30);
        
        buttons.add(clear);
        buttons.add(calculate);
        
//        -------------------------------------------------

        resultArea.setRows(7);
        
        result.add(BorderLayout.CENTER, resultText);
        result.add(BorderLayout.SOUTH, resultArea);
        
        
//       -------------------------------------------------------
       
        add(BorderLayout.NORTH, input);

        add(BorderLayout.CENTER, buttons);
        
        add(BorderLayout.SOUTH, result);
        
       
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == clear){
            JTextField x = new JTextField();
            JTextArea y = new JTextArea();
            int i = 0;
            for(Component c : input.getComponents()){
                if (c.getClass().toString().contains("javax.swing.JTextField")){
                    x = (JTextField) c;
                    x.setText("");
                }
            }
            for(Component c : result.getComponents()){
                if (c.getClass().toString().contains("javax.swing.JTextArea")){
                    y = (JTextArea) c;
                    y.setText("");
                }
            }
        }
//        if (arg0.getSource() == calculate){
//            JOptionPane.showMessageDialog(null, "result of calculate");
//        }
//        if (arg0.getSource() == inputHeight){
//            inputWeights = inputWeight.getText();
//        }
    }
    
    public double calculateImc (double weight, double height){
        return weight/ Math.pow(height, 2);
    }
    
    public String classifyImc (double x){
        if (x < 18.5){
            return (x + ": Underweight.");
        }
        if (x > 18.5 && x < 24.39){
            return (x + ": Normal.");
        }
        if (x > 25 && x < 29.9){
            return (x + ": Overweight.");
        }
        if (x > 30 && x < 34.9){
            return (x + ": Obese.");
        }
        if (x > 35 && x < 39.9){
            return (x + ": Serevely Obese.");
        }
        else{
            return (x + ": Morbidly Obese.");
        }
    }

}
