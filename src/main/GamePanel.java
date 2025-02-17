/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author BotZ
 */

public class GamePanel extends JPanel{
    
    MouseInputs mouse;
    private float xDelta = 100, yDelta = 100;
    private int frames;
    private long lastChecked = System.currentTimeMillis();

    private BufferedImage img;
    
    public GamePanel()
    {
        importImg();
        
        mouse = new MouseInputs(this);
        setPanelSize();
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
        
        g.drawImage(img.getSubimage(0, 0, 64, 40), 0, 0, 128, 80, null);
       
    }
    


    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    private void importImg() {
        
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        
        try {
            img = ImageIO.read(is);
        } 
        catch (IOException ex) 
        {
           ex.printStackTrace();
        }
    }
    

    
}


