package pkg4096_text;
import java.util.Random;
import java.util.Scanner;

/*
Project: 2048 Java Clone
File Name: 4096_TEXT
Author: James Costo
Last Compiled: 11/05/2018 9:34 AM
Compiled in NetBeans 8.2
*/

public class Main 
{
    public static void main(String[] args) 
    {
        Random rand = new Random();
        long[][] board = new long[4][4];
        boolean retry = true;
        Scanner keyboard = new Scanner (System.in);
        char movement;
        int xMove = 0, yMove = 0;
        
        System.out.println("Use the WASD keys to move the board.");
        
        // insert game loop start here
        
        while (retry == true)
        {
            int x = rand.nextInt(3),
                y = rand.nextInt(3);
            
            if (board[y][x] == 0)
            {
                retry = false;
                board[y][x] = newValue();
            }
        }
        showBoard(board);
        
        // Get movement key
        movement = keyboard.nextLine().charAt(0);
        
        switch (movement)
        {
            case 'W':
            case 'w':
                yMove = -1;
                break;
            case 'S':
            case 's':
                yMove = 1;
                break;
            case 'A':
            case 'a':
                xMove = -1;
                break;
            case 'D':
            case 'd':
                xMove = 1;
                break;
        }
        
        // move stuff
        System.out.println(yMove + " " + xMove);
        boolean moving = true;
        for (int iter = 0; iter <4; iter++)
        {
            if (yMove != 0)
            {
                if (yMove > 0)
                {
                    // start at bottom
                    for (int y = 2; y >= 0; y--)
                    {
                        for (int x = 0; x < 4; x++)
                        {
                            if (board[y+yMove][x] == 0)
                            {
                                board[y+yMove][x] = board[y][x];
                                board[y][x] = board[y-yMove][x];
                            }
                        }
                    }
                }
                else if (yMove < 0)
                {
                    // start at top
                }
            }
        }
        showBoard(board);
        
        // when player moves board with arrow keys, move values (keylistener, key binding, what?)
        // if same values collide (or target value is zero), add them, else don't move them
        // after moving all values, add new values to score, then create new random value
    }
    
    // Displays the board
    public static void showBoard(long[][] board)
    {
        for (int y = 0; y<4; y++)
        {
            for (int x = 0; x<4; x++)
            {
                System.out.print(board[y][x] + " ");
            }
            System.out.println("");
        }
    }
    
    // Creates a new value to place in an empty space on the board
    public static long newValue()
    {
        Random rand = new Random();
        double flag = rand.nextDouble();
                
        if (flag < 0.75)
        {
            // Set the generated value to 2
            return 2;
        }
        else
        {
            // Set the generated value to 4
            return 4;
        }
    }
}
