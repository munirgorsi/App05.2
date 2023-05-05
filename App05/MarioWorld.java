import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 */
public class MarioWorld extends World
{
    public static final int MAXN_STARS = 20;
    
    private Mario mario;
    private Rocket rocket;
    private Stars[] Stars;
    private int starsSize = 30;
    private int remainingStars = MAXN_STARS;
    
    private Random generator = new Random();
    private Counter score;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MarioWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        mario = new Mario();
        addObject(mario, 200, 200);
        
        rocket = new Rocket();
        addRocket();
        addRocket();
        addRocket();
        addRocket();
        addRocket();
        addRocket();
        addRocket();
        
      
        
        Stars = new Stars[10];
        addStars();
        addStars();
        addStars();
        addStars();
        addStars();
       
      
        
        setupScore();
    }
    
    /**
     * Add MAXN_STARS to the world in random positions
     */
    public void addStars()
    {
        createStars();
    }
    
    public void addRocket()
    {
        createRocket();
    }
    
    private void createRocket()
    {
    Rocket rocket = new Rocket();
    int x = generator.nextInt(getWidth());
    int y = generator.nextInt(getHeight());
        
         addObject(rocket, x, y);
    }
    
    private void createStars()
    {
        Stars stars = new Stars();
        
        int x = generator.nextInt(getWidth());
        int y = generator.nextInt(getHeight());
        
         addObject(stars, x, y);
        
    }
    
    public void score()
    {
    }
    
    private void setupScore()
    {
        score = new Counter("Score: ");
        addObject (score, 60, 30);
    }
    
    public void loseGame()
    {
        showText("Game Over: You have Lost!", 400, 300);
    }
    
   public void winGame()
    {
        showText("Game Over: You have Won!", 400, 300);
    }    
}
