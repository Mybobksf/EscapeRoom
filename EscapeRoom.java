/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.awt.Image;
import java.util.Scanner;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{

      // describe the game with brief welcome message
      // determine the size (length and width) a player must move to stay within the grid markings
      // Allow game commands:
      //    right, left, up, down: if you try to go off grid or bump into wall, score decreases
      //    jump over 1 space: you cannot jump over walls
      //    if you land on a trap, spring a trap to increase score: you must first check if there is a trap, if none exists, penalty
      //    pick up prize: score increases, if there is no prize, penalty
      //    help: display all possible commands
      //    end: reach the far right wall, score increase, game ends, if game ended without reaching far right wall, penalty
      //    replay: shows number of player steps and resets the board, you or another player can play the same board
      // Note that you must adjust the score with any method that returns a score
      // Optional: create a custom image for your player use the file player.png on disk
    
      /**** provided code:
      // set up the game
      boolean play = true;
      while (play)
      {
        // get user input and call game methods to play 
        play = false;
      }
      */

  public static void main(String[] args) 
  {      
    // welcome message
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,");
    System.out.println("pick up all the prizes.\n");
    
    GameGUI game = new GameGUI();
    game.createBoard();

    // size of move
    int m = 60; 
    // individual player moves
    int px = 0;
    int py = 0; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jump", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?"};
  
    // set up game
    boolean play = true;
    while (play)
    {
      /* TODO: get all the commands working */
	  /* Your code here */
      System.out.print("Where do you want to move? ");
      Scanner scanner = new Scanner(System.in);
      String control = scanner.nextLine();
      switch(control){
        case "right":
          case "r":
            score += game.movePlayer(m,0);
            break;
        case "left":
          case "l":
            score += game.movePlayer(-m,0);
            break;
        case "up":
          case "u":
            score += game.movePlayer(0,-m);
            break;
        case "down":
          case "d":
            score += game.movePlayer(0,m);
            break;
        case "jump":
          case "jr":
            score += game.movePlayer(2*m,0);
            break;
        case "jumpleft":
          case "jl":
            score += game.movePlayer(2*-m,0);
            break;
        case "jumpup":
          case "ju":
            score += game.movePlayer(0,2*-m);
            break;
        case "jumpdown":
          case "jd":
            score += game.movePlayer(0,2*m);
            break;
        case "pickup":
          case "p":
            score += game.pickupPrize();
            break;
        case "quit":
          case "q":
            score+=game.endGame();
            System.out.println("score=" + score);
            System.out.println("steps=" + game.getSteps());
        case "help":
          case "?":
            System.out.println("right or r moves the player right. left of l moves the player left. up or u moves the player up. down or d moves the player down. jump or jr moves the player right 2 squares. jumpleft or jl moves the player left 2 squares. jumpup or ju moves the player up 2 squares. jumpdown or jd moves the player down 2 squares. pickup or p picks up the coin when tou are on a square with a coin. quit or q ends the game. replay goes back to first square.");
          break;
        case "replay":
          System.out.println(score);
          score = 0;
          break;
      }
    }

  

    score += game.endGame();

    System.out.println("score=" + score);
    System.out.println("steps=" + game.getSteps());
  }
}

        
