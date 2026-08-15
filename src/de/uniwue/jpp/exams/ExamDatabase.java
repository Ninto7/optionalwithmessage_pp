package de.uniwue.jpp.exams;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ExamDatabase {
    private Map<Student, Map<Exam,ExamResult>> data;
    public ExamDatabase(Map<Student, Map<Exam, ExamResult>> data) {
        this.data=data;
    }

    public Student getStudent(int matriculation) {
        for (Student s: data.keySet()){
            if(s.getMatriculation() == matriculation){
                return s;
            }
        }
        return null;
    }

    public Map<Exam, ExamResult> getAllExamWithResultsOf(Student stud) {
        if(stud==null) throw new NullPointerException();
        if (getStudent(stud.getMatriculation())== null) return null;
        return data.get(stud);
    }

    public Collection<Exam> getAllExamsOf(Student stud) {
        if(stud==null) throw new NullPointerException();
        if (getStudent(stud.getMatriculation())== null) return null;
        Map<Exam, ExamResult> temp = data.get(stud);
        return temp.keySet();
    }

    public Collection<Exam> getAllExamsOf(int matriculation) {
        Student s = getStudent(matriculation);
        if (s==null) return null;
        Map<Exam, ExamResult> temp = data.get(s);
        return temp.keySet();

    }

}
