import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class MyWorld extends World
{
    //initilize variables
    Label scoreBoard;
    int score = 0;
    int level = 1;
    
    // create array of Life objects
    int lives = 3;
    Life[] lifeActors = new Life[lives];
    
    //Constructor for MyWorld class
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
        
        //add elephant
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 400 - 64);
        
        setPaintOrder(Label.class, Life.class, Elephant.class, Food.class);
    }
    
    /**
     * create foods at a random location at top of the screen
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
        
        level = (score / 10) + 1;
    }
    
    /**
     * decrease number of lives
     */
    public void loseLife(int lives) {
        //decrease number of lives
        this.lives -= lives;
        
        // remove a life symbol
        for (int i = lifeActors.length - 1; i >= Math.max(0, this.lives); i--) {
            removeObject(lifeActors[i]);
        }
        
        //if lives is less than equal zero call gameOVer
        if (this.lives <= 0) 
        {
            gameOver();
        }
    }
    
    /**
     * gameover screen
     */
    public void gameOver()
    {
        //remove all GameOverable objects
        List<GameOverable> objs = getObjects(GameOverable.class);
        for (GameOverable g : objs) g.onGameOver();
        
        //add a game over label
        Label gameOver = new Label("GameOver", 100);
        addObject(gameOver, 300, 200);
    }
}
