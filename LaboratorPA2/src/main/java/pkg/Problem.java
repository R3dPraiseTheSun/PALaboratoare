package pkg;

public class Problem {
    public Problem() {
        int[] arrSource1 = {2, 3, 1};
        int[] arrSource2 = {5, 4, 8};
        int[] arrSource3 = {5, 6, 8};

        Source[] sources = new Source[3];
        sources[0]=new Factory("Shop1",arrSource1,10);
        sources[1]=new Warehouse("Shop2",arrSource2,35);
        sources[2]=new Warehouse("Shop3",arrSource3,25);

        //destination
        Destination[] destinations = new Destination[3];
        destinations[0]=new Destination("Destination1",20);
        destinations[1]=new Destination("Destination2",25);
        destinations[2]=new Destination("Destination3",25);

        Solution solution = new Solution(sources, destinations);
        solution.printSources();
        solution.printDestinations();
        solution.printMatrix();
        solution.solveProblem();
    }
}
