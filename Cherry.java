import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cherry extends Food
{
    public Cherry(){
        super(5, 2);
    }
    //slows down the apple
    
    public void move()
    {
        int x = getX();
        int y = getY();
        
        int rand = Greenfoot.getRandomNumber(6);
        
        if(rand == 0)
        {
            setLocation(x, y - (this.speed*3));
        }
        else
        {
            setLocation(x, y + this.speed);
        }
    }
    
}
