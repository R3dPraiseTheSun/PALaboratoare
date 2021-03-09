package pkg.location.interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public interface Visitable {
    void setOpeningHours(int hour, int minute);
    void setClosingHours(int hour, int minute);

    default void setDefaultHours(){
        setOpeningHours(9,30);
        setClosingHours(20,0);
    }

    static Duration getVisitingDuration(String opening, String closing){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date d1 = null;
        try {
            d1 = sdf.parse(opening);
        } catch (ParseException err) {
            err.printStackTrace();
        }
        Date d2 = null;
        try {
            d2 = sdf.parse(closing);
        } catch (ParseException err) {
            err.printStackTrace();
        }
        return Duration.between(d1.toInstant(), d2.toInstant());
    }

    String getOpeningHours();
    String getClosingHours();
}
