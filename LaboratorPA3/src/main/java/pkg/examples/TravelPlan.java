package pkg.examples;

import pkg.city.City;
import pkg.location.types.Church;
import pkg.location.types.Hotel;
import pkg.location.types.Museum;
import pkg.location.types.Restaurant;

public class TravelPlan {
    public TravelPlan() {
        City iasi = new City(
        new Hotel("Hotel Unirea", true, true, true),
        new Restaurant("Moara de foc", true, true, false),
        new Restaurant("Coliba Moldovenilor", true, true, false),
        new Restaurant("YES!", true, true, false),
        new Museum("Muzeul de istorie naturala", true, true, false),
        new Museum("Muzeul Unirii", true, false, false),
        new Museum("Muzeul Universitatii", true, false, false),
        new Church("Biserica Sf. Treime", true, false, false)
        );

        iasi.getLocationByName("Hotel Unirea").addDistance(iasi.getLocationByName("Moara de foc"),40);
        iasi.getLocationByName("Hotel Unirea").addDistance(iasi.getLocationByName("Coliba Moldovenilor"),30);
        iasi.getLocationByName("Hotel Unirea").addDistance(iasi.getLocationByName("Biserica Sf. Treime"),30);
        iasi.getLocationByName("Biserica Sf. Treime").addDistance(iasi.getLocationByName("Moara de foc"),5);
        iasi.getLocationByName("Biserica Sf. Treime").addDistance(iasi.getLocationByName("Coliba Moldovenilor"),15);
        iasi.getLocationByName("Muzeul de istorie naturala").addDistance(iasi.getLocationByName("Moara de foc"),30);

        iasi.setPreferences(
                iasi.getLocationByName("Hotel Unirea"),
                iasi.getLocationByName("Biserica Sf. Treime"),
                iasi.getLocationByName("Moara de foc")
                );
        iasi.showPreferences();
    }
}
