package schoolrecords;

import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> subjects;

    public Tutor(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        for (Subject s : subjects) {
            if (subject.getSubjectName().equals(s.getSubjectName())) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}