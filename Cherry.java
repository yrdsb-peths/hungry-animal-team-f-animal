import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cherry extends Food
{
    public void act()
    {
        // Add your action code here.
        setLocation(getX(), getY() + 4);
    }
    
    public Cherry(){
        super(10);
    }
}
