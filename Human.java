import java. util.*;

public class Human {
    private int choice;

    public Human(){
        this.choice = -1;
    }

    public boolean isValid(int num)
    {
        if(num >=1 && num <= Game.getMarbles()/2 )
        {
            choice = num;
            return false;
        }
        return true;                      //fix the return order later
    }
    

    public int getChoice()
    {
        return choice; 
    }
    
}
