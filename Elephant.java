import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Elephant extends Actor implements GameOverable
{
    //initialize variables
    int speed = 6;
    int scale = 2;
    GreenfootImage[][] idleSprites = new GreenfootImage[2][8];
    GreenfootImage[][] walkSprites = new GreenfootImage[2][8];
    double spriteIndex = 0;
    double spriteSpeed = 0.35;
    GreenfootImage[][] currentSprite = idleSprites;
    boolean isLeft = false;
    
    //elephant sound
    GreenfootSound elephantSound = new GreenfootSound("elephant-trumpets-growls-6047.mp3");
    
    //Constructor for Elephant class
    public Elephant() {
        //setup idle image for elephant
        for (int i = 0; i < idleSprites[0].length; i++) {
            GreenfootImage newImage = new GreenfootImage("elephant_idle/idle" + i + ".png");
            newImage.scale(newImage.getWidth() * scale, newImage.getHeight() * scale);
            GreenfootImage flippedImage = new GreenfootImage(newImage);
            flippedImage.mirrorHorizontally();
            idleSprites[0][i] = newImage;
            idleSprites[1][i] = flippedImage;
        }
        
        //setup walk image for elephant
        for (int i = 0; i < walkSprites[0].length; i++) {
            GreenfootImage newImage = new GreenfootImage("elephant_walk/walk" + i + ".png");
            newImage.scale(newImage.getWidth() * scale, newImage.getHeight() * scale);
            GreenfootImage flippedImage = new GreenfootImage(newImage);
            flippedImage.mirrorHorizontally();
            walkSprites[0][i] = newImage;
            walkSprites[1][i] = flippedImage;
        }
        
        //set elephant starting image
        setImage(idleSprites[0][0]);
    }
    
    //act method for elephant
    public void act()
    {
        //initialize variables
        GreenfootImage[][] sprite = idleSprites;
        int movement = 0;
        
        //elephant movement
        if (Greenfoot.isKeyDown("left")) movement--;
            
        if (Greenfoot.isKeyDown("right")) movement++;
            
        if (movement != 0) {
            sprite = walkSprites;
            isLeft = (movement == -1);
            setLocation(getX() + movement * speed, getY());
        }
        
        collideFood();
        updateSprite(sprite);
    }
    
    //when touching food, remove the food and create a new one from the top
    public void collideFood() {
        //initialize variables
        MyWorld world = (MyWorld) getWorld();
        List<Food> foods = getIntersectingObjects(Food.class); 
        
        for (Food f : foods)
        {
            //remove the food in conllision and update score board
            getWorld().removeObject(f);
            world.updateScoreboard(f.getValue());
            
            // when elephant collides with food, plays a sound and create a new food
            elephantSound.play();
            world.createFood();
        }
    }
    
    //update image for the elephant
    public void updateSprite(GreenfootImage[][] newSprite) {
        // Ternary operator, shorthand for if/else, initialize variables
        int leftIndex = (isLeft) ? 1 : 0;
        
        //update image
        if (newSprite != currentSprite) 
        {
            currentSprite = newSprite;
            spriteIndex = 0;
        } 
        else
        {
            spriteIndex = (spriteIndex + spriteSpeed) % currentSprite[leftIndex].length;
            setImage(currentSprite[leftIndex][(int) spriteIndex]);
        }
    }
    
    //to be call when game is over, removes elephant from game
    public void onGameOver() {
        getWorld().removeObject(this);
    }
}
