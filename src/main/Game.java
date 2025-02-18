/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entities.Player;
import java.awt.Graphics;

/**
 *
 * @author BotZ
 */
public class Game implements Runnable{
    
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    
    private Player player;
    
    private Thread gameThread;
    
    public Game()
    {
        this.initClasses();
        
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel); 
        
        this.startGameLoop();
        
    }
    
      
    private void initClasses() {
        player = new Player(200,200);
    }
    
    
    private void startGameLoop()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void update()
    {
        player.update();
    }
    
    public void render(Graphics g)
    {
        player.render(g);
    }

    @Override
    public void run() {
        
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        
        long previousTime = System.nanoTime();
        
        long lastChecked = System.currentTimeMillis();
        int frames = 0;
        int updates = 0;
        
        double deltaU = 0;
        double deltaF = 0;
        
        
        while(true)
        {
            long currTime = System.nanoTime();
            
            deltaU += (currTime - previousTime) / timePerUpdate;
            deltaF += (currTime - previousTime) / timePerFrame;
            
            previousTime = currTime;
            
            if(deltaU >= 1)
            {
                update();
                updates++;
                deltaU--;
            }
            
            if(deltaF >= 1)
            {
                gamePanel.repaint();
                deltaF--;
                frames++;
            }

        
            if(System.currentTimeMillis() - lastChecked >= 1000)
            {
                lastChecked = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
        
    }

    public Player getPlayer()
    {
        return this.player;
    }
  
}
