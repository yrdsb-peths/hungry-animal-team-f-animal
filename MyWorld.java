import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Label scoreBoard;
    
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

        prepare();
    }
    
    /**
     * create an apple at a ramdom location at top of the screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("Hungry Elephant", 80);
        addObject(label,300,100);

        Label label2 = new Label("click space to play!", 50);
        addObject(label2,300,200);
        
        Label label3 = new Label("Use the arrow keys to move!", 38);
        addObject(label3,300,300);
    }
}
