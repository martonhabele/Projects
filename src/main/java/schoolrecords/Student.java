package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name should not be empty!");
        } else {
            this.name = name;
        }
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark should not be null!");
        }
        else {
            marks.add(mark);
        }
    }

    public double calculateSubjectAverage(Subject subject) {
        int items = 0;
        int sum = 0;
        for (Mark scopedMark : marks) {
            if (scopedMark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                sum += scopedMark.getMarkType().getRate();
                items++;
            }
        }
        if (items == 0) {
            return 0d;
        }
        return Math.floor(100d * sum / items) / 100;
    }

    public double calculateAverage() {
        int sum = 0;
        if (marks.size() == 0) {
            return 0d;
        }
        for (Mark scopedMark : marks) {
            sum += scopedMark.getMarkType().getRate();
        }
        return Math.floor(100d * sum / marks.size()) / 100;
    }

    private boolean isEmpty(String name) {
        return (name == null || name.equals(""));
    }

    public String getName() {
        return name;
    }

    public int getMarksSum() {
        int result = 0;
        for (Mark scopedMark : marks) {
            result += scopedMark.getMarkType().getRate();
        }
        return result;
    }

    public int getMarkNumbers() {
        return marks.size();
    }
}