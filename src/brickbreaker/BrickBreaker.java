/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package brickbreaker;

import javax.swing.*;

/**
 *
 * @author Ahmed Morsy
 */
public class BrickBreaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker:");
frame.setSize(720, 650);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);


GamePanel gamePanel = new GamePanel();
frame.add(gamePanel);
;

frame.setLocationRelativeTo(null);
frame.setVisible(true);  
gamePanel.requestFocusInWindow();

    }
    
}
