import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BoardItem {
    public static final int MIN_TITLE_NAME = 5;
    public static final int MAX_TITLE_NAME = 30;
    private String title;
    private LocalDate dueDate;
    private Status status;
    protected final List<EventLog> history = new ArrayList<>();
    public BoardItem(String title, LocalDate dueDate) {
        this(title,dueDate,Status.OPEN);

    }
    public BoardItem(String title, LocalDate dueDate, Status initialStatus) {
        validateTitle(title);
        validateDate(dueDate);
        this.title = title;
        this.dueDate = dueDate;
        this.status = initialStatus;
        history.add(new EventLog(String.format("Item created: %s", viewInfo())));
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        validateDate(dueDate);
        history.add(new EventLog(String.format(
                "DueDate changed from %s to %s", getDueDate(), dueDate)));
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    protected void setStatus(Status status) {
        history.add(new EventLog(String.format(
                "Status changed from %s to %s", getStatus(), status)));
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateTitle(title);
        history.add(new EventLog(String.format(
                "Title changed from %s to %s", getTitle(), title)));
        this.title = title;
    }

    public void advanceStatus() {
        if (status != Status.VERIFIED) {

            setStatus(Status.values()[status.ordinal() + 1]);

        } else {
            history.add(new EventLog(String.format("Cannot advance already at %s", status.name())));

        }
    }

    public void revertStatus() {
        if (status != Status.OPEN) {
            setStatus(Status.values()[status.ordinal() - 1]);

        } else {
            history.add(new EventLog(String.format("Cannot revert already at %s", status.name())));

        }
    }

    public String viewInfo() {
        return String.format("'%s', [%s | %s]", title, status, dueDate);
    }

    public String displayHistory() {
        StringBuilder result = new StringBuilder();
        for (EventLog eventLog : history) {
            result.append(eventLog.viewInfo());
            result.append(System.lineSeparator());

        }
        System.out.println(result.toString());
        return result.toString();
    }

    protected static void validateTitle(String title) {
        if (title.length() < MIN_TITLE_NAME || title.length() > MAX_TITLE_NAME) {
            throw new IllegalArgumentException("Please provide a title with length between 5 and 30 chars.");
        }
    }

    protected static void validateDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Please enter a date that is only in the future.");

        }
    }
}





