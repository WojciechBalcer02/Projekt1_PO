package hostel.domain;

import hostel.utils.ValidationUtils;
import java.time.LocalDate;

public class Reservation implements Exportable {
    private final String id;
    private final Guest guest;
    private final Room room;
    private final LocalDate from;
    private final LocalDate to;

    public Reservation(String id, Guest guest, Room room, LocalDate from, LocalDate to) {
        ValidationUtils.validateString(id, "Reservation ID");
        if (guest == null) throw new IllegalArgumentException("Gość nie może być null.");
        if (room == null) throw new IllegalArgumentException("Pokój nie może być null.");
        ValidationUtils.validateDates(from, to);

        this.id = id;
        this.guest = guest;
        this.room = room;
        this.from = from;
        this.to = to;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toCsv() {
        // ja proponuje formatowanie nasteupjace: ID_Rezerwacji,ID_Gościa,ID_Pokoju,od,do jeśli nie to napisz mi na MSG co proponujesz innego, trzymamy się jednego w przyszlosci
        return String.format("%s,%s,%s,%s,%s",
                id, guest.getId(), room.getId(), from.toString(), to.toString());
    }

    @Override
    public String toString() {
        return "Rezerwacja{" + id + ": " + room.getId() + " dla " + guest.getName() + "}";
    }
}