import Exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class DailyTask extends Task {
    public DailyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearlsn(LocalDate checkDate) {
        return (checkDate.isAfter(getDateTime().toLocalDate()) || checkDate.isEqual(getDateTime().toLocalDate()));
    }


}
