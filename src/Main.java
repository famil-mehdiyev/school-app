import com.sun.source.tree.ClassTree;

import javax.swing.text.html.StyleSheet;
import java.awt.*;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        School school = new School();

        while (true) {
            System.out.println("""
                    1. Butun Sinifleri gor.
                    2. Butun Mellimleri gor.
                    3. Butun Telebeleri gor
                    4. ClassId-ye gore sinifdeki telebeleri gor
                    5. Mektebe sinif elave et.
                    6. Sinife telebe elave et
                    """);
            System.out.println("Operationu daxil edin");
            int operation = new Scanner(System.in).nextInt();
            switch (operation) {
                case 1:
                    showAllClasses(school);
                    break;
                case 2:
                    showAllTeachers(school);
                    break;
                case 3:
                    showAllStudents(school);
                    break;
                case 4:
                    showStudentsByClassId(school);
                    break;
                case 5:
                    createClassRooms(school);
                    break;
                case 6:
                    addStudent(school);
                    break;
            }
        }


    }

    public static Human createTeacher() {
        System.out.println("Muellimin adini daxil edin");
        String teacherName = new Scanner(System.in).nextLine();
        System.out.println("Muellimin soyadini daxil edin");
        String teacherSurname = new Scanner(System.in).nextLine();
        System.out.println("Muellimin yawini daxil edin");
        int teacherAge = new Scanner(System.in).nextInt();
        System.out.println("Muellimin maawini daxil edin");
        int teacherSalary = new Scanner(System.in).nextInt();

        return new Teacher(teacherName, teacherSurname, teacherAge, teacherSalary);
    }

    public static Human createStudent() {

        System.out.println("Telebenin adini daxil edin");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Telebenin soyadini daxil edin");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("Telebenin yawini daxil edin");
        int age = new Scanner(System.in).nextInt();
        System.out.println("Telebenin balini daxil edin");
        int point = new Scanner(System.in).nextInt();

        return new Student(name, surname, age, point);
    }


    public static void createClassRooms(School school) {

        System.out.println("Classroomun sayini daxil edin");
        int arrayLength = new Scanner(System.in).nextInt();

        school.classroom = new Classroom[arrayLength];


        for (int i = 0; i < school.classroom.length; i++) {
            if (school.classroom[i] == null) {
                System.out.println("Sinifin uniqueId-sini daxil edin :");
                int uniqueId = new Scanner(System.in).nextInt();
                school.classroom[i] = new Classroom(uniqueId, (Teacher) createTeacher());
                System.out.println("Student arrayine  olcu daxil edin :");
                int studentArrLength = new Scanner(System.in).nextInt();
                school.classroom[i].students = new Student[studentArrLength];
            }


        }


    }

    public static void addStudent(School school) {
        System.out.println("hansi ClassID-ye telebe elave etmek isteyirsiz : ");
        int classId = new Scanner(System.in).nextInt();
        for (int i = 0; i < school.classroom.length; i++) {
            if (school.classroom[i].uniqeId == classId) {
                for (int j = 0; j < school.classroom[i].students.length; j++) {
                    if (school.classroom[i].students[j] == null) {
                        Student students = (Student) createStudent();
                        school.classroom[i].students[j] = students;
                        return;
                    }
                }
            }
        }
    }


    public static void showAllClasses(School school) {
        if (school.classroom != null) {
            for (int i = 0; i < school.classroom.length; i++) {

                System.out.println("Classroom uniqueId : " + school.classroom[i].uniqeId);

            }
        }    else
            System.out.println("Classroom daxil edilmeyib");
    }
    public static void showAllTeachers(School school) {
        if (school.classroom != null) {
        for (int i = 0; i < school.classroom.length; i++) {

                System.out.println(school.classroom[i].teacher.toString());
            }
        }else
            System.out.println("Muellim daxil edilmeyib");
    }


    public static void showAllStudents(School school) {
        if (school.classroom != null) {
        for (int i = 0; i < school.classroom.length; i++) {
//        if (school.classroom[i] != null) {
//            System.out.println("Classroom uniqueId: " + school.classroom[i].uniqeId);

                for (int j = 0; j < school.classroom[i].students.length; j++) {
                    if (school.classroom[i].students[j] != null) {
                        System.out.println(school.classroom[i].students[j].toString());
                    }
                }
            }
        }else
            System.out.println("Telebe daxil edilmeyib");
    }


    public static void showStudentsByClassId(School school) {
        System.out.println("ClassId daxil edin");
        int classId = new Scanner(System.in).nextInt();

        for (int i = 0; i < school.classroom.length; i++) {
            if (classId == school.classroom[i].uniqeId) {
                for (int j = 0; j < school.classroom[i].students.length; j++) {
                    if (school.classroom[i].students != null) {
                        System.out.println(school.classroom[i].students[j].toString());
                    }
                }
            }
        }
    }


}
