/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe;

/**
 *
 * @author SUANON O.K Fadil
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class game extends JFrame implements ActionListener{
   Panel panel = new Panel();
   JButton[]buttons = new JButton[9];
   boolean turn = true ;
   
   game(){
       panel.setLayout(new GridLayout(3,3));
       panel.setSize(300, 300);
       for(int i=0;i<9;i++){
           buttons[i] = new JButton();
           panel.add(buttons[i]);
           buttons[i].addActionListener(this);
       }
       this.setSize(300, 300);
       this.setLocation(new Point(0,500));
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.add(panel);
       this.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0 ; i<9 ; i++){
            if(e.getSource()==buttons[i]){
                if(turn){
                    buttons[i].setText("x");
                    buttons[i].setFont(new Font("Calibri",Font.PLAIN,35));
                    buttons[i].setEnabled(false);                }
                else{
                    buttons[i].setText("0");
                    buttons[i].setFont(new Font("Calibri",Font.PLAIN,35));
                    buttons[i].setEnabled(false); 
                }
                turn = !turn ;
            }
           
        }
         checkWinner();
    }
    
    public void checkWinner(){
        // columns
        for(int i=0; i<3 ; i++){
            if(buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && buttons[i].getText().equals("x")){
                JOptionPane.showMessageDialog(this, "1st player win");
            }
            else if(buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && buttons[i].getText().equals("0")){
                JOptionPane.showMessageDialog(this, "2nd Player win");
            }
        }
        // rows
        for(int i=0 ;i<7 ;i=i+3){
            if(buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && buttons[i].getText().equals("x")){
                JOptionPane.showMessageDialog(this, "1st player win");
            }
            else if(buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && buttons[i].getText().equals("0")){
                JOptionPane.showMessageDialog(this, "2nd player win");
            }
        }
        // diagonal
        for(int i=0 ;i<1 ;i=i+2){
            if(buttons[i].getText().equals(buttons[i+4].getText()) && buttons[i].getText().equals(buttons[i+8].getText()) && buttons[i].getText().equals("x")){
                JOptionPane.showMessageDialog(this, "1st player win");
            }
            else if(buttons[i].getText().equals(buttons[i+4].getText()) && buttons[i].getText().equals(buttons[i+8].getText()) && buttons[i].getText().equals("0")){
                JOptionPane.showMessageDialog(this, "2nd player win");
            }

        }
        for(int i=2 ;i<3 ; i=i+2){
             if(buttons[i].getText().equals(buttons[i+2].getText()) && buttons[i].getText().equals(buttons[i+4].getText()) && buttons[i].getText().equals("x")){
                JOptionPane.showMessageDialog(this, "1st player win");
            }
            else if(buttons[i].getText().equals(buttons[i+2].getText()) && buttons[i].getText().equals(buttons[i+4].getText()) && buttons[i].getText().equals("0")){
                JOptionPane.showMessageDialog(this, "2nd player win");
            }
        }
    }
}
