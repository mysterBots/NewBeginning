/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author BotZ
 */
public class Game implements Runnable{
    
    private final int FPS_SET = 120;
    
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    
    private Thread gameThread;
    
    public Game()
    {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel); 
        
        this.startGameLoop();
    }
    
    private void startGameLoop()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        long lastChecked = System.currentTimeMillis();
        int frames = 0;
        
        
        while(true)
        {
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame)
            {
                gamePanel.repaint();
                lastFrame = now;
                 frames++;
            }

        
            if(System.currentTimeMillis() - lastChecked >= 1000)
            {
                lastChecked = System.currentTimeMillis();
                System.out.println(frames);
                frames = 0;
            }
        }
        
    }
    
}
