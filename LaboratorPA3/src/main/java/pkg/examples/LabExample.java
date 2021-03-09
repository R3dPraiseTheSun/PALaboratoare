package pkg.examples;

import pkg.city.City;
import pkg.location.Location;
import pkg.location.types.Church;
import pkg.location.types.Hotel;
import pkg.location.types.Museum;
import pkg.location.types.Restaurant;
import pkg.solution.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LabExample {
    public static void problem(){
        City city = new City(
                new Hotel("v1",true,true,true),
                new Museum("v2",true,false,false),
                new Museum("v3",true,true,false),
                new Church("v4",true,false,true),
                new Church("v5",false,false,false),
                new Restaurant("v6",true,true,true)
        );

        city.getLocationByIndex(0).addDistance(city.getLocationByIndex(1),10);
        city.getLocationByIndex(0).addDistance(city.getLocationByIndex(2),50);
        city.getLocationByIndex(1).addDistance(city.getLocationByIndex(2),20);
        city.getLocationByIndex(2).addDistance(city.getLocationByIndex(1),20);
        city.getLocationByIndex(1).addDistance(city.getLocationByIndex(3),20);
        city.getLocationByIndex(1).addDistance(city.getLocationByIndex(4),10);
        city.getLocationByIndex(2).addDistance(city.getLocationByIndex(3),20);
        city.getLocationByIndex(3).addDistance(city.getLocationByIndex(4),30);
        city.getLocationByIndex(4).addDistance(city.getLocationByIndex(3),30);
        city.getLocationByIndex(3).addDistance(city.getLocationByIndex(5),10);
        city.getLocationByIndex(4).addDistance(city.getLocationByIndex(5),20);

        city.showLocations();
        city.getLocationTimes();

        city.getLocationByIndex(0).setOpeningHours(12,30);
        city.getLocationByIndex(0).setClosingHours(16,0);

        city.getLocationByIndex(1).setOpeningHours(16,30);
        city.getLocationByIndex(1).setClosingHours(20,0);

        city.getLocationByIndex(2).setOpeningHours(11,0);
        city.getLocationByIndex(2).setClosingHours(20,0);

        city.getLocationByIndex(5).setOpeningHours(8,0);
        city.getLocationByIndex(5).setClosingHours(10,30);

        showVisitablePayable(city);

        showLocationsDuration(city);

        new Solution.ShortestPath(city.getLocationByIndex(0),city.getLocationByIndex(4));

    }

    public static void showLocationsDuration(City city){
        List<Location> locationList = city.getAllLocations();
        for(Location location : locationList)
        {
            if(location.getVisitable())
                System.out.println("Locatia " + location.getName() + " este deschisa de la " +
                    location.getOpeningHours() + " pana la " + location.getClosingHours() + "\n" +
                    location.getEventDuration());
        }
    }

    public static void showVisitablePayable(City city){
        List<Location> visitablePayableLocations = new ArrayList<>();
        visitablePayableLocations.addAll(city.getLocationsType(true,true,true));
        visitablePayableLocations.addAll(city.getLocationsType(true,true,false));

        Collections.sort(visitablePayableLocations);

        for(Location location : visitablePayableLocations)
            System.out.println(location.getName() + " " + location.getOpeningHours() + "||" + location.getClosingHours());
    }
}
