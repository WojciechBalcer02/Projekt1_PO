package hostel.utils;

import hostel.domain.Guest;
import hostel.domain.Reservation;
import hostel.domain.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResServ {

    private final List<Room> rooms = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getAllRooms() {
        return Collections.unmodifiableList(rooms);
    }

    public Reservation makeReservation(Guest guest, Room room, LocalDate from, LocalDate to) {
        if (!rooms.contains(room)) {
            throw new IllegalArgumentException("Nieznany pokój: " + room.getId());
        }

        if (!checkAvailability(room, from, to)) {
            throw new IllegalStateException("Pokój " + room.getId() + " jest zajęty w terminie: " + from + " - " + to);
        }

        String resId = "RES-" + (reservations.size() + 1);
        Reservation newReservation = new Reservation(resId, guest, room, from, to);
        reservations.add(newReservation);

        // rezerwacja od dziś? zajęty
        LocalDate today = LocalDate.now();
        if (!today.isBefore(from) && !today.isAfter(to)) {
            room.book();
        }

        return newReservation;
    }

    public boolean checkAvailability(Room room, LocalDate from, LocalDate to) {
        for (Reservation existing : reservations) {
            if (existing.getRoom().equals(room)) {
                // kolizjeeeeeeeeee
                boolean overlaps = !from.isAfter(existing.getTo()) && !to.isBefore(existing.getFrom());
                if (overlaps) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Reservation> getAllReservations() {
        return List.copyOf(reservations);
    }
}