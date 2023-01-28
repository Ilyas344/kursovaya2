import java.time.LocalDate;



public class OneTimeTask extends Task {
    public OneTimeTask(String title, Type type, LocalDate date, String description) {
        super(title, type, date, description);
    }

    @Override
    public boolean appearlsn(LocalDate checkDate) {
        if (getDateTime().isEqual(checkDate)) {
            return true;
        } else {
            return false;
        }
    }
}
