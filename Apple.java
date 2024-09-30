import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Food
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Apple(int level) {
        super(1, level);
    }
    //call food class, then runs drop method
    public void act()
    {
        drop();
    }
    
    //if a apple droppe lose a life and create a new apple.
    public void onDrop(MyWorld world) {
        world.createApple();
        world.loseLife(1);
    }
}
