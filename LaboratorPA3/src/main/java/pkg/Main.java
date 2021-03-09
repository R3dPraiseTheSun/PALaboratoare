package pkg;

import org.junit.jupiter.api.Test;
import pkg.examples.LabExample;
import pkg.examples.TravelPlan;

public class Main {
    public static void main(String[] args) {
        LabExample.problem();
        //new TravelPlan();
    }

    @Test
    public void testProblem()
    {
        LabExample.problem();
    }
}
