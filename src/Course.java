import java.util.HashMap;

public class Course {
    private int classID;
    private String classTitle;
    private String classDescription;
    public static HashMap<Integer, Course> courseHashMap = new HashMap<>();

    public Course(int classID, String classTitle, String classDescription) {
        this.classID = classID;
        this.classTitle = classTitle;
        this.classDescription = classDescription;
        courseHashMap.put(this.classID, this);
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassTitle() {
        return classTitle;
    }

    public void setClassTitle(String classTitle) {
        this.classTitle = classTitle;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }
}
