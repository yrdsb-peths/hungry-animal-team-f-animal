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

## Polymorphism:
Polymorphism is used within the food class so that multiple types of food don't have to be checked for collision with the player individually. It simplifies code and makes adding new food easier. 

## Overrides
Overrides are used in the GameOverable interface and the Food class so behaviours can be set on a class-by-class basis when needed.

## Interfaces
We made a GameOverable interface that allows us to quickly remove objects when the GameOver event happens.
