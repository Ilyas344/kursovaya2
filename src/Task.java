import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

import Exception.IncorrectArgumentException;

import static java.time.format.DateTimeFormatter.*;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;


public abstract class Task implements CheckRepeatTask {
    private static int ID_GENERATOR = 1;
    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;


    public Task(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        setTitle(title);
        setType(type);
        setDateTime(dateTime);
        setDescription(description);
        id = ID_GENERATOR++;
    }


    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if (!title.isBlank()) {
            this.title = title;
        } else {
            throw new IncorrectArgumentException("заголовке");
        }

    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (!description.isBlank()) {
            this.description = description;
        } else {
            throw new IncorrectArgumentException("теле задачи");
        }
    }

    public void setDateTime(LocalDateTime dateTime) throws IncorrectArgumentException {
        if (dateTime != null) {
            this.dateTime = dateTime;
        } else {
            throw new IncorrectArgumentException("дате и времени задачи");
        }
    }

    public void setType(Type type) throws IncorrectArgumentException {
        if (type != null) {
            this.type = type;
        } else {
            throw new IncorrectArgumentException("типе задачи");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && Objects.equals(type, task.type) && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, dateTime, description);
    }

    @Override
    public String toString() {

        return "\nЗадание: " + title +
                ", " + type.getType() +
                ", дата: " + dateTime.format(ISO_LOCAL_DATE) +
                ", время: " + dateTime.toLocalTime().withNano(0) +
                ", текст: " + description;
    }
}
