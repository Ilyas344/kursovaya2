import java.time.LocalDate;
import java.util.*;

import Exception.TaskNotFoundException;


public class TaskService {

    private final Map<Integer, Task> taskMap;
    Collection<Task> removedTask = new ArrayList<>();

    public TaskService() {
        this.taskMap = new HashMap<>();

    }

    public void add(Task task) {

        taskMap.put(task.getId(), task);


    }

    public void remove(int id) throws TaskNotFoundException {
        if (taskMap.containsKey(id)) {
            taskMap.remove(id);
            System.out.println("Задача удалена");
        } else {
            throw new TaskNotFoundException(id);
        }

    }

    public Collection<Task> getAllByDate(LocalDate localDate) {
        Collection<Task> removedTask = new ArrayList<>();
        for (Task task : taskMap.values()) {
            if (task.appearlsn(localDate)) {
                removedTask.add(task);
            }
        }
        return removedTask;
    }

    @Override
    public String toString() {
        return taskMap.values().toString();

    }
}
