
import java.time.LocalDate;


public class DailyTask extends Task {
    public DailyTask(String title, Type type, LocalDate date, String description) {
        super(title, type, date, description);
    }

    @Override
    public boolean appearlsn(LocalDate checkDate) {
        if (getDateTime().isEqual(checkDate)
                || getDateTime().isAfter(checkDate)) {
            return true;
        } else {
            return false;
        }
    }


}
