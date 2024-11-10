import java.util.*;
import java.util.ArrayList;

public class ZipCode {

    private int zipCode;
    private String barCode;
    private ArrayList<Integer> indInt = new ArrayList<>();

    // Arrays that represent bar encoded patterns for each digit from 0 to 9
    private static final String[] patterns = {
        "||:::",    // 0 
        ":::||",    // 1
        "::|:|",    // 2
        "::||:",    // 3
        ":|::|",    // 4
        ":|:|:",    // 5
        ":||::",    // 6
        "|:::|",    // 7
        "|::|:",    // 8
        "|:|::"     // 9
    };

    // Constructor for zipcode to barcode conversion
    public ZipCode(int zipCode)
    {
        this.zipCode = zipCode;
        sliceInt(zipCode);
        this.barCode = convertZtoB(zipCode);
    }

    // Constructor for barcode to zipcode conversion
    // public Zipcode(String barCode)
    // {
    //     this.barCode = barCode;
    //     sliceInt(zipCode);
    //     this.zipCode = Integer.valueOf((convertBtoZ(barCode)));
    // }

    // Convert ZIP code to bar code
    public String convertZtoB(int zip)
    {
        String tempBar = "|";
        System.out.println(indInt.size());
        for(int i = indInt.size()-1; i >= 0; i--)
        {
            tempBar+=patterns[indInt.get(i)];
        }
        return tempBar+"|";
    }

    // Convert barcode to ZIP code
    // public String convertBtoZ(String barCode)
    // {
        
    // }


    public void sliceInt(int nums)
    {
        int i = 10;
        
        while(i < nums*10)
        {
            int value = -1;
            
            value = nums%i;
            
            if(value > 10)
            {
                i /=10;
                value = value/i;
                i*=10;
            }
            indInt.add(value);
            i*=10;
        }
    }


    // Method to get the barcode
     public String getBarcode()
     {
        return barCode;
     }

     // Method to get the zipcode
    //  public int getZIPcode()
    //  {
    //     return zipCode;
    //  }
}


