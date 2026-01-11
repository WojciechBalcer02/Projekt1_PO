package hostel.app;

import hostel.domain.*;
import hostel.utils.RaportSrv;
import hostel.utils.ResServ;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        ResServ reservationService = new ResServ();

        Room room1 = new SingleRoom("101", 1);
        Room room2 = new DormRoom("202", 6, 12);

        reservationService.addRoom(room1);
        reservationService.addRoom(room2);

        Guest guest1 = new Guest("1","Jola", "jola@gmail.com");
        Guest guest2 = new Guest("2","Kamil", "kamil@gmail.com");
        Guest guest3 = new Guest("3","Krzysztof", "krzysztof@gmail.com");

        try {
            System.out.println("--- Próba 1: Rezerwacja poprawna ---");
            Reservation res1 = reservationService.makeReservation(
                    guest1,
                    room1,
                    LocalDate.of(2026, 7, 10),
                    LocalDate.of(2026, 7, 20)
            );
            System.out.println("Zameldowano, ID rezerwacji: " + res1.getId());


            System.out.println("\n--- Próba 2: Rezerwacja tego samego pokoju w innym terminie ---");
            Reservation res2 = reservationService.makeReservation(
                    guest3,
                    room1,
                    LocalDate.of(2026, 8, 15),
                    LocalDate.of(2026, 8, 25)
            );
            System.out.println("Zameldowano, ID rezerwacji: " + res2.getId());
            /*
            System.out.println("\n--- Próba 3: Nałożenie się terminów ---");
            //próba wykonania rezerwacji z zajętym pokojem w tym terminie
            Reservation res3 = reservationService.makeReservation(
                    guest2,
                    room1,
                    LocalDate.of(2026, 7, 15),
                    LocalDate.of(2026, 7, 25)
            );
            */
            RaportSrv raportSrv = new RaportSrv();
            raportSrv.printReport("Dzisiejszy", reservationService.getAllReservations());
        } catch (IllegalStateException e) {
            // Złapie wyjątek przy wykonaniu rezerwacji w tym samym terminie który jest zajęty
            System.err.println("BŁĄD REZERWACJI: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Złapie wyjątek przy rezerwacji pokoju którego nie ma
            System.err.println("BŁĄD DANYCH: " + e.getMessage());
        }

    }
}
