package hostel.domain;

public abstract class Room {
    private String id;
    private int beds;
    private boolean occupied;

    public Room(String id, int beds){
        this.id = id;
        this.beds = beds;
        this.occupied = false;
    }

    public boolean isOccupied(){
        return occupied;
    }

    public void occupy(){
        this.occupied = true;
    }

    public void release(){
        this.occupied = false;
    }

    //abstract by każda klasa miała swój nadpisany opis i musiała go mieć
    public abstract String description();

    public String getId() {
        return id;
    }

    public int getBeds() {
        return beds;
    }
}
