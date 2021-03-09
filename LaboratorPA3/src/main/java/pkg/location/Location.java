package pkg.location;

import pkg.location.interfaces.Classifiable;
import pkg.location.interfaces.Payable;
import pkg.location.interfaces.Visitable;

import java.time.Duration;
import java.util.*;

public abstract class Location implements Visitable, Payable, Classifiable, Comparable<Location> {
    private String type;
    private String name;
    private final Map<Location, Integer> locationMap;
    private boolean isVisitable,isPayable,isClassified;

    private static class time{
        int hour, minute;

        time(int hour,int minute){
            this.hour = hour;
            this.minute = minute;
        }

        @Override
        public String toString() {
            if(this.minute < 10)
                return hour + ":0" + minute;
            return hour + ":" + minute;
        }
    }
    private time startEvent, endEvent;

    private int price;
    private int rank;

    public Location() {
        this.locationMap = new LinkedHashMap<Location,Integer>();
    }

    public void addDistance(Location location,int time){
        this.locationMap.put(location,time);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setVisitable(boolean isVisitable){
        this.isVisitable = isVisitable;
    }
    public void setPayable(boolean isPayable){
        this.isPayable = isPayable;
    }
    public void setClassified(boolean isClassified){
        this.isClassified = isClassified;
    }
    public void setType(String type){
        this.type = type;
    }

    public String getName() {
        return this.name;
    }
    public boolean getVisitable(){
        return this.isVisitable;
    }
    public boolean getPayable(){
        return this.isPayable;
    }
    public boolean getClassified(){
        return this.isClassified;
    }
    public String getType(){
        return this.type;
    }

    public String getEventDuration(){
        Duration eventDuration = Visitable.getVisitingDuration(this.startEvent.toString(),this.endEvent.toString());
        return "The location " + this.name + " is open for " + eventDuration.toMinutes()/60 + " hour/s and " + eventDuration.toMinutes()%60 + " minute/s!";
    }
    public Integer getTimes(Location location){
        return locationMap.get(location);
    }

    public Map<Location, Integer> getLocationMap(){
        return this.locationMap;
    }

    @Override
    public void setOpeningHours(int hour, int minute) {
        this.startEvent = new time(hour, minute);
    }

    @Override
    public void setClosingHours(int hour, int minute) {
        this.endEvent = new time(hour, minute);
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String getOpeningHours() {
        return this.startEvent.toString();
    }

    @Override
    public String getClosingHours() {
        return this.endEvent.toString();
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return "Location{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", isVisitable=" + isVisitable +
                ", isPayable=" + isPayable +
                ", isClassified=" + isClassified +
                '}';
    }
}