import java.time.LocalDate;
import java.time.LocalDateTime;

import Exception.IncorrectArgumentException;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, Type type, LocalDateTime date, String description) throws IncorrectArgumentException {
        super(title, type, date, description);
    }

    @Override
    public boolean appearlsn(LocalDate checkDate) {
        return (checkDate.isAfter(getDateTime().toLocalDate()) || checkDate.isEqual(getDateTime().toLocalDate())) && checkDate.getDayOfMonth() == getDateTime().getDayOfMonth();
    }
}


