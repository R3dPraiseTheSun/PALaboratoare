package Compulsory;

public class Problem {
    public static void main(String[] args){
        int[] arrsource1 = {2,3,1};
        int[] arrsource2 = {5,4,8};
        int[] arrsource3 = {5,6,8};

        Source source1 = new Source("shop1",SourceTypes.FACTORY,arrsource1);
        Source source2 = new Source("shop2",SourceTypes.WAREHOUSE,arrsource2);
        Source source3 = new Source("shop3",SourceTypes.WAREHOUSE,arrsource3);
        Destination destination1 = new Destination("city1");
        Destination destination2 = new Destination("city2");
        Destination destination3 = new Destination("city3");

        System.out.print("\t" + destination1.getName() + " " + destination2.getName() + " " + destination3.getName());
        System.out.print("\n" + source1.getName() + "\t");
        int[] source1capacity = source1.getCapacity();
        for(int index=0;index<source1capacity.length;index++)
            System.out.print(source1capacity[index] + "\t");
        System.out.print("\n" + source2.getName()+"\t");
        int[] source2capacity = source2.getCapacity();
        for(int index=0;index<source2capacity.length;index++)
            System.out.print(source2capacity[index] + "\t");
        System.out.print("\n" + source3.getName()+"\t");
        int[] source3capacity = source3.getCapacity();
        for(int index=0;index<source2capacity.length;index++)
            System.out.print(source3capacity[index] + "\t");
    }
}
