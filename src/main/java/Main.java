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

        Student Eoin = new Student("Eoin Coulter", 21, 17902302, null,  new ArrayList<Module>(), new Date(01 / 12 / 1998));
        Student Bob = new Student("Bob Bobson", 21, 17902301, null, new ArrayList<Module>(), new Date(02 / 11 / 1913));
        Student Ciaran = new Student("Ciaran King", 57, 17902399,  null, new ArrayList<Module>(), new Date(01 / 12 / 1987));



        Eoin.addStudentToModule(Eoin,SoftEngineering);
        Eoin.addStudentToModule(Eoin,DataBaseSystems);
        Eoin.addStudentToModule(Eoin,MachineLearning);
        Ciaran.addStudentToModule(Ciaran,MachineLearning);
        Bob.addStudentToModule(Bob,ArtificialIntelligence);
        Ciaran.addStudentToModule(Ciaran,ImageProcessing);
        Bob.addStudentToModule(Bob,SoftEngineering);
        Bob.addStudentToModule(Bob,DataBaseSystems);

       BCT.AddStudentToCourse(Eoin);
       BCS.AddStudentToCourse(Bob);
       BCT.AddStudentToCourse(Ciaran);



        SoftEngineering.addModuleToCourse(SoftEngineering,BCT);
        ImageProcessing.addModuleToCourse(ImageProcessing,BCT);
        MachineLearning.addModuleToCourse(MachineLearning,BCS);
        DataBaseSystems.addModuleToCourse(DataBaseSystems,BCS);
        ArtificialIntelligence.addModuleToCourse(ArtificialIntelligence,BCS);









        for (Course course : courses) {
            System.out.print("Course Name: " + course.getName() + "\n");
            System.out.println("Students in Course :");
            for(Student studentsInCourse:course.getStudents()){
                System.out.println(studentsInCourse.getUserName());
            }

            System.out.println("-------------------");



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
          Course course = student.getCourses();
                System.out.println(course.getName() + "");

            System.out.println("-------------------");







        }


    }




}