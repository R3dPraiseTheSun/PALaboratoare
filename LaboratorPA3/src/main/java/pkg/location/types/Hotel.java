package pkg.location.types;

import pkg.location.Location;

public class Hotel extends Location {
    public Hotel(String name, boolean visitable, boolean payable, boolean classified){
        this.setName(name);
        this.setVisitable(visitable);
        this.setPayable(payable);
        this.setClassified(classified);
        this.setType(getClass().getSimpleName());
        if(visitable) {
            setDefaultHours();
        }
    }

    @Override
    public int compareTo(Location comparedLocation) {
        return this.getOpeningHours().compareTo(comparedLocation.getOpeningHours());
    }
}
