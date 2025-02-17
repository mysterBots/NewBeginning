/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author BotZ
 */

public class GamePanel extends JPanel{
    
    MouseInputs mouse;
    private float xDelta = 100, yDelta = 100;
    private float xDir = 1f, yDir = 1f;
    private int frames;
    private long lastChecked = System.currentTimeMillis();
    private Color color = new Color(150,150,150);
    private Random random;  
    
    public GamePanel()
    {
        random = new Random();
        mouse = new MouseInputs(this);
        
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        
        setFocusable(true);
    }
    
    public void changeXdelta(int val)
    {
        this.xDelta += val; 
        
    }
    
    public void changeYdelta(int val)
    {
        this.yDelta += val;
        
    }
    
    public void changePs(int x, int y)
    {
        this.xDelta = x;
        this.yDelta = y;
        
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        
        updateRectangle();
        g.setColor(this.color);
        g.fillRect((int)xDelta, (int)yDelta, 100, 100);

       
    }
    
    public void updateRectangle()
    {
        xDelta += xDir;
        if(xDelta > 400 || xDelta < 0)
        {
            xDir *= -1;
            color = getRndColor();
        }
        yDelta += yDir;
        if(yDelta > 400 || yDelta < 0)
        {
            yDir *= -1;
            color = getRndColor();
        }
    }
    
    private Color getRndColor()
    {
        int r = random.nextInt(255), 
            g = random.nextInt(255), 
            b = random.nextInt(255);
        
        return new Color(r,g,b);
    }
    

    
}


