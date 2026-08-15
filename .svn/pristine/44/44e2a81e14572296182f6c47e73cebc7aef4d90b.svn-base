package de.uniwue.jpp.exams;

import java.util.Objects;

public class Exam {
    private boolean isWinterTerm;
    private int year;
    private String name;

    public Exam(int year, boolean isWinterTerm, String name){
        if (name == null){
            throw new NullPointerException();
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty!");
        }
        this.name = name;
        this.isWinterTerm= isWinterTerm;
        this.year=year;
    }

    public int getYear() {
        return year;
    }

    public boolean isWinterTerm() {
        return isWinterTerm;
    }

    public String getName() {
       return name;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if (o.getClass() == getClass()){
            if (((Exam) o).getName() == getName() && ((Exam) o).isWinterTerm() == isWinterTerm() && ((Exam) o).getYear() == getYear()){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {

        return Objects.hash(year, isWinterTerm, name);
    }

    @Override
    public String toString() {
        if(isWinterTerm()){
            return "Exam \""+name+"\" "+year+" WS";
        }else {
            return "Exam \""+name+"\" "+year+" SS";
        }
    }
}
