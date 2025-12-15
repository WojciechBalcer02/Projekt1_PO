package hostel.domain;

public class SingleRoom extends Room{
    //konstruktor
    public SingleRoom(String id, int beds){
        //wywołanie konstruktora rodzica
        super(id, beds);
        if (beds <= 0){
            throw new IllegalArgumentException("Liczba łóżek w pokoju musi być większa od zera.");
        }
    }
    //nadpisanie metody description
    @Override
    public String description(){
        return "Single Room nr " + getId() + " z " + getBeds() + " łóżkami.";
    }
}
