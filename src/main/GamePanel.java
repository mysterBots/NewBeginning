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
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;

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
    private BufferedImage[][] animations;
    
    private int aniTick, aniIndex, aniSpeed = 30;
    private int playerAction = PLAYER_IDLE;
    private int playerDir = 1;
    private boolean moving = false;
    
    public GamePanel()
    {
        importImg();
        loadAnimations();
        
        mouse = new MouseInputs(this);
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        
        setFocusable(true);
    }

    public void setDirection(int direction)
    {
        this.playerDir = direction;
        moving = true;
    }
    
    public void setMoving(boolean moving)
    {
        this.moving = moving;
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

    private void loadAnimations() {
        
        animations = new BufferedImage[9][6];
        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
            }
        }
        
        
    }
    
    private void updateAimationTick() {
        
        aniTick++;
        
        if(aniTick >= aniSpeed)
        {
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(playerAction)) aniIndex = 0; 
        }
        
    }
    
    public void setAnimation()
    {
        if(moving)
        {
            playerAction = PLAYER_RUNNING;
        }
        else
        {
            playerAction = PLAYER_IDLE;
        }
    }
    
    public void updatePos()
    {
        if(moving)
        {
            switch(playerDir)
            {
                case LEFT -> xDelta -= 5;
                case RIGHT -> xDelta += 5;
                
                case UP -> yDelta -= 5;
                case DOWN -> yDelta += 5;
                
                
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        updateAimationTick();
        
        setAnimation();
        updatePos();
        
        g.drawImage(animations[playerAction][aniIndex], (int)xDelta, (int)yDelta, 256, 168, null);
       
        
    }

    
    

    
}


