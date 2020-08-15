public class MapCourseTeacher {
    private int mapID;
    private int fkTeacherID;
    private int fkClassMapID;

    public MapCourseTeacher(int mapID, int fkTeacherID, int fkClassMapID) {
        this.mapID = mapID;
        this.fkTeacherID = fkTeacherID;
        this.fkClassMapID = fkClassMapID;
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public int getFkTeacherID() {
        return fkTeacherID;
    }

    public void setFkTeacherID(int fkTeacherID) {
        this.fkTeacherID = fkTeacherID;
    }

    public int getFkClassMapID() {
        return fkClassMapID;
    }

    public void setFkClassMapID(int fkClassMapID) {
        this.fkClassMapID = fkClassMapID;
    }
}
