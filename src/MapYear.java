public class MapYear {
    private int mapID;
    private int classYear;
    private int fkClassID;

    public MapYear(int mapID, int classYear, int fkClassID) {
        this.mapID = mapID;
        this.classYear = classYear;
        this.fkClassID = fkClassID;
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public int getClassYear() {
        return classYear;
    }

    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }

    public int getFkClassID() {
        return fkClassID;
    }

    public void setFkClassID(int fkClassID) {
        this.fkClassID = fkClassID;
    }
}
