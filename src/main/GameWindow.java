/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JFrame;

/**
 *
 * @author BotZ
 */
public class GameWindow {
    
    private JFrame jframe;
    
    public GameWindow(GamePanel gamePanel)
    {
        jframe = new JFrame();
        
        
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.add(gamePanel);
        jframe.pack();
        
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
    
}
