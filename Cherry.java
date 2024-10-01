import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cherry extends Food
{
    //constructor for Cherry class
    public Cherry(){
        super(10, 2);
    }
    
    //move the cherry
    public void move()
    {
        //initialize variables
        int x = getX();
        int y = getY();
        int rand = Greenfoot.getRandomNumber(2);
        
        //cherry will randomly stop midway
        if(rand == 0)
        {
            setLocation(x, y);
        }
        else
        {
            setLocation(x, y + this.speed);
        }
    }
}
