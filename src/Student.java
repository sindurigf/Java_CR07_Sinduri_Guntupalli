public class Student {
    private int studentID;
    private String studentFirstName;
    private String studentLastName;
    private int fkAddressID;
    private int fkContactID;

    public Student(int studentID, String studentFirstName, String studentLastName, int fkAddressID, int fkContactID) {
        this.studentID = studentID;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.fkAddressID = fkAddressID;
        this.fkContactID = fkContactID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
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
