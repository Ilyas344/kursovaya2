import java.time.LocalDate;
import java.time.LocalDateTime;

import Exception.IncorrectArgumentException;

public class YearlyTask extends Task {
    public YearlyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearlsn(LocalDate checkDate) {
        return ((checkDate.isAfter(getDateTime().toLocalDate()) || checkDate.isEqual(getDateTime().toLocalDate()))
                && (getDateTime().getMonth().equals(checkDate.getMonth()) &&
                getDateTime().getDayOfMonth() == (checkDate.getDayOfMonth())));

    }

}