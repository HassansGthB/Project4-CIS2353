public class Ticket {

    private String firstName;
    private String lastName;
    private String code;
    private int priority;

    // Constructor
    public Ticket(String firstName, String lastName, String code, int priority) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
        this.priority = priority;
    }

    // Getters
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getCode() {
        return code;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return getFullName() + " (" + code + ")";
    }
}