import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Collections;

public class FlightController {
    ArrayList<FlightModel> flightList=new ArrayList<FlightModel>();
    ArrayList<String> arr;
    FlightView view=new FlightView();

    public void searchFlight(String filename,String dept_loc,String arrival_loc,String date) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File(filename));
        while(sc.hasNext()) {
            String line = sc.nextLine().toUpperCase().toString();
            if (!line.isEmpty()) {
                StringTokenizer token = new StringTokenizer(line, "|");
                arr = new ArrayList<>(line.length());
                while (token.hasMoreTokens()) {
                    arr.add(token.nextToken());
                }
                if (arr.get(1).equals(dept_loc) && arr.get(2).equals(arrival_loc) && arr.get(3).equals(date)) {
                    FlightModel model = new FlightModel(arr.get(0), arr.get(1), arr.get(2), arr.get(3), Integer.parseInt(arr.get(4)), Float.parseFloat(arr.get(5)));
                    flightList.add(model);
                }
            }
        }
    }

    public void updateView(int choiceCode)
    {
        if(choiceCode==1)
        {
            Collections.sort(flightList, new Comparator<FlightModel>() {
                @Override
                public int compare(FlightModel o1, FlightModel o2) {
                    return o1.getFare() - o2.getFare();
                }
            });
        }
        else if(choiceCode==2)
        {
            Collections.sort(flightList, new Comparator<FlightModel>() {
                @Override
                public int compare(FlightModel o1, FlightModel o2) {
                    return (int)( o1.getDuration() - o2.getDuration());
                }
            });
        }
        else
        {
            System.out.println("Wrong Choice.");
            return;
        }
        view.viewFlights(flightList);

    }
}