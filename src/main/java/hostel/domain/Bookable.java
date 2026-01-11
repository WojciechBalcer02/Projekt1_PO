package hostel.domain;

public interface Bookable {
    void book();
    void cancel();
    boolean isAvailable();
}