package hostel.domain;

public class DormRoom extends Room{
    private int lockers;

    public DormRoom(String id, int beds, int lockers){
        super(id, beds);

        if(beds <= 0){
            throw new IllegalArgumentException("Liczba łóżek musi być dodatnia.");
        }
        if (lockers < 0){
            throw new IllegalArgumentException("Liczba  szafek nie może być ujemna.");
        }
        this.lockers = lockers;
    }

    public int getLockers() {
        return lockers;
    }
    @Override
    public String description() {
        return "Dorm Room nr " + getId() + " z " + getBeds() +" łóżkami " + " i " + getLockers() + " szafkami.";
    }
}
