package hostel.domain;

import hostel.utils.ValidationUtils;

public abstract class Room implements Bookable, Exportable {

    protected String id;
    protected int beds;
    protected boolean occupied;

    protected Room(String id, int beds) {
        ValidationUtils.validateString(id, "Room ID");
        ValidationUtils.validatePositive(beds, "Beds count");

        this.id = id;
        this.beds = beds;
        this.occupied = false;
    }
    @Override
    public boolean isAvailable() {
        return !occupied;
    }

    @Override
    public void book() {
        if (occupied) {
            throw new IllegalStateException("Pokój nr  " + id + " jest zajęty!");
        }
        occupy();
    }

    @Override
    public void cancel() {
        release();
    }

    @Override
    public String toCsv() {
        // ZRzuca z powrotem ID, Liczba łóżek, Czy zajęty
        return String.format("%s,%d,%b", id, beds, occupied);
    }

    public boolean isOccupied() {
        return occupied;
    }

    protected void occupy() {
        this.occupied = true;
    }

    protected void release() {
        this.occupied = false;
    }

    public abstract String description();

    public String getId() {
        return id;
    }
    public int getBeds() {
        return beds;
    }
}