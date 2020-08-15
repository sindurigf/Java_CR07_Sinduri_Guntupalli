import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {

    private Connection conn;

    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private String dbName = "java_cr7_guntupalli";
    private String url = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private String username = "root";
    private String password = "";


    public void connectDatabase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established.");
        conn.setAutoCommit(false);
    }

    public void closeDB() throws SQLException {
        if (conn != null) {
            conn.close();
            System.out.println("Connection Closed.");
        }
    }

    public List<Student> listAllStudents() throws SQLException {
        List<Student> studentList = new ArrayList<>();

        PreparedStatement studentStatement = conn.prepareStatement("SELECT student.studentID, student.studentFirstName, student.studentLastName, address.addressID, address.street, address.zip, address.city, address.country, contact.contactID, contact.phoneNumber, contact.emailID FROM `student` \n" +
                "INNER JOIN address ON address.addressID = student.fkAddressID\n" +
                "INNER JOIN contact ON contact.contactID = student.fkContactID;");

        ResultSet resObj = studentStatement.executeQuery();
        while (resObj.next()) {
            int studentID = resObj.getInt("student.studentID");
            String studentFirstName = resObj.getString("student.studentFirstName");
            String studentLastName = resObj.getString("student.studentLastName");
            int addressID = resObj.getInt("address.addressID");
            String street = resObj.getString("address.street");
            int zip = resObj.getInt("address.zip");
            String city = resObj.getString("address.city");
            String country = resObj.getString("address.country");
            int contactID = resObj.getInt("contact.contactID");
            String phoneNumber = resObj.getString("contact.phoneNumber");
            String emailID = resObj.getString("contact.emailID");
            new Address(addressID, street, zip, city, country);
            new Contact(contactID, phoneNumber, emailID);
            studentList.add(new Student(studentID, studentFirstName, studentLastName, addressID, contactID));
        }
        resObj.close();
        studentStatement.close();
        return studentList;
    }

    public List<Teacher> listAllTeachers() throws SQLException {
        List<Teacher> teacherList = new ArrayList<>();

        PreparedStatement teacherStatement = conn.prepareStatement("SELECT * FROM teacher\n" +
                "INNER JOIN address ON address.addressID = teacher.fkAddressID\n" +
                "INNER JOIN contact ON contact.contactID = teacher.fkContactID");

        ResultSet resObj = teacherStatement.executeQuery();
        while (resObj.next()) {
            int teacherID = resObj.getInt("teacher.teacherID");
            String teacherFirstName = resObj.getString("teacher.teacherFirstName");
            String teacherLastName = resObj.getString("teacher.teacherLastName");
            LocalDateTime hireDate = resObj.getObject("teacher.hireDate", LocalDateTime.class);
            int salary = resObj.getInt("teacher.salary");
            boolean statusTeacher = resObj.getBoolean("teacher.statusTeacher");
            int addressID = resObj.getInt("address.addressID");
            String street = resObj.getString("address.street");
            int zip = resObj.getInt("address.zip");
            String city = resObj.getString("address.city");
            String country = resObj.getString("address.country");
            int contactID = resObj.getInt("contact.contactID");
            String phoneNumber = resObj.getString("contact.phoneNumber");
            String emailID = resObj.getString("contact.emailID");
            new Address(addressID, street, zip, city, country);
            new Contact(contactID, phoneNumber, emailID);
            teacherList.add(new Teacher(teacherID, teacherFirstName, teacherLastName, hireDate, salary, statusTeacher, addressID, contactID));
        }
        resObj.close();
        teacherStatement.close();
        return teacherList;
    }

    public List<MapYear> listAllCourses() throws SQLException {
        List<MapYear> courseList = new ArrayList<>();

        PreparedStatement courseStatement = conn.prepareStatement("SELECT mapclassyear.mapID, mapclassyear.classYear, class.classID, class.classTitle, class.classDescription FROM `mapclassyear` \n" +
                "INNER JOIN class ON class.classID = mapclassyear.fkClassID\n" +
                "ORDER BY class.classID, mapclassyear.classYear;");

        ResultSet resObj = courseStatement.executeQuery();
        while (resObj.next()) {
            int courseID = resObj.getInt("class.classID");
            String courseTitle = resObj.getString("class.classTitle");
            String courseDescription = resObj.getString("class.classDescription");
            int mapID = resObj.getInt("mapclassyear.mapID");
            int classYear = resObj.getInt("mapclassyear.classYear");
            if(!Course.courseHashMap.containsKey(courseID)) {
                new Course(courseID, courseTitle, courseDescription);
            }
            courseList.add(new MapYear(mapID, classYear, courseID));
        }
        resObj.close();
        courseStatement.close();
        return courseList;
    }

    public void listTeacherCourses(int teacherId) throws SQLException {

        PreparedStatement courseTeacherStatement = conn.prepareStatement("SELECT teacher.teacherID, teacher.teacherFirstName, teacher.teacherLastName, teacher.hireDate, teacher.salary, teacher.statusTeacher, mapclassyear.classYear, class.classID, class.classTitle, class.classDescription FROM `mapclassteacher` \n" +
                "INNER JOIN teacher ON teacher.teacherID = mapclassteacher.fkTeacherID\n" +
                "INNER JOIN mapclassyear ON mapclassyear.mapID = mapclassteacher.fkClassMapID\n" +
                "INNER JOIN class ON class.classID = mapclassyear.fkClassID\n" +
                "WHERE teacher.teacherID = ? ORDER BY mapclassyear.classYear;");
        courseTeacherStatement.setInt(1, teacherId);

        ResultSet resObjCourse = courseTeacherStatement.executeQuery();

        int counter = 0;

        while (resObjCourse.next()) {
            if(counter == 0) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                int teacherID = resObjCourse.getInt("teacher.teacherID");
                String teacherFirstName = resObjCourse.getString("teacher.teacherFirstName");
                String teacherLastName = resObjCourse.getString("teacher.teacherLastName");
                LocalDateTime hireDate = resObjCourse.getObject("teacher.hireDate", LocalDateTime.class);
                int salary = resObjCourse.getInt("teacher.salary");
                boolean statusTeacher = resObjCourse.getBoolean("teacher.statusTeacher");
                System.out.printf("%n%s %s with the ID: %d, %s, earning $%s (Status: %s) taught the following courses: %n", teacherFirstName, teacherLastName, teacherID, (hireDate == null ? "" : "working since " + hireDate.format(formatter)), salary, (statusTeacher ? "Still Working" : "Left the Job"));
                System.out.printf("%-8s %-32s %-16s %-100s %n", "ID", "Course Title", "Year Taught", "Description");
            }
            counter++;
            int courseID = resObjCourse.getInt("class.classID");
            String courseTitle = resObjCourse.getString("class.classTitle");
            String courseDescription = resObjCourse.getString("class.classDescription");
            int classYear = resObjCourse.getInt("mapclassyear.classYear");
            System.out.printf("%-8d %-32s %-16d %-100s %n", courseID, courseTitle, classYear, courseDescription);
        }
        resObjCourse.close();
        courseTeacherStatement.close();
    }

    public void printAllReport(String filePath) throws IOException, SQLException {
        FileWriter fileWrite = new FileWriter(filePath, false);
        PrintWriter printWrite = new PrintWriter(fileWrite);
        PreparedStatement allListStatement = conn.prepareStatement("SELECT class.classID, class.classTitle, class.classDescription, student.studentID, student.studentFirstName, student.studentLastName, teacher.teacherID, teacher.teacherFirstName, teacher.teacherLastName, mapclassyear.classYear FROM mapclassyear\n" +
                "INNER JOIN class ON mapclassyear.fkClassID = class.classID\n" +
                "INNER JOIN mapclassstudent ON mapclassstudent.fkClassMapID = mapclassyear.mapID \n" +
                "INNER JOIN mapclassteacher ON mapclassteacher.fkClassMapID = mapclassyear.mapID\n" +
                "INNER JOIN student ON mapclassstudent.fkStudentID = student.studentID\n" +
                "INNER JOIN teacher ON mapclassteacher.fkTeacherID = teacher.teacherID\n" +
                "ORDER BY class.classID;");

        ResultSet resObj = allListStatement.executeQuery();

        printWrite.printf("%-15s %-30s %-15s %-30s %-15s %-30s %-15s %-30s %n", "CourseID", "CourseTitle", "YearConducted", "CourseDescription", "TeacherID", "Teacher Name", "StudentID", "Student Name");

        while (resObj.next()) {
            int courseID = resObj.getInt("class.classID");
            String courseTitle = resObj.getString("class.classTitle");
            String courseDescription = resObj.getString("class.classDescription");
            int courseYear = resObj.getInt("mapclassyear.classYear");
            int teacherID = resObj.getInt("teacher.teacherID");
            String teacherName = resObj.getString("teacher.teacherFirstName") + " " + resObj.getString("teacher.teacherLastName");
            int studentID = resObj.getInt("student.studentID");
            String studentName = resObj.getString("student.studentFirstName") + " " + resObj.getString("student.studentLastName");
            printWrite.printf("%-15s %-30s %-15s %-30s %-15s %-30s %-15s %-30s %n", courseID, courseTitle, courseYear, courseDescription.substring(0, 25), teacherID, teacherName, studentID, studentName);

        }
        resObj.close();
        allListStatement.close();

        printWrite.close();
        fileWrite.close();
    }


}
