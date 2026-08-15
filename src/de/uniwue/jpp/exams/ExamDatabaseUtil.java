package de.uniwue.jpp.exams;

import java.util.Map;
import java.util.HashMap;

public class ExamDatabaseUtil {

    private ExamDatabaseUtil() {}

    public static Map<Student, Map<Exam, ExamResult>> createSampleData() {

        Map<Student, Map<Exam, ExamResult>> map = new HashMap<>();
        Student m = new Student("Max Mustermann", 123456, 20);
        Student e = new Student("Erika Musterfrau",123123,23);
        Student j = new Student("Juan Nadie", 124578, 27);
        Exam pp = new Exam(2021, false, "Programmierpraktikum");
        Exam gdp = new Exam(2021, true, "Grundlagen der Programmierung");
        Exam swt = new Exam(2021, false, "Softwaretechnik");
        Map<Exam,ExamResult> merg = new HashMap<>();
        merg.put(pp, new ExamResult(90,90,45));
        merg.put(gdp, new ExamResult(60,54,30));
        merg.put(swt, new ExamResult(60,59,30));
        map.put(m, merg);
        Map<Exam,ExamResult> eerg = new HashMap<>();
        eerg.put(pp, new ExamResult(90,37,45));
        eerg.put(gdp, new ExamResult(60,33,30));
        eerg.put(swt, new ExamResult(60,39,30));
        map.put(e, eerg);
        Map<Exam,ExamResult> jerg = new HashMap<>();
        jerg.put(pp, new ExamResult(90,63,45));
        jerg.put(gdp, new ExamResult(60,5,30));
        jerg.put(swt, new ExamResult(60,51,30));
        map.put(j, jerg);
        return map;
    }
}
