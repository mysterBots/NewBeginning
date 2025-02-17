/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author mysterbotz
 */
public class Constants {
    
    public static class Directions
    {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }
 
    public static class PlayerConstants
    {
        public static final int PLAYER_IDLE = 0;
        public static final int PLAYER_RUNNING = 1;
        public static final int PLAYER_JUMP = 2;
        public static final int PLAYER_FALLING = 3;
        public static final int PLAYER_GROUND = 4;
        public static final int PLAYER_HIT = 5;
        public static final int PLAYER_ATTACK = 6;
        public static final int PLAYER_ATTACK_JUMP1 = 7;
        public static final int PLAYER_ATTACK_JUMP2 = 8;
        
        public static int GetSpriteAmount(int player_action)
        {
            switch(player_action)
            {
                case PLAYER_RUNNING:
                    return 6;
                case PLAYER_IDLE:
                    return 5;
                case PLAYER_HIT:
                    return 4;
                case PLAYER_ATTACK:
                case PLAYER_ATTACK_JUMP1:
                case PLAYER_ATTACK_JUMP2:
                    return 3;
                case PLAYER_GROUND:
                    return 2;
                case PLAYER_FALLING:
                    return 1;
                default:
                    return 0;
                
                    
            }
        }
    }
}
