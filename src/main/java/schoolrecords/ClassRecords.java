package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private List<Student> studentList = new ArrayList<>();
    private Random random;

    public ClassRecords(String className, Random random) {
        this.className = className;
        this.random = random;
    }

    public boolean addStudent(Student student) {
        for (Student scopedStudent : studentList) {
            if (student.getName().equals(scopedStudent.getName())) {
                return false;
            }
        }
        studentList.add(student);
        return true;
    }

    public boolean removeStudent(Student student) {
        for (Student s : studentList) {
            if (student.getName().equals(s.getName())) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }

    public double calculateClassAverage() {
        if (studentList.size() == 0) {
            throw new ArithmeticException("Cannot calculate average for an empty class!");
        }
        int marksSum = 0;
        int markNumbers = 0;

        for (Student s : studentList) {
            marksSum += s.getMarksSum();
            markNumbers += s.getMarkNumbers();
        }
        if (markNumbers == 0) {
            throw new ArithmeticException("Cannot calculate average as there is no mark recorded!");
        }
        return Math.floor(100d * marksSum / markNumbers) / 100;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        if (studentList.size() == 0) {
            throw new ArithmeticException("Student list is empty!");
        }
        double avgSum = 0;
        double studentAvgBySubject;
        int avgNumbers = 0;

        for (Student s : studentList) {
            studentAvgBySubject = s.calculateSubjectAverage(subject);
            if (studentAvgBySubject != 0) {
                avgSum += studentAvgBySubject;
                avgNumbers++;
            }
        }
        if (avgNumbers == 0) {
            throw new ArithmeticException("Cannot calculate as there is no mark present!");
        }
        return (100d * avgSum / avgNumbers);
    }

    public Student findStudentByName(String name) {
        if (studentList.size() == 0) {
            throw new IllegalArgumentException("Student list is empty!");
        }
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name should not be empty!");
        }
        for (Student s : studentList) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Student" + name + "cannot be found!");
    }

    public Student repetition() {
        if (studentList.size() == 0) {
            throw new IllegalStateException("No student for repetition!");
        }
        return studentList.get(random.nextInt(studentList.size()));
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        for (Student s : studentList) {
            studyResultByNames.add(new StudyResultByName(s.getName(), s.calculateAverage()));
        }
        return studyResultByNames;
    }

    public String listStudentNames() {
        StringBuilder sb = new StringBuilder();
        for (Student s : studentList) {
            sb.append(", ").append(s.getName());
        }
        return sb.delete(0, 2).toString();
    }

    public String getClassName() {
        return className;
    }
}