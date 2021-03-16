package pkg;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomExample {
    public RandomExample() {
        Faker faker = new Faker();
        Random random = new Random();
        Stream<Student> studentStream = Stream.empty();
        Stream<School> schoolStream = Stream.empty();

        studentStream = IntStream.rangeClosed(0, 3)
                .mapToObj(index -> new Student(faker.name().name()));
        schoolStream = IntStream.rangeClosed(0, 2)
                .mapToObj(index -> new School(faker.name().name() + " Highschool", random.nextInt(2)));

        System.out.println("\n-------------Studenti-------------");
        LinkedList<Student> studentLinkedList = new LinkedList<Student>();
        studentStream.forEach(studentLinkedList::add);
        studentLinkedList.sort(new Student.Sortbyname());
        studentLinkedList.forEach(student -> System.out.println(student.getStudentName()));

        System.out.println("\n-------------Scoli-------------");
        TreeSet<School> schoolTreeSet = new TreeSet<>();
        schoolStream.forEach(schoolTreeSet::add);
        schoolTreeSet.forEach(school -> System.out.println(school.getSchoolName()));

        Map<Student, List<School>> studentsPreferences = new HashMap<Student, List<School>>();
        for(Student student:studentLinkedList)
            studentsPreferences.put(student, getRandomOrderFromTree(schoolTreeSet));

        System.out.println("\n-------------Preferintele studentilor-------------");
        for(Student key: studentsPreferences.keySet())
            System.out.println(key.getStudentName() + " " + studentsPreferences.get(key));

        Map<School, List<Student>> schoolPreferences = new HashMap<School, List<Student>>();
        for(School school:schoolTreeSet)
            schoolPreferences.put(school,getRandomOrderFromLinkedList(studentLinkedList));

        System.out.println("\n-------------Preferintele scolilor-------------");
        for(School key: schoolPreferences.keySet())
            System.out.println(key.getSchoolName() + " " + schoolPreferences.get(key));

        System.out.println("\n-------------Preferinte comune studenti-------------");
        OptionalFunctions optionalFunctions = new OptionalFunctions();
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(studentLinkedList.get(0));
        studentList.add(studentLinkedList.get(2));
        optionalFunctions.getAcceptableSchools(studentsPreferences,studentList);

        System.out.println("\n-------------Preferinte comune scoli-------------");
        List<School> schoolList = new ArrayList<School>();
        schoolList.add(schoolTreeSet.first());
        schoolList.add(schoolTreeSet.last());
        optionalFunctions.getFirstStudents(schoolPreferences,schoolList);

        System.out.println("\n-------------Admiterile-------------");

        new RandomExampleSolution(studentsPreferences,schoolPreferences);
    }
    private List<School> getRandomOrderFromTree(TreeSet<School> schoolTreeSet) {
        int listSize = new Random().nextInt(2)+1;
        List<School> randomSchoolList = new ArrayList<School>(listSize);
        while (listSize > 0) {
            int size = schoolTreeSet.size();
            int item = new Random().nextInt(size);
            int i = 0;
            for (School school : schoolTreeSet) {
                if (i == item)
                    randomSchoolList.add(school);
                i++;
            }
            listSize--;
        }
        return randomSchoolList;
    }

    private List<Student> getRandomOrderFromLinkedList(LinkedList<Student> studentLinkedList){
        int listSize = new Random().nextInt(2)+1;
        List<Student> randomStudentList = new ArrayList<Student>(listSize);
        while (listSize > 0) {
            int size = studentLinkedList.size();
            int item = new Random().nextInt(size);
            randomStudentList.add(studentLinkedList.get(item));
            listSize--;
        }
        return randomStudentList;
    }
}
