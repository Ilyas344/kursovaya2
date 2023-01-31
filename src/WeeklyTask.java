import java.time.LocalDate;
import java.time.LocalDateTime;

import Exception.IncorrectArgumentException;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearlsn(LocalDate checkDate) {
        return (checkDate.isAfter(getDateTime().toLocalDate()) || checkDate.isEqual(getDateTime().toLocalDate()))
                && getDateTime().getDayOfWeek().equals(checkDate.getDayOfWeek());
    }

}
