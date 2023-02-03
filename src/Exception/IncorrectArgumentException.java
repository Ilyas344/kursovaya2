package Exception;

public class IncorrectArgumentException extends Exception {
    private final String message;

    public IncorrectArgumentException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Ошибка данных в " + message;
    }
}
