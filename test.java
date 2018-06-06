import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test extends AnimatedActor
{
    private GreenfootImage[] frames;
    private int lenght;
    /**
     * Act - do whatever the test wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(1);
        // Add your action code here.
    }
    public void jubeln(){
        Animation animation;
        frames = new GreenfootImage[5];
        frames[0] = new GreenfootImage("shiggy Master.png");
        frames[1] = new GreenfootImage("shiggy arme mitte.png");
        frames[2] = new GreenfootImage("shiggy arme oben.png");
        frames[3] = new GreenfootImage("shiggy arme mitte.png");
        frames[4] = new GreenfootImage("shiggy Master.png");
        
        lenght = 5;
        animation = new Animation(frames, 100, true, lenght);
        animate(animation);
    }
    public void animateNow(){
        Animation animation;
        frames = new GreenfootImage[5];
        frames[0] = new GreenfootImage("shiggy Master.png");
        frames[1] = new GreenfootImage("shiggy halb.png");
        frames[2] = new GreenfootImage("shiggy zu.png");
        frames[3] = new GreenfootImage("shiggy halb.png");
        frames[4] = new GreenfootImage("shiggy Master.png");
        
        lenght = 5;
        animation = new Animation(frames, 100, false, lenght);
        animate(animation);
    }
}
