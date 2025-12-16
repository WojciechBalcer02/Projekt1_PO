package hostel.utils;

import java.time.LocalDate;
import java.util.regex.Pattern;

public final class ValidationUtils {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static void validateString(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Pole: " + fieldName + " musi byc wartoscia i nie moze byc puste!.");
        }
    }

    public static void validatePositive(int value, String fieldName) {
        if (value <= 0) {
            throw new IllegalArgumentException("Pole: " +fieldName + " musi byc wieksze od zera!.");
        }
    }

    public static void validateNonNegative(int value, String fieldName) {
        if (value < 0) {
            throw new IllegalArgumentException("Pole: " +fieldName + " nie moze byc ujemne!");
        }
    }

    public static void validateEmail(String email) {
        validateString(email, "Email");
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Nieprawidlowy format adresu e-mail: " + email + "!");
        }
    }

    public static void validateDates(LocalDate from, LocalDate to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Niepoprawna data!.");
        }
        if (!to.isAfter(from)) {
            throw new IllegalArgumentException("Niewlasciwy zakres wybranych dat!");
        }
    }
}