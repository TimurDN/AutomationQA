import java.time.LocalDate;

public class Issue extends BoardItem{
    private final String description;

    public Issue(String title, String description, LocalDate dueDate) {
        super(title, dueDate, Status.OPEN);
        if (description == null || description.trim().isEmpty()) {
            this.description = "No description";

        }else {
            this.description = description;
        }
    }
    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    public String getDescription() {
        return description;
    }

}
