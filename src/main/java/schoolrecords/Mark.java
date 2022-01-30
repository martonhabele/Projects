package schoolrecords;

public class Mark {
    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        if (isValid(subject, tutor)) {
            this.markType = markType;
            this.subject = subject;
            this.tutor = tutor;
        }
    }

    public Mark(String markType, Subject subject, Tutor tutor) {
        if (isValid(subject, tutor)) {
            this.markType = MarkType.valueOf(markType);
            this.subject = subject;
            this.tutor = tutor;
        }
    }

    @Override
    public String toString() {
        return markType.getRating() + " (" + getMarkType().getRate() + ")";
    }

    private boolean isValid(Subject subject, Tutor tutor) {
        if (subject != null && tutor != null && !subject.equals("") && !tutor.equals("")) {
            return true;
        } else {
            throw new IllegalArgumentException("Subject and tutor should not be empty!");
        }
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }
}