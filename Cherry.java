import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cherry extends Food
{
    public Cherry(){
        super(10, 4);
    }
    
    public void act()
    {
        drop();
    }
    
    public void onDrop(MyWorld world) {
        // Restart cherry timer
    }
}
