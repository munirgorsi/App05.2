import greenfoot.*;

import java.util.List;
import java.util.ArrayList;


public class Characters extends Actor
{
    private static final int WALKING_SPEED = 5;

    /**
     * Move forward in the current direction.
     */
    public void move()
    {
        move(WALKING_SPEED);
    }

    
    /**
     * Test if we are close to one of the edges of the world. Return true if we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 19)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 19)
            return true;
        else
            return false;
    }
    
    
    /**
     * Return true if we can see an object of class 'clss' right where we are. 
     * False if there is no such object here.
     */
    public Actor canSee(Class anyClass)
    {
        Actor actor = getOneObjectAtOffset(0, 0, anyClass);
        return actor;        
    }

    
    /**
     * Try to eat an object of class 'clss'. This is only successful if there
     * is such an object where we currently are. Otherwise this method does
     * nothing.
     */
    public boolean eat(Class foodClass)
    {
        Actor actor = getOneObjectAtOffset(0, 0, foodClass);
        if(actor != null) {
            getWorld().removeObject(actor);
            return true;
        }
        return false;
        
    }
}