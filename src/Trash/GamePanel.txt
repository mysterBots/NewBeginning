/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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
    
    private ArrayList<MyRect> rects = new ArrayList<>(); 
    
    
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
    
    public void spawnRects(int x, int y)
    {
        rects.add(new MyRect(x,y));
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        for(MyRect rect : rects)
        {
            rect.updateRectangle();
            rect.draw(g);
        }
        
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
    
    class MyRect 
    {
        int x,y,w,h;
        int xDir = 1, yDir = 1;
        Color color;

        public MyRect(int x, int y)
        {
            this.x = x;
            this.y = y;
            w = random.nextInt(50);
            h = w;
            this.color = newColor();
        }
        
        public void updateRectangle()
        {
            this.x += this.xDir;
            this.y += this.yDir;
            if((this.x + w) > 400 || this.x < 0)
            {
                this.xDir *= -1;
                this.color = newColor();
            }
            
            if((this.y + h) > 400 || this.y < 0)
            {
                this.yDir *= -1;
                this.color = newColor();
            }
        }
        
        private Color newColor()
        {
            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            return new Color(r,g,b);
        }
        
        public void draw(Graphics g)
        {
            g.setColor(color);
            g.fillRect(x,y,w,h);
        }
    }

    
}


