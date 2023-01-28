import java.time.LocalDate;



public class WeeklyTask extends Task {
    public WeeklyTask(String title, Type type, LocalDate dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearlsn(LocalDate checkDateTime) {
        if (getDateTime().plusWeeks(1).isEqual(checkDateTime)) {
            setDateTime(getDateTime().plusWeeks(1));
            return true;
        } else {
            return false;
        }
    }

}
