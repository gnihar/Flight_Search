import java.io.FileNotFoundException;
import java.util.Scanner;


public class FlightMain {
    public static void main(String args[]) throws FileNotFoundException {

        Scanner sc=new Scanner(System.in);
        String dept_loc,arrival_loc,date;
        int choiceCode;

        System.out.print("Enter Departure Location  : ");
        dept_loc=sc.nextLine().toUpperCase();
        System.out.print("Enter Arrival Location  : ");
        arrival_loc=sc.nextLine().toUpperCase();
        System.out.print("Enter Date   : ");
        date=sc.nextLine().toUpperCase();
        System.out.print("Enter Output Preference :   1. Fare \t 2. Flight Duration \nEnter Preference Choice Code : ");
        choiceCode=sc.nextInt();

        FlightController fc=new FlightController();

        fc.searchFlight("src/FlightInformation/AIR FRANCE",dept_loc,arrival_loc,date);
        fc.searchFlight("src/FlightInformation/BRITISH AIRWAYS",dept_loc,arrival_loc,date);
        fc.searchFlight("src/FlightInformation/LUFTHANSA AIRLINES",dept_loc,arrival_loc,date);
        fc.updateView(choiceCode);

    }

}
