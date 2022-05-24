package com.niit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class RoutePlanner {
    public String[] readFile(String filepath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            BufferedReader br1 = new BufferedReader(new FileReader(filepath));
            String line = br.readLine();
            int numberOfLines = 0;
            while (line != null) {
                //System.out.println(line);
                numberOfLines++;
                line = br.readLine();
            }
            //System.out.println("number of lines: " + numberOfLines);
            String[] routes = new String[numberOfLines];
            String line1 = br1.readLine();
            int j = 0;
            while (line1 != null) {
                routes[j] = line1;
                j++;
                line1 = br1.readLine();
            }
            System.out.format("%20s %22s %20s %18s %15s %n", "Source", "Destination", "Distance_in_KM", "TravelTime", "TicketFare");

            for (int i = 0; i < numberOfLines; i++) {
                //System.out.println(routes[i]);
                String[] splitLine = routes[i].split(",");
                for (int k = 0; k < splitLine.length; k++) {
                    System.out.format("%20s", splitLine[k]);
                }
                System.out.println();
            }
            return routes;
        }
    }

    public String[] showDirectFlight(String[] routeInfo, String sourceCity) {
        System.out.println("source city= " + sourceCity + "\n\n");
        int flag = 0;
        for (int i = 0; i < routeInfo.length; i++) {
            String[] splitRoute = routeInfo[i].split(",");
            if (sourceCity.equalsIgnoreCase(splitRoute[0])) {
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("We are sorry. At this point of time, we do not have any information on flights originating from  " + sourceCity);
            return null;
        } else {
            System.out.format("%20s %22s %20s %18s %15s %n", "Source", "Destination", "Distance_in_KM", "TravelTime", "TicketFare");

            String[] requiredRoutes = new String[flag];
            int l = 0;
            for (int i = 0; i < routeInfo.length; i++) {
                String[] splitRoute = routeInfo[i].split(",");
                if (sourceCity.equalsIgnoreCase(splitRoute[0])) {
                    requiredRoutes[l] = routeInfo[i];
                    l++;
                    for (int k = 0; k < splitRoute.length; k++) {
                        System.out.format("%20s", splitRoute[k]);
                    }
                    System.out.println();
                }
            }
            return requiredRoutes;
        }

    }

    public String[] sortDirectFlight(String[] directFlights) throws NullPointerException {
        if (directFlights == null) {
            System.out.println("array is null,nothing to sort");
            return null;
        } else {
            System.out.format("%20s %22s %20s %18s %15s %n", "Source", "Destination", "Distance_in_KM", "TravelTime", "TicketFare");
            String[] sortedArray = new String[directFlights.length];
            Arrays.sort(directFlights);

            for (int i = 0; i < directFlights.length; i++) {
                sortedArray[i] = directFlights[i];
                String[] splitLine = directFlights[i].split(",");
                for (int k = 0; k < splitLine.length; k++) {
                    System.out.format("%20s", splitLine[k]);
                }
                System.out.println();

            }
            return sortedArray;
        }
    }

    public void showAllConnection(String[] routeInfo, String source, String destination) {
        System.out.println("Source entered by the user is: " + source + "\nDestination entered by the user is: " + destination);
        int count = 0, j = 0;
        //String destinationArray[]=new String[routeInfo.length];
        for (int i = 0; i < routeInfo.length; i++) {
            String[] splitroute = routeInfo[i].split(", ");
            //destinationArray[i]=routeInfo[i];
            if (destination.equalsIgnoreCase(splitroute[1])) {
                count++;
            }
        }
        if(count>0) {
            String[] city = new String[count];
            //System.out.println("all the destinations one can go to: ");
            for (int i = 0; i < routeInfo.length; i++) {
                String[] splitroute = routeInfo[i].split(", ");
                if (destination.equalsIgnoreCase(splitroute[1])) {
                    city[j] = routeInfo[i];
                    j++;
                }
            }
            //System.out.println("city with destination as given by user: ");
//            for(int l=0;l<count;l++)
//                System.out.println(city[l]);

            System.out.println("\n\nBoth Direct and Indirect routes:\n\n");
            System.out.format("%20s %22s %20s %18s %15s %n", "Source", "Destination", "Distance_in_KM", "TravelTime", "TicketFare");
            for (int i = 0; i < routeInfo.length; i++) {
                String[] splitroute = routeInfo[i].split(", ");
                if(source.equalsIgnoreCase(splitroute[0]) && destination.equalsIgnoreCase(splitroute[1]))
                {
                    System.out.println("Direct Route");
                    for (int k = 0; k < splitroute.length; k++) {
                        System.out.format("%20s", splitroute[k]);
                    }
                    System.out.println();
                }
                for(int l=0;l<count;l++) {
                    String[] splitcity=city[l].split(", ");
                    if ((source.equalsIgnoreCase(splitroute[0]) && splitroute[1].equalsIgnoreCase(splitcity[0]))) {
                        System.out.println("Indirect Routes");
                        for (int k = 0; k < splitroute.length; k++) {
                            System.out.format("%20s", splitroute[k]);
                        }
                        System.out.println();
                        for (int k = 0; k < splitroute.length; k++) {
                            System.out.format("%20s", splitcity[k]);
                        }
                        System.out.println();
                    }
                }
            }
        }
        else
        {
            System.out.println("There are neither connecting nor direct flights to "+destination+" currently");
        }
    }
}


