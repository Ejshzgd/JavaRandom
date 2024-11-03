import java. util.*;

public class Computer{

    private int choice;
    private boolean isHard;

    public Computer(int m){
        if(m == 1) //stupid mode
        {
            isHard = true;
        }
        choice = -1;
    }

    public void move() 
    {
        if(isHard)           //stupid move
        {
            choice = moveRandom();
            Game.changeMarble(choice);
        }
        else               //Smart move
        {
            if(Game.getMarbles() > 3)
            {
                int[] powers = {3, 7, 15, 31 , 63};

                for(int target: powers)
                {
                    if(target < Game.getMarbles() && target >= Game.getMarbles() / 2)
                    {
                        choice = Game.getMarbles()-target;
                        Game.changeMarble(choice);                 ///maybe add a break
                    }
                    
                }
            }
            else
            {
                Game.changeMarble(moveRandom());
            }

        }
    }

    public int getChoice(){
        return choice;
    }


    public int moveRandom()
    {
        return (int) (Math.random()*(Game.getMarbles()/2)+1);
    }

}