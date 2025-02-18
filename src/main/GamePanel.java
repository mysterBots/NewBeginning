/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


/**
 *
 * @author BotZ
 */

public class GamePanel extends JPanel{
    
    MouseInputs mouse;
    private Game game;
    
    public GamePanel(Game game)
    {
        this.game = game;
        mouse = new MouseInputs(this);
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        
        setFocusable(true);
    }



    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }


        public void updateGame()
    {
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        game.render(g);
        
    }
    
    public Game getGame()
    {
        return this.game;
    }

    
}


