import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;
import java.io.File;

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Characters
{
    private int speed = 1;
    private Random generator = new Random();
    
   
    public void act()
    {
    int num = generator.nextInt(5);
    if(num>3)move(speed);
        if(atWorldEdge())
    { 
        turn(120);
         
    }
    
    if(eat(Mario.class) == true)
    {
        Greenfoot.playSound("au.wav");
    }
}
  public void hitMario()
    {
        Actor Mario = getOneIntersectingObject(Mario.class);
        if(Mario !=null)
        {
            World myWorld = getWorld();
            Gameover gameover = new Gameover();
            myWorld.addObject(gameover, myWorld.getWidth()/2, myWorld.getHeight()/2);
            myWorld.removeObject(this);
        }
    }
}