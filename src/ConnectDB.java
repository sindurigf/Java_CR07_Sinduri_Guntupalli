import java.sql.*;
import java.time.LocalDateTime;
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
            Address.addressList.add(new Address(addressID, street, zip, city, country));
            Contact.contactList.add(new Contact(contactID, phoneNumber, emailID));
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
            Address.addressList.add(new Address(addressID, street, zip, city, country));
            Contact.contactList.add(new Contact(contactID, phoneNumber, emailID));
            teacherList.add(new Teacher(teacherID, teacherFirstName, teacherLastName, hireDate, salary, statusTeacher, addressID, contactID));
        }
        resObj.close();
        teacherStatement.close();
        return teacherList;
    }

    public List<Course> listAllCourses() throws SQLException {
        List<Course> courseList = new ArrayList<>();

        PreparedStatement courseStatement = conn.prepareStatement("SELECT * FROM CLASS;");

        ResultSet resObj = courseStatement.executeQuery();
        while (resObj.next()) {
            int courseID = resObj.getInt("class.classID");
            String courseTitle = resObj.getString("class.classTitle");
            String courseDescription = resObj.getString("class.classDescription");

            courseList.add(new Course(courseID, courseTitle, courseDescription));
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
                int teacherID = resObjCourse.getInt("teacher.teacherID");
                String teacherFirstName = resObjCourse.getString("teacher.teacherFirstName");
                String teacherLastName = resObjCourse.getString("teacher.teacherLastName");
                LocalDateTime hireDate = resObjCourse.getObject("teacher.hireDate", LocalDateTime.class);
                int salary = resObjCourse.getInt("teacher.salary");
                boolean statusTeacher = resObjCourse.getBoolean("teacher.statusTeacher");
                System.out.printf("%n%s %s with the ID: %d , working since %s and earning %d (Status: %s) taught the following courses: %n", teacherFirstName, teacherLastName, teacherID, hireDate, salary, (statusTeacher ? "Still Working" : "Not working"));
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


}
