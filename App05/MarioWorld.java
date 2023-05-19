import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
public class MarioWorld extends World
{
    GreenfootSound myMusic = new GreenfootSound("background.mp3");
    public static final int MAXN_STARS = 20;
    public static final int MAXN_Silver = 20;
    public static final int MAXN_Bronze = 20;
    private Mario mario;
    private Rocket rocket;
    private Stars[] Stars;
    private Silver[] Silver;
    private Bronze[] Bronze;
    private int SilverSize = 20;
    private int starsSize = 20;
    private int BronzeSize = 20;
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
        super(700, 500, 1); 
        mario = new Mario();
        addObject(mario, 200, 200);
        rocket = new Rocket();
        addRocket();
        addRocket();
        addRocket();
        Stars = new Stars[10];
        addStars();
        addStars();
        addStars();
        Silver = new Silver[10];
        addSilver();
        addSilver();
        addSilver();
        Bronze = new Bronze[10];
        addBronze();
        addBronze();
        addBronze();
        setupCounters();
    }
    /**
     * Add MAXN_STARS to the world in random positions
     */
    public void addStars()
    {
        createStars();
    }
    /**
     * Add MAXN_Silver to the world in random positions
     */
    public void addSilver()
    {
        createSilver();
    }
    /**
     * Add MAXN_Bronze to the world in random positions
     */
    public void addBronze()
    {
        createBronze();
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
        
        int x = generator.nextInt(getWidth() + 100);
        int y = generator.nextInt(getHeight() + 150);
        
         addObject(stars, x, y);
        
    }
    private void createSilver()
    {
        Silver silver = new Silver();
        
        int x = generator.nextInt(getWidth() + 100);
        int y = generator.nextInt(getHeight() + 150);
        
         addObject(silver, x, y);
        
    }
      private void createBronze()
    {
        Bronze bronze = new Bronze();
        
        int x = generator.nextInt(getWidth() + 100);
        int y = generator.nextInt(getHeight() + 150);
        
         addObject(bronze, x, y);
        
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
