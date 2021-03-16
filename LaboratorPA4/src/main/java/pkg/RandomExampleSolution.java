package pkg;

import java.util.List;
import java.util.Map;

public class RandomExampleSolution {
    public RandomExampleSolution(Map<Student,List<School>> studentPreferences, Map<School,List<Student>> schoolPreferences){
        int index = 0;
        int subindex = 0;
        for(School school: schoolPreferences.keySet())
        {
            if(index >= schoolPreferences.get(school).size())
                continue;
            for(Student student: studentPreferences.keySet())
            {
                if(schoolPreferences.get(school).get(index).equals(student)) {
                    System.out.println(school.getSchoolName() + " il/o admite pe " + student.getStudentName());
                    studentPreferences.remove(student);
                    break;
                }
            }
            index++;
        }
    }
}
