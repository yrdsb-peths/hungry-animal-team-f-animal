import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Food extends Actor
{
    private int value;
    public int speed;
    
    public Food(int value, int speed){
        this.value = value;
        this.speed = speed;
    }
    
    public void drop() {
        // Remove food and call a function when touching the bottom
        move();
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight() - 1)
        {
            world.removeObject(this);
            onDrop(world);
        }
    }

    public void onDrop(MyWorld world) {
        world.createFood();
        world.loseLife(1);
    }
    
    public void act()
    {
        drop();
    }
    
    public int getValue() {
        return value;
    }
    
    public void move()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
    }
}
