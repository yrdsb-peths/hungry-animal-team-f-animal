import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //initilize variables
    Label scoreBoard;
    int score = 0;
    int level = 1;
    
    // Array of Life objects
    int lives = 3;
    Life[] lifeActors = new Life[lives];

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        //create score label
        scoreBoard = new Label(0,80);
        addObject(scoreBoard, 50, 50);
        
        //create life icons
        for (int i = 0; i < lifeActors.length; i++) {
            Life icon = new Life();
            addObject(icon, 600 - 25 - 150 + (50 * (i + 1)), 25);
            lifeActors[i] = icon;
        }
        
        //create food
        createFood();
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 400 - 64);
        
        setPaintOrder(Label.class, Life.class, Elephant.class, Food.class);
    }
    
    /**
     * create food at a random location at top of the screen
     */
    public void createFood()
    {
        int rand = Greenfoot.getRandomNumber(2);
        Food food;
        
        if(rand == 0) {
            food = new Apple();
        } else {
            food = new Cherry();
        }
        
        int x = Greenfoot.getRandomNumber(600);
        addObject(food, x, 0);
    }
    
    /**
     * update the score board
     */
    public void updateScoreboard(int point)
    {
        score += point;
        scoreBoard.setValue(score);
        
        level = (score / 5) + 1;
    }
    
    public void loseLife(int lives) {
        this.lives -= lives;
        // Loop from the end to how many lives you have remaining,
        // destroying the objects in that order
        for (int i = lifeActors.length - 1; i >= Math.max(0, this.lives); i--) {
            removeObject(lifeActors[i]);
        }

        if (this.lives <= 0) {
            gameOver();
        }
    }
    
    /**
     * gameover screen
     */
    public void gameOver()
    {
        List<GameOverable> objs = getObjects(GameOverable.class);
        for (GameOverable g : objs)
            g.onGameOver();
        Label gameOver = new Label("GameOver", 100);
        addObject(gameOver, 300, 200);
    }
}
