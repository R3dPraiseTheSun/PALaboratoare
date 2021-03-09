package pkg.city;

import pkg.location.Location;

import java.util.*;

public class City {
    private final List<Location> locationsList;
    private List<Location> locationsPreferences;

    public City(){
        locationsList = new ArrayList<Location>();
    }
    public City(Location ... locations){
        locationsList = new ArrayList<Location>();
        Collections.addAll(locationsList, locations);
    }

    public void setPreferences(Location...locations){
        locationsPreferences = new ArrayList<Location>();
        Collections.addAll(locationsPreferences, locations);
    }

    public void showPreferences(){
        System.out.println("Prefer sa merg:");
        for(Location location : locationsPreferences)
            System.out.println(location.toString());
    }

    public void showLocations(){
        for(Location location : locationsList)
        {
            System.out.print(location.toString() + "\n");
        }
    }

    public void showLocationsType(boolean isVisitable, boolean isPayable, boolean isClassified){
        for (Location location : locationsList) {
            if ((location.getVisitable() == isVisitable) && (location.getPayable() == isPayable) && (location.getClassified() == isClassified)) {
                System.out.println(location.getName());
            }
        }
    }

    public List<Location> getLocationsType(boolean isVisitable, boolean isPayable, boolean isClassified){
        List<Location> selectedLocations = new ArrayList<Location>();
        for (Location location : locationsList) {
            if ((location.getVisitable() == isVisitable) && (location.getPayable() == isPayable) && (location.getClassified() == isClassified)) {
                selectedLocations.add(location);
            }
        }
        return selectedLocations;
    }

    public void addLocation(Location location){
        locationsList.add(location);
    }

    public Location getLocationByIndex(int index){
        return locationsList.get(index);
    }
    public Location getLocationByName(String locationName){
        for (Location location : locationsList)
            if (location.getName().equals(locationName))
                return location;
        return null;
    }
    public List<Location> getAllLocations(){
        return this.locationsList;
    }

    public String getLocationTime(Location location){
        return location.getOpeningHours() + location.getClosingHours();
    }
    public void getLocationTimes(){
        for(Location locationStart : locationsList)
            for(Location locationEnd : locationsList)
                if(locationStart.getTimes(locationEnd) != null)
                    System.out.println(locationStart.getName() + " -> " + locationEnd.getName() + " = " + locationStart.getTimes(locationEnd));
    }
}
