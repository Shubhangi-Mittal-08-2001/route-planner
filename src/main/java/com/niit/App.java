package com.niit;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        RoutePlanner routePlanner=new RoutePlanner();
        Scanner scan =new Scanner(System.in);
        final String filePath = "src/main/resources/routes.csv";

        try {
            System.out.println("Task1: reading the file and displaying in appropriate format");
            String[] routeInformation = routePlanner.readFile(filePath);
            System.out.println("Task2:Ask the user to enter the source and print all the flights there are from that source destination ");
            System.out.println("\nEnter the source City");
            String sourceCity = scan.nextLine();
            String[] directFlightArray=routePlanner.showDirectFlight(routeInformation,sourceCity);
            System.out.println("\n\nTask3: order the output from task2 on the basis of the destination city alphabetically");
            routePlanner.sortDirectFlight(directFlightArray);
            System.out.println("Task4: show direct,connecting flights from source to destination entered by the user if any");
            System.out.println("\n\nenter the source and destination");
            String source=scan.nextLine();
            String destination=scan.nextLine();
            routePlanner.showAllConnection(routeInformation,source,destination);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }



    }
}
