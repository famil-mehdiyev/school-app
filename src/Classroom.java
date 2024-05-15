import java.util.Arrays;

public class Classroom {
   public int uniqeId;
   public Student[] students;
   public Teacher teacher;

   public Classroom(int uniqeId, Student[] students, Teacher teacher) {
      this.uniqeId = uniqeId;
      this.students = students;
      this.teacher = teacher;
   }

   public Classroom() {
   }

   public Classroom(Teacher teacher) {
      this.teacher = teacher;
   }

   public Classroom(int uniqeId, Teacher teacher) {
      this.uniqeId = uniqeId;
      this.teacher = teacher;
   }

   @Override
   public String toString() {
      return "Classroom{" +
              "uniqeId=" + uniqeId +
              ", students=" + Arrays.toString(students) +
              ", teacher=" + teacher +
              '}';
   }
}
