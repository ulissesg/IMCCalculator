/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imccalculator;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author ulisses
 */
public class FrameImc extends JFrame implements ActionListener{
    
    JPanel window = new JPanel();

    JLabel weight = new JLabel("Weight");
    JTextField inputWeight = new JTextField(10);
    JLabel height = new JLabel("Height");
    JTextField inputHeight = new JTextField(10);

    JButton clear = new JButton("Clear");
    JButton calculate = new JButton("Calculate");

    JLabel resultText = new JLabel("Result");
    JTextArea resultArea = new JTextArea();

    String inputWeights;
    String inputHeights;
    
    public FrameImc(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,400);
        setTitle("IMC Calculator");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        window.setBackground(new Color(240, 240, 240));
        window.setLayout(null);
        
        weight.setBounds(15, 10, 70, 30);
        inputWeight.setBounds(85, 10, 250, 30);
        height.setBounds(15, 60, 70, 30);
        inputHeight.setBounds(85, 60, 250, 30);
        
        clear.setBounds(15, 110, 150, 30);
        calculate.setBounds(180, 110, 150, 30);
        
        resultText.setBounds(15, 160, 70, 20);
        resultArea.setBounds(15, 185, 320, 165);
        
        resultArea.setRows(10);
        
        inputWeight.addActionListener(this);
        inputHeight.addActionListener(this);
        
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
        
        
        window.add(weight);
        window.add(inputWeight);
        window.add(height);
        window.add(inputHeight);
        window.add(clear);
        window.add(calculate);
        window.add(resultText);
        window.add(resultArea);
        
        add(window);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == clear){
            JTextField x = new JTextField();
            JTextArea y = new JTextArea();
            int i = 0;
            for(Component c : window.getComponents()){
                if (c.getClass().toString().contains("javax.swing.JTextField")){
                    x = (JTextField) c;
                    x.setText("");
                }
                if (c.getClass().toString().contains("javax.swing.JTextArea")){
                    y = (JTextArea) c;
                    y.setText("");
                }
            }
        }
    }
    
    public double calculateImc (double weight, double height){
        return weight/ Math.pow(height, 2);
    }
    
    public String classifyImc (double x){
        if (x < 18.5){
            return (String.format("%.1f", x) + ": Underweight.");
        }
        if (x > 18.5 && x < 24.9){
            return (String.format("%.1f", x) + ": Normal.");
        }
        if (x > 25 && x < 29.9){
            return (String.format("%.1f", x) + ": Overweight.");
        }
        if (x > 30 && x < 34.9){
            return (String.format("%.1f", x) + ": Obese.");
        }
        if (x > 35 && x < 39.9){
            return (String.format("%.1f", x) + ": Serevely Obese.");
        }
        else{
            return (String.format("%.1f", x) + ": Morbidly Obese.");
        }
    }
    
}
