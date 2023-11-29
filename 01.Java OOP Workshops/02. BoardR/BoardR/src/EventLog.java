import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventLog {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
    public static final String INVALID_DESCRIPTION = "Description cannot be empty";
    private final String description;
    private final LocalDateTime timestamp;

    public EventLog(String description) {
        this.description = description;
        timestamp = LocalDateTime.now();
    }

    public EventLog() {
        throw new IllegalArgumentException(INVALID_DESCRIPTION);
    }
    public String getDescription() {
        return description;
    }
    public String viewInfo() {
        return String.format("[%s] %s", timestamp.format(FORMATTER), description);
    }
}