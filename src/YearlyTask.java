import java.time.LocalDate;

public class YearlyTask extends Task {
    public YearlyTask(String title, Type type, LocalDate dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearlsn(LocalDate checkDateTime) {
        if (getDateTime().plusYears(1).isEqual(checkDateTime)) {
            setDateTime(getDateTime().plusYears(1));
            return true;
        } else {
            return false;
        }
    }
}