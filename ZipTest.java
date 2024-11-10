import java.util.Scanner;
public class ZipTest {
     public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);

        //Convert from ZIP to bar code
        System.out.println("Please enter a ZIP code: ");
        int zip = input.nextInt();
        input.nextLine();
        ZipCode code1 = new ZipCode(zip);
	    System.out.println("The corresponding bar code: ");
        System.out.println(code1.getBarcode());

        //Convert from bar to ZIP code
	    // System.out.println("Now please provide a bar code: ");
	    // String bar = input.nextLine();
	    // ZipCode code2 = new ZipCode(bar);
	    // System.out.println("The corresponding ZIP code: ");
	    // System.out.println(code2.getZipCode());
    }
}
