import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static ConnectDB connectDB = new ConnectDB();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {



        Scanner inputInteger = new Scanner(System.in);
        Scanner inputText = new Scanner(System.in);

        try {

            boolean booleanCheck = true;

            System.out.println("Welcome to Course Factory!");

            while (booleanCheck) {

                System.out.print("\nPress 1 to display all students in the school" +
                        "\nPress 2 to display all teachers in the school" +
                        "\nPress 3 to display all the classes in the school" +
                        "\nPress 4 to display all the classes taught by a particular teacher" +
                        "\nPress 5 to print a report of a specific table" +
                        "\nPress 6 to exit" +
                        "\nOption: ");
                int inputOption1 = inputInteger.nextInt();

                switch ((inputOption1)) {
                    case (1):
                        init();
                        try {
                            printAllStudents(connectDB.listAllStudents());
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            closeConnection();
                        }

                        break;
                    case (2):
                        init();
                        try {
                            printAllTeachers(connectDB.listAllTeachers());
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            closeConnection();
                        }
                        break;
                    case (3):
                        init();
                        try {
                            printAllCourses(connectDB.listAllCourses());
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            closeConnection();
                        }
                        break;
                    case (4):
                        init();
                        try {
                            List<Teacher> teacherList = connectDB.listAllTeachers();
                            for(Teacher teacher : teacherList) {
                                System.out.println("Press " + teacher.getTeacherID() + " to select " + teacher.getTeacherFirstName() + " " + teacher.getTeacherLastName() + "!");
                            }
                            System.out.print("Option: ");
                            int inputTeacherID = inputInteger.nextInt();
                            connectDB.listTeacherCourses(inputTeacherID);

                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            closeConnection();
                        }
                        break;
                    case (5):
                        init();
                        try {
                            printReport();

                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            closeConnection();
                        }

                        break;
                    case (6):
                        booleanCheck = false;
                        break;
                    default:
                        System.out.println("Please select one of the options available!");
                        break;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Please press the right formatted input!");
        }

        inputInteger.close();
        inputText.close();


    }

    static public void init() {
        try {
            connectDB.connectDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public void closeConnection() {
        try {
            connectDB.closeDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printAllStudents(List<Student> studentList) {
        if(studentList == null) {
            System.out.println("No students!");
        } else {
            for(Student student : studentList) {
                System.out.println("ID = " + student.getStudentID() + ", Name = " + student.getStudentFirstName() + ", Address = " + Address.addressList.get(student.getFkAddressID()).getCity());
            }
        }
    }

    public static void printAllTeachers(List<Teacher> teacherList) {
        if(teacherList == null) {
            System.out.println("No teachers!");
        } else {
            for(Teacher teacher : teacherList) {
                System.out.println("ID = " + teacher.getTeacherID() + ", Name = " + teacher.getTeacherFirstName() + ", Address = " + Address.addressList.get(teacher.getFkAddressID()).getStreet() + ", Hire Date: " + teacher.getHireDate() + ", Status: " + teacher.isStatusTeacher());
            }
        }
    }

    public static void printAllCourses(List<Course> courseList) {
        if(courseList == null) {
            System.out.println("No Courses!");
        } else {
            for(Course course : courseList) {
                System.out.println("ID = " + course.getClassID() + ", Name = " + course.getClassTitle() + ", Description = " + course.getClassDescription());
            }
        }
    }

    public static void printReport() throws SQLException {
        Scanner inputOption = new Scanner(System.in);

        try {
            boolean booleanWhile = true;
            while (booleanWhile) {
                System.out.print("\nPress 1 to print a report of all students" +
                        "\nPress 2 to print a report of all teachers" +
                        "\nPress 3 to print a report of all courses" +
                        "\nPress 4 to print a summary report of everything" +
                        "\nPress 5 to exit" +
                        "\nOption: ");
                int inputValue = inputOption.nextInt();
                switch ((inputValue)) {
                    case (1):
                        init();
                        try {
                            List<Student> studentsList = connectDB.listAllStudents();
                            createFile("students");
                            try {
                                FileWriter fileWrite = new FileWriter(".\\Reports\\students.txt", false);
                                PrintWriter printWrite = new PrintWriter(fileWrite);
                                printWrite.printf("%15s %20s %20s %50s %20s %n", "StudentID", "FirstName", "LastName", "Address", "Phone Number", "EmailID");

                                for (Student student : studentsList) {
                                    Address address = Address.addressList.get(student.getFkAddressID());
                                    Contact contact = Contact.contactList.get(student.getFkContactID());
                                    printWrite.printf("%15s %20s %20s %50s %20s %n", student.getStudentID(), student.getStudentFirstName(), student.getStudentLastName(), (address.getStreet() + " ," + address.getZip()+ " " + address.getCity()+ " " + address.getCountry()), contact.getPhoneNumber(), contact.getEmailID());
                                }

                                printWrite.close();
                                fileWrite.close();
                                System.out.println("Successfully wrote to file.");
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            closeConnection();
                        }

                        break;
                    case (2):
                        init();
                        try {
                            List<Teacher> teachersList = connectDB.listAllTeachers();
                            createFile("teachers");
                            try {
                                FileWriter fileWrite = new FileWriter(".\\Reports\\teachers.txt", false);
                                PrintWriter printWrite = new PrintWriter(fileWrite);
                                printWrite.printf("%-10s %-20s %-20s %-50s %-20s %n", "TeacherID", "FirstName", "LastName", "Address", "Phone Number", "EmailID");

                                for (Teacher teacher : teachersList) {
                                    Address address = Address.addressList.get(teacher.getFkAddressID());
                                    Contact contact = Contact.contactList.get(teacher.getFkContactID());
                                    printWrite.printf("%-10d %-20s %-20s %-50s %-20s %n", teacher.getTeacherID(),
                                            teacher.getTeacherFirstName(), teacher.getTeacherLastName(),
                                            (address.getStreet() + " ," + address.getZip()+ " " + address.getCity()+ " " + address.getCountry()),
                                            contact.getPhoneNumber(), contact.getEmailID());
                                }

                                printWrite.close();
                                fileWrite.close();
                                System.out.println("Successfully wrote to file.");
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            closeConnection();
                        }
                        break;
                    case (3):
                        init();
                        try {
                            File courseFile = createFile("courses");
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            closeConnection();
                        }
                        break;
                    case (4):
                        init();
                        try {
                            File completeFile = createFile("allDetails");
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            closeConnection();
                        }
                        break;
                    case (5):
                        booleanWhile = false;
                        break;
                    default:
                        System.out.println("Please select one of the options available!");
                        break;
                }


            }
        } catch (InputMismatchException e) {
            System.out.println("Please press the right formatted input!");
        }


    }

    public static File createFile(String fileName) {
        try {
            File file = new File(".\\Reports\\" + fileName + ".txt"); // Create file
            if (file.createNewFile()) { // Use createNewFile() method
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists");
            }
            return file;
        } catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
            return null;
        }
    }
}
