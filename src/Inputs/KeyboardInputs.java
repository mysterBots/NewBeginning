/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GamePanel;

/**
 *
 * @author BotZ
 */
public class KeyboardInputs implements KeyListener{
    
    private GamePanel gamePanel;
    
    public KeyboardInputs(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_W -> gamePanel.changeYdelta(-5);
            case KeyEvent.VK_S -> gamePanel.changeYdelta(5);
            
            case KeyEvent.VK_A -> gamePanel.changeXdelta(-5);
            case KeyEvent.VK_D -> gamePanel.changeXdelta(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
