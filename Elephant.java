import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor
{
    int speed = 6;
    int scale = 2;
    GreenfootImage[][] idleSprites = new GreenfootImage[2][8];
    GreenfootImage[][] walkSprites = new GreenfootImage[2][8];
    double spriteIndex = 0;
    double spriteSpeed = 0.35;
    GreenfootImage[][] currentSprite = idleSprites;
    boolean isLeft = false;
    
    public Elephant() {
        for (int i = 0; i < idleSprites[0].length; i++) {
            GreenfootImage newImage = new GreenfootImage("elephant_idle/idle" + i + ".png");
            newImage.scale(newImage.getWidth() * scale, newImage.getHeight() * scale);
            GreenfootImage flippedImage = new GreenfootImage(newImage);
            flippedImage.mirrorHorizontally();
            idleSprites[0][i] = newImage;
            idleSprites[1][i] = flippedImage;
        }
        
        for (int i = 0; i < walkSprites[0].length; i++) {
            GreenfootImage newImage = new GreenfootImage("elephant_walk/walk" + i + ".png");
            newImage.scale(newImage.getWidth() * scale, newImage.getHeight() * scale);
            GreenfootImage flippedImage = new GreenfootImage(newImage);
            flippedImage.mirrorHorizontally();
            walkSprites[0][i] = newImage;
            walkSprites[1][i] = flippedImage;
        }
        setImage(idleSprites[0][0]);
    }
    
    public void act()
    {
        GreenfootImage[][] sprite = idleSprites;
        int movement = 0;
        if (Greenfoot.isKeyDown("left"))
            movement--;
        if (Greenfoot.isKeyDown("right"))
            movement++;
        if (movement != 0) {
            sprite = walkSprites;
            isLeft = (movement == -1);
            setLocation(getX() + speed * movement, getY());
        }
        //collideFood();
        updateSprite(sprite);
    }
    
    /*
    public void collideFood() {
        List<Food> food getIntersectingObjects(Food.class);
        for (Food f : food) {
            // Handle food here, probably using polymorphism
        }
    }
    */
    
    public void updateSprite(GreenfootImage[][] newSprite) {
        // Ternary operator, shorthand for if/else
        int leftIndex = (isLeft) ? 1 : 0;
        if (newSprite != currentSprite) {
            currentSprite = newSprite;
            spriteIndex = 0;
        } else
            spriteIndex = (spriteIndex + spriteSpeed) % currentSprite[leftIndex].length;
        setImage(currentSprite[leftIndex][(int) spriteIndex]);
    }
}
