import java. util.*;

public class Game {
    private static int marbles;  //Marble Size
    private Human humanPlayer;  
    private Computer computerPlayer;
    private boolean isTurn;               //true = player & false = computer
    private Scanner input;

    public Game(int difficulty)
    {
        marbles = (int)(Math.random()*91 + 10);
        this.humanPlayer = new Human();
        this.computerPlayer = new Computer(difficulty); 
        if((int)(Math.random()*2) == 1)           //1 = player  & 0 = computer
        {
            isTurn = true;
        } 
        this.input = new Scanner(System.in);
    }

    public void play()
    {
        System.out.println("Here is the starting Marbles: " + marbles);
        while(marbles > 1)
        {
            if(isTurn)                      //Player's turn
            {
                System.out.println("It's your turn! How many marbles will you take? : ");
                int humanDecision = input.nextInt();
                while(humanPlayer.isValid(humanDecision))
                {
                    System.out.println("Invalid move! Enter a number between 1 and " + getMarbles() /2 + ": ");
                    humanDecision = input.nextInt();
                }
                changeMarble(humanDecision);
                switchTurns();
                System.out.println("You took this much marbles: " + humanPlayer.getChoice() + "\n" + "Marbles still left: " + getMarbles());
            }
           else                               //Computer's turn
           {
                System.out.println("***It's the computer's turn! ");
                computerPlayer.move();
                switchTurns();
                System.out.println("***The computer took: " + computerPlayer.getChoice() + "\n" + "Marbles still left: " + getMarbles());
           }
        }

    if(isTurn)
    {
        System.out.println("Human takes the last marble. Computer wins!!");
    } 
    else
    {
        System.out.println("Computer takes the last marble. Human wins!!");
    }

    }

    public static int getMarbles()
    {
       return marbles;
    }

    public static void changeMarble(int subtFrom)
    {
        marbles -= subtFrom;
    }

    public void switchTurns()
    {
        isTurn = !isTurn; 
    }
}
