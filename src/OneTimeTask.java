import java.time.LocalDate;
import java.time.LocalDateTime;

import Exception.IncorrectArgumentException;


public class OneTimeTask extends Task {
    public OneTimeTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearlsn(LocalDate checkDate) {
        return getDateTime().toLocalDate().isEqual(checkDate);

    }
}
