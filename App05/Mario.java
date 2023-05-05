import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingSprite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Characters
{
    protected int width=10;
    protected int height=10;
    
    protected int speed = 2;
    protected int turnAngle = 4;
    
    protected GreenfootImage image;
    
    private MarioWorld world;
    
    public Mario()
    {
        image = getImage();
        
        width = image.getWidth();
        height = image.getHeight();
        image.scale((int)(width * 0.06), (int)(height * 0.06));
    }
     
     
    /**
     * This method allows the user to move the crab so that when
     * it collides with a worm the worm is removed and the score
     * is increase
     */
    public void act()
    {
        turnAndMove(); 
        if(eat(Stars.class)==true)
        {
            Greenfoot.playSound("slurp.wav");
            getWorld().addObject(new Stars(), Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
            Counter counter = (Counter)getWorld().getObjects(Counter.class).get(0);
            counter.add(1);
            
        }
        
    }
    
    /**
     * This method rotates the worm a small amount to the
     * left or to the right, and then the worm moves in that
     * direction
     */
    public void turnAndMove()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-turnAngle);
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            turn(turnAngle);
        }  
        
        if(Greenfoot.isKeyDown("space"))
        {
             move(speed);    
        }         
    }
    
    /**
     * This method moves the crab around in four directions
     * left, right, up and down using coordinate positions. 
     * It must not move off the screen.
     */
    public void move4Ways()
    {
        int x = getX(); int y = getY();
        int halfWidth = width / 2;
        
        if(Greenfoot.isKeyDown("left") && x > halfWidth)
        {
            setRotation(270);
            x -= speed;
        }
        
        if(Greenfoot.isKeyDown("right") && !isAtEdge())
        {
            setRotation(90);
            x += speed;
        }        
        
        if(Greenfoot.isKeyDown("down") && !isAtEdge())
        {
            setRotation(180);
            y += speed;
        } 
        
        if(Greenfoot.isKeyDown("up") && y > speed)
        {
            setRotation(0);
            y -= speed;
        }
        
        setLocation(x, y);        
    }
}
