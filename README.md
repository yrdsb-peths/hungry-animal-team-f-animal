# Hungry Elephant

## Project Description
Hungry Elephant is a game developed using Greenfoot. In this game, players control a hungry elephant, trying to eat as many foods as possible.

## Game Features
- A hungry elephant
- Multiple kinds of food
- Lives system
- Score system
## How To Play
- Press the Space bar to Start 
- Use the Left and Right arrow keys to move the elephant
- Catch as many falling foods as possible
- The game ends when you miss 3 pieces of food

## Acknowledgments
This project is based on Mr. Chan's Hungry Animal tutorial. Thank you Mr. Chan for providing the resources and support!

## Abstract Class
We created an Abstract Class, Food, to have multiple different food items fall down giving different amount of scores making the game more fun. 
Creating an abstract food class allows for better organization of the different types of food, and creates a structure for the different types of food.

## Polymorphism:
Polymorphism is used with the food classes, so that collision with the player can be checked for more efficently. Polymorphism is also used when spawning new foods.  Since it is not known which type of food will be spawned, so using polymorphism will be ideal.

## Overrides
The move method is overidden for cherry. 
Since a unique set of movement was desired for the cherry, instead of the one from the food super class.

## Interfaces
We made a GameOverable interface for objects that should be removed when game is over.
This allows us to quickly remove intended objects when the game is over. 
