public class MapCourseStudent {
    private int mapID;
    private int fkStudentID;
    private int fkClassMapID;

    public MapCourseStudent(int mapID, int fkStudentID, int fkClassMapID) {
        this.mapID = mapID;
        this.fkStudentID = fkStudentID;
        this.fkClassMapID = fkClassMapID;
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public int getFkStudentID() {
        return fkStudentID;
    }

    public void setFkStudentID(int fkStudentID) {
        this.fkStudentID = fkStudentID;
    }

    public int getFkClassMapID() {
        return fkClassMapID;
    }

    public void setFkClassMapID(int fkClassMapID) {
        this.fkClassMapID = fkClassMapID;
    }
}
