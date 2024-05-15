public class School {

   public Classroom[] classroom;

    public School(Classroom[] classroom) {
        this.classroom = classroom;
    }

    public School() {
    }

    @Override
    public String toString() {
        return "School{" +
                "classroom=" + classroom +
                '}';
    }
}
