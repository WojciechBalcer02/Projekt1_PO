package hostel.domain;

import hostel.utils.ValidationUtils;

public class Guest implements Exportable {
    private final String id;
    private final String name;
    private final String email;

    public Guest(String id, String name, String email) {
        ValidationUtils.validateString(id, "Guest ID");
        ValidationUtils.validateString(name, "Guest Name");
        ValidationUtils.validateEmail(email);

        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toCsv() {
        return id + "," + name + "," + email;
    }

    @Override
    public String toString() {
        return "Guest{id='" + id + "', name='" + name + "'}";
    }
}