package hostel.app;

import hostel.domain.Room;
import hostel.domain.SingleRoom;
import hostel.domain.DormRoom;

public class Main {
    static void main() {
        Room room1 = new SingleRoom("101", 1);
        Room room2 = new DormRoom("202", 6, 12);
        System.out.println("Opis pokoju 1: " + room1.description());
        System.out.println("Opis pokoju 2: " + room2.description());

        //1.
        System.out.println("Czy pokój 101 jest zajęty? : " + room1.isOccupied());

        //2.
        System.out.println("zajmuję pokój nr 101");
        room1.book();

        //2a.
        System.out.println("Czy pokój 101 jest zajęty? : " + room1.isOccupied());

        //3. ex_handling
        try{
            Room blad = new SingleRoom("666", -5);
        }catch (IllegalArgumentException e){
            System.out.println("Złapano wyjątek: " + e.getMessage());
        }
    }
}
