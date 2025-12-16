package hostel.domain;

public class SingleRoom extends Room{
    public SingleRoom(String id, int beds){
        super(id, beds);
        if (beds <= 0){
            throw new IllegalArgumentException("Liczba łóżek w pokoju musi być większa od zera.");
        }
    }
    @Override
    public String description(){
        return "Single Room nr " + getId() + " z " + getBeds() + " łóżkami.";
    }
}
