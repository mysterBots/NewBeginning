/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import static utils.Constants.Directions.DOWN;
import static utils.Constants.Directions.LEFT;
import static utils.Constants.Directions.RIGHT;
import static utils.Constants.Directions.UP;
import static utils.Constants.PlayerConstants.GetSpriteAmount;
import static utils.Constants.PlayerConstants.*;


/**
 *
 * @author mysterbotz
 */
public class Player extends Entity{
    
    private BufferedImage[][] animations;
    
    private int aniTick, aniIndex, aniSpeed = 30;
    private int playerAction = PLAYER_IDLE;
    private int playerDir = 1;
    
    private boolean up, down, left, right;
    
    private boolean moving = false, attacking = false;
    private float playSpeed = 2.0f;
    
    public Player(float x, float y) 
    {
        super(x, y);
        loadAnimations();
    }
    
    public void update()
    {
        updatePos();
        
        updateAimationTick();
        
        setAnimation();
        
    }  
    
    public void render(Graphics g)
    {
        g.drawImage(animations[playerAction][aniIndex], (int)x, (int)y, 256, 168, null);
    }
    

    

    
    private void loadAnimations() {
        
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        
        try {
            
            BufferedImage img = ImageIO.read(is);
            
            animations = new BufferedImage[9][6];
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
                }
            }
        } 
        catch (IOException ex) 
        {
           ex.printStackTrace();
        }
        
    }
    
    public void setAttack(boolean attacking)
    {
        this.attacking = attacking;
    }
    
    private void updateAimationTick() {
        
        aniTick++;
        
        if(aniTick >= aniSpeed)
        {
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(playerAction))
            {
                aniIndex = 0; 
                attacking = false;
            }
                
        }
        
    }
    
    public void setAnimation()
    {
        int startAni = playerAction;
        
        if(moving)
        {
            playerAction = PLAYER_RUNNING;
        }
        else
        {
            playerAction = PLAYER_IDLE;
        }
        
        if(attacking)
            playerAction = PLAYER_ATTACK;
        
        if(startAni != playerAction)
        {
            resetAni();
        }
    }
    
    public void resetAni()
    {
        aniTick = 0;
        aniIndex = 0;
    }
    
    public void updatePos()
    {
        moving = false;
        if(this.left && !this.right)
        {
            x-= playSpeed;
            moving = true;
        }else if(!this.left && this.right)
        {
            x+= playSpeed;
            moving = true;
        }
        
        if(this.up && !this.down)
        {
            y-= playSpeed;
            moving = true;
        }else if(!this.up && this.down)
        {
            y+= playSpeed;
            moving = true;
        }
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void resetDirBool() {
        left = false;
        right = false;
        up = false;
        down = false;
    }
    
    
    
}

