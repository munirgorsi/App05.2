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
    private int speed = 3;
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
 
}