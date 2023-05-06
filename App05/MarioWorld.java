import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 */
public class MarioWorld extends World
{
    GreenfootSound myMusic = new GreenfootSound("background.mp3");
    public static final int MAXN_STARS = 20;
    
    private Mario mario;
    private Rocket rocket;
    private Stars[] Stars;
    private Silver[] Silver;
    private int SilverSize = 30;
    private int starsSize = 30;
    private int remainingStars = MAXN_STARS;
    
    private Random generator = new Random();
    private Counter score;
    private Counter energy;
    
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
        
        
      
        
        Stars = new Stars[10];
        addStars();
        addStars();
        
       Silver = new Silver [10];
        setupCounters();
    }
    
    /**
     * Add MAXN_STARS to the world in random positions
     */
    public void addStars()
    {
        createStars();
    }
    public void addSilver()
    {
        createSilver();
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
    private void createSilver()
    {
        Silver silver = new Silver();
        
        int x = generator.nextInt(getWidth());
        int y = generator.nextInt(getHeight());
        
         addObject(silver, x, y);
        
    }

    
    public void score()
    {
    }
    
    private void setupCounters()
    {
        score = new Counter("Score: ");
        addObject (score, 60, 30);
        energy = new Counter("Energy: ");
        energy.setValue(100);
        addObject (energy, 220, 30);
        
    }
    public void updateCounters(int scoreValue,int energyValue)
    {
        score.setValue(scoreValue);
        energy.setValue(energyValue);
    }
    public void loseGame()
    {
        showText("Game Over: You have Lost!", 400, 300);
    }
    
   public void winGame()
    {
        showText("Game Over: You have Won!", 400, 300);
    }   
    public void act()
    {
        myMusic.play();
    }
}
