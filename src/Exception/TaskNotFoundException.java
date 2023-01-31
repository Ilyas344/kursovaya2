package Exception;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(Integer idException) {
        super("Произошла ошибка с id " + idException);
    }
}
