package pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptionalFunctions {
    public void getAcceptableSchools(Map<Student,List<School>> studentListMap, List<Student> studentList){
        List<School> schoolList = new ArrayList<School>();
        Map<School,Integer> value = new HashMap<School,Integer>();
        int index=0;
        for(Student student: studentList)
        {
            if(index >= studentListMap.get(student).size())
                continue;
            if(!schoolList.contains(studentListMap.get(student).get(index))) {
                schoolList.add(studentListMap.get(student).get(index));
                value.put(studentListMap.get(student).get(index), 1);
            }
            else
            {
                value.put(studentListMap.get(student).get(index), value.get(studentListMap.get(student).get(index)) + 1);
            }
            System.out.println(value);
            index++;
        }
    }
    public void getFirstStudents(Map<School,List<Student>> schoolListMap, List<School> schoolList){
        List<Student> studentList = new ArrayList<Student>();
        Map<Student, Integer> value = new HashMap<>();
        int index=0;
        for(School school: schoolList)
        {
            if(index >= schoolListMap.get(school).size())
                continue;
            if(!studentList.contains(schoolListMap.get(school).get(index))) {
                studentList.add(schoolListMap.get(school).get(index));
                value.put(schoolListMap.get(school).get(index), 1);
            }
            else
            {
                value.put(schoolListMap.get(school).get(index), value.get(schoolListMap.get(school).get(index)) + 1);
            }
            System.out.println(value);
            index++;
        }
    }
}
