import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        //create score label
        scoreBoard = new Label(0,80);
        addObject(scoreBoard, 50, 50);
        
        //create an apple
        createApple();
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 400 - 64);
    }
    
    /**
     * create an apple at a ramdom location at top of the screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setspeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    /**
     * update the score board
     */
    public void updateScoreboard(int point)
    {
        score += point;
        scoreBoard.setValue(score);
        
        if (score % 5 == 0)
        {
            level += 1;
        }
    }
    
    /**
     * gameover screen
     */
    public void gameOver()
    {
        Label gameOver = new Label("GameOver", 100);
        addObject(gameOver, 300, 200);
    }
}
