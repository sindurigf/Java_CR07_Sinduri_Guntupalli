import java.time.LocalDateTime;

public class Teacher {
    private int teacherID;
    private String teacherFirstName;
    private String teacherLastName;
    private LocalDateTime hireDate;
    private double salary;
    private boolean statusTeacher;
    private int fkAddressID;
    private int fkContactID;

    public Teacher(int teacherID, String teacherFirstName, String teacherLastName, LocalDateTime hireDate, double salary, boolean statusTeacher, int fkAddressID, int fkContactID) {
        this.teacherID = teacherID;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.hireDate = hireDate;
        this.salary = salary;
        this.statusTeacher = statusTeacher;
        this.fkAddressID = fkAddressID;
        this.fkContactID = fkContactID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isStatusTeacher() {
        return statusTeacher;
    }

    public void setStatusTeacher(boolean statusTeacher) {
        this.statusTeacher = statusTeacher;
    }

    public int getFkAddressID() {
        return fkAddressID;
    }

    public void setFkAddressID(int fkAddressID) {
        this.fkAddressID = fkAddressID;
    }

    public int getFkContactID() {
        return fkContactID;
    }

    public void setFkContactID(int fkContactID) {
        this.fkContactID = fkContactID;
    }
}
