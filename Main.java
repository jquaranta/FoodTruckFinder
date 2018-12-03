import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FoodTruckFinder search = new FoodTruckFinder();
        int index = 0;
        String input;
        Boolean inputting;
        Scanner in = new Scanner(System.in);

        System.out.println("~San Francisco Food Truck Finder~");

        System.out.println("Searching and sorting...");
        ArrayList<FoodTruck> trucks = search.FindTrucks();
        System.out.println("Success!\n");

        //central loop
        while(true)
        {
            System.out.format("%-3c %-40s %-1s %n", '#', "Name", "Address");
            for (int i = index; i < index + 10; i++)
            {
                if (i < trucks.size())
                {
                    System.out.format("%-3d %-40s %-1s %n", i + 1, trucks.get(i).getName(),  trucks.get(i).getAddress());
                }
            }
            if (index + 10 < trucks.size())
            {
                System.out.println("\"next\" to view next page");
            }
            if (index > 0)
            {
                System.out.println("\"previous\" to view previous page");
            }

            inputting = true;
            while(inputting)
            {
                input = in.nextLine();
                if (input.equals("next"))
                {
                    if(index + 10 < trucks.size())
                    {
                        index = index + 10;
                        inputting = false;
                    }
                    else
                    {
                        System.out.println("you are already on the last page");
                    }
                }
                else if (input.equals("previous"))
                {
                    if(index > 0)
                    {
                        index = index - 10;
                        inputting = false;
                    }
                    else
                    {
                        System.out.println("you are already on the first page");
                    }
                }
                else
                {
                    System.out.println("please input a valid command");
                }
            }
        }

    }
}
