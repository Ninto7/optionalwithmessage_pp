package de.uniwue.jpp.exams;


public class ExamResult {
    private int maxPoints;
    private int requiredPoints;
    private int points;

    public ExamResult(int maxPoints, int points, int requiredPoints) {
        if (maxPoints<0|| points<0||requiredPoints<0) throw new IllegalArgumentException("parameters cannot be negative");
        if (points>maxPoints) throw new IllegalArgumentException("points cannot be greater than maxPoints!");
        if (requiredPoints>maxPoints) throw new IllegalArgumentException("requiredPoints cannot be greater than maxPoints!");
        this.maxPoints=maxPoints;
        this.requiredPoints=requiredPoints;
        this.points=points;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public int getPoints() {
        return points;
    }

    public int getRequiredPoints() {
        return requiredPoints;
    }

    public boolean isPassed() {
        if (points>= requiredPoints) return true;
        return false;
    }

    @Override
    public String toString() {
        if (isPassed()){
            return "ExamResult "+points+"/"+maxPoints+" points (passed)";
        }else {
            return "ExamResult "+points+"/"+maxPoints+" points (not passed)";
        }
    }
}
