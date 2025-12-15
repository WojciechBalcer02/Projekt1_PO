package hostel.app;

import hostel.domain.Room;
import hostel.domain.SingleRoom;
import hostel.domain.DormRoom;

public class Main {
    static void main() {
        //Test
        //utworzenie obiektów
        Room room1 = new SingleRoom("101", 1);
        Room room2 = new DormRoom("202", 6, 12);
        System.out.println("Opis pokoju 1: " + room1.description());
        System.out.println("Opis pokoju 2: " + room2.description());

        //sprawdzenie czy pokój nr 101 jest zajęty
        System.out.println("Czy pokój 101 jest zajęty? : " + room1.isOccupied());

        //zajmowanie pokoju
        System.out.println("zajmuję pokój nr 101");
        room1.occupy();

        //sprawdzenie czy pokój nr 101 jest zajęty
        System.out.println("Czy pokój 101 jest zajęty? : " + room1.isOccupied());

        //try catch - sprawdzenie czy wyłapuje wyjątki
        try{
            Room blad = new SingleRoom("666", -5);
        }catch (IllegalArgumentException e){
            System.out.println("Złapano wyjątek: " + e.getMessage());
        }
    }
}
