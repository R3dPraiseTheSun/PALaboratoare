package pkg;

public class School  implements Comparable<School> {
    private String schoolName;
    private int capacity;

    public School(String name)
    {
        this.schoolName = name;
    }
    public School(String name, int capacity) {
        this.schoolName = name;
        this.capacity = capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public String getSchoolName(){
        return this.schoolName;
    }

    public int compareTo(School school) {
        return this.getSchoolName().compareTo(school.getSchoolName());
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + schoolName + '\'' +
                '}';
    }
}
