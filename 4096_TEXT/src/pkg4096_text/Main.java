package pkg4096_text;
import java.util.Random; 

/*
Project: 2048 Java Clone
File Name: 4096_TEXT
Author: James Costo
Last Compiled: 10/31/2018 10:31 AM
Compiled in NetBeans 8.2
*/

public class Main 
{
    public static void main(String[] args) 
    {
        Random rand = new Random();
        long[][] board = new long[4][4];
        boolean retry = true;
        
        System.out.println("Use the arrow keys to move the board.");
        
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
