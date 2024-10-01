import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Food extends Actor implements GameOverable
{
    //initialize variables
    private int value;
    public int speed;
    
    //constructor for Food class
    public Food(int value, int speed){
        this.value = value;
        this.speed = speed;
    }
    
    //act method for Food
    public void act()
    {
        drop();
    }
    
    //Make food drop
    public void drop() {
        //initialize variables
        MyWorld world = (MyWorld) getWorld();
        
        //move the food
        move();
        
        // Remove food and call onDrop when touching the bottom
        if(getY() >= world.getHeight() - 1)
        {
            world.removeObject(this);
            onDrop(world);
        }
    }
    
    //create a new food and decrease life by one
    public void onDrop(MyWorld world) {
        world.createFood();
        world.loseLife(1);
    }
    
    //return the value of the food
    public int getValue() {
        return value;
    }
    
    //move the food
    public void move()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
    }
    
    //to be call when game is over, removes elephant from game
    public void onGameOver() {
        getWorld().removeObject(this);
    }
}
