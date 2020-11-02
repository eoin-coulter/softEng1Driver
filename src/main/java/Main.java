import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;

public class Main {


    public static void main(String args[]) {
        Main main = new Main();


        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Student> students = new ArrayList<Student>();

        Module SoftEngineering = new Module("SoftWare Engineering", "CT404", new ArrayList<Student>(), new ArrayList<Course>());
        Module DataBaseSystems = new Module("DataBaseSystems", "CT4663", new ArrayList<Student>(), new ArrayList<Course>());
        Module MachineLearning = new Module("MachineLearning", "CT2873", new ArrayList<Student>(), new ArrayList<Course>());
        Module ArtificialIntelligence = new Module("ArtificialIntelligence", "CT2873", new ArrayList<Student>(), new ArrayList<Course>());
        Module ImageProcessing = new Module("ImageProcessing", "CT3647", new ArrayList<Student>(), new ArrayList<Course>());


        Course BCT = new Course("BCT", new ArrayList<Student>(), new ArrayList<Module>(), new LocalDate("2018-05-05"), new LocalDate("2019-05-05"));
        Course BCS = new Course("BCS", new ArrayList<Student>(), new ArrayList<Module>(), new LocalDate("2018-05-05"), new LocalDate("2019-05-05"));

        courses.add(BCT);
        courses.add(BCS);

        Student Eoin = new Student("Eoin Coulter", 21, 17902302, new ArrayList<Course>(), new ArrayList<Module>(), new Date(01 / 12 / 1998));
        Student Bob = new Student("Bob Bobson", 21, 17902301, new ArrayList<Course>(), new ArrayList<Module>(), new Date(02 / 11 / 1913));
        Student Ciaran = new Student("Ciaran King", 57, 17902399, new ArrayList<Course>(), new ArrayList<Module>(), new Date(01 / 12 / 1987));


        main.AddStudentToModule(SoftEngineering, Eoin);
        main.AddStudentToModule(DataBaseSystems, Eoin);
        main.AddStudentToModule(MachineLearning, Eoin);
        main.AddStudentToModule(MachineLearning, Ciaran);
        main.AddStudentToModule(ArtificialIntelligence, Bob);
        main.AddStudentToModule(ImageProcessing, Ciaran);
        main.AddStudentToModule(SoftEngineering, Bob);
        main.AddStudentToModule(DataBaseSystems, Bob);

        main.AddModuleToCourse(ImageProcessing, BCT);
        main.AddModuleToCourse(MachineLearning, BCS);
        main.AddModuleToCourse(ArtificialIntelligence, BCT);
        main.AddModuleToCourse(SoftEngineering, BCT);
        main.AddModuleToCourse(DataBaseSystems, BCS);

        for (Course course : courses) {
            System.out.print("Course Name: " + course.getName() + "\n");

            System.out.println("Modules in Course");
            for (Module module : course.getModule()) {
                System.out.print(module.getName() + "\n");

                for (Student student : module.getStudents()) {
                    if (students.contains(student) == false)

                        students.add(student);


                }
            }

            System.out.println("-------------------");

        }
        System.out.println("-------------------");
        System.out.println("Students\n");

        for (Student student : students) {
            System.out.println("username:" + student.getUserName());

            System.out.println("Assigned Modules:");
            for (Module module : student.getModules()) {
                System.out.println(module.getName() + "");
            }

            System.out.println("Assigned courses:");
            for (Course course : student.getCourses()) {
                System.out.println(course.getName() + "");
            }
            System.out.println("-------------------");


        }


    }


    public void AddStudentToModule(Module module, Student student) {
        if (student.getModules().contains(module)) {
            return;
        } else {
            ArrayList<Student> temp = module.getStudents();
            ArrayList<Module> studentModules = student.getModules();
            temp.add(student);
            studentModules.add(module);
            module.setStudents(temp);

            student.setModules(studentModules);

        }

    }

    public void addStudentToCourse(Student student, Course course) {

        ArrayList<Course> coursesEnrolled = student.getCourses();
        if (coursesEnrolled.contains(course) == true) {
            return;
        } else
            coursesEnrolled.add(course);
        student.setCourses(coursesEnrolled);
    }


    public void AddModuleToCourse(Module module, Course course) {

        if (module.getCourses().contains(course)) {
            return;
        } else {
            ArrayList<Course> temp = module.getCourses();
            temp.add(course);
            module.setCourses(temp);
            ArrayList<Module> modulesInCourse = course.getModule();
            modulesInCourse.add(module);
            course.setModule(modulesInCourse);

            ArrayList<Student> studentsInModule = module.getStudents();

            ArrayList<Student> studentsInCourse = course.getStudents();
            for (Student studentInModule : studentsInModule) {


                studentsInCourse.add(studentInModule);


            }
            course.setStudents(studentsInCourse);
            for (Student studentInCourse : studentsInCourse) {

                addStudentToCourse(studentInCourse, course);
            }

        }

    }
}