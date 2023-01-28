import java.time.LocalDate;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, Type type, LocalDate date, String description) {
        super(title, type, date, description);
    }

    @Override
    public boolean appearlsn(LocalDate checkDate) {
        if (getDateTime().plusMonths(1).isEqual(checkDate)){
            setDateTime(getDateTime().plusMonths(1));
            return true;
        } else {
            return false;
        }
    }

}
