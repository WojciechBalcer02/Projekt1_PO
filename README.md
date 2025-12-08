# Projekt1_PO
## System Rezerwacji Pokoi w Hostelu

1. Cel: prosty system do zarządzania pokojami (pojedyncze, wieloosobowe), gośćmi i rezerwacjami.
Akcent na klasy abstrakcyjne, interfejsy, polimorfizm oraz kapsułkowanie.

2. Założenia projektu:
   1. Inicjalizacja projektu i pakietów.
        - Utwórz projekt JDK17+ z katalogiem src/main/java.
        - Pakiety: hostel.domain, hostel.service, hostel.app, hostel.util.
        - Dodaj klasę uruchomieniową hostel.app.Main z public static void main.
   2. Abstrakcja pokoju
        - Klasa abstrakcyjna hostel.domain.Room z polami: id (Streing), beds (int), occupied (boolean).
        - Metody: boolean isOccupied(), void occupy(), void release(), String description() (abstrakcyjna).
        - Dostęp: pola private/protected, publiczne metody.
   3. Konkretne typy pokoi
        - SingleRoom oraz DormRoom (wielkie sale, dodatkowe pole lockers), oba rozszerzają Room.
        - Walidacje w konstruktorach (beds > 0, lockers >= 0).
        - Nadpisują description().
   4. Interfejsy - kontrakty biznesowe
        - hostel.domain.Bookable z metodami: book(), cancel(), boolean isAvailable().
        - hostel.domain.Exportable z String toCsv()
        - Pokoje implementują Bookable i Exportable.
   5. Goście i rezerwacje
        - Guest z danymi: id, name, email (walidacje).
        - Reservation łącząca Guest i Room, z terminami (LocalDate od/do).
        - Kapsułkowanie: kolekcje zwracaj jako kopie/niemodyfikowalne widoki.
   6. Serwisy domenowe
        - ReservationService: tworzenie/anulowanie rezerwacji, sprawdzanie dostępności (polimorficzne isAvailable()).
        - ReportingService: generowanie raportu CSV z listą pokoi/rezerwacji (toCsv()).
   7. Warstwa demonstracyjna
        - W Main zainicjuj kilka pokoi, gości, utwórz rezerwacje, wygeneruj krótkie raporty.
   8. Modyfikatory, pola i niezmienniki
        - Upewnij się, że pola są private/protected, dodaj stałe public static final (np. MAX_DORM_BEDS).
   9. Rozszerzenia (opcjonalne)
        - Interfejs Priced (cena za noc) + strategia wyceny (sezon/weekday-weekend).
        - Klasa abstrakcyjna PricedRoom łącząca Room z ceną bazową.
