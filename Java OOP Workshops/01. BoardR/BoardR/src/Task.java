import java.time.LocalDate;
//work that needs to be done
public class Task extends BoardItem{
    private String assignee;

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate, Status.TODO);
        setAssignee(assignee);

    }
    @Override
    public Status getStatus() {
        if (super.getStatus() == Status.OPEN){
            return Status.TODO;
        }
        return super.getStatus();
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        if (assignee == null || assignee.length() < 5 || assignee.length() > 30) {
            throw new IllegalArgumentException("Assignee cannot be null and must be between 5 and 30 chars.");
        }

        if (!assignee.equals(this.assignee)) {
            history.add(new EventLog(String.format("Assignee changed from %s to %s", getAssignee(), assignee)));
            this.assignee = assignee;

        }
    }
}
