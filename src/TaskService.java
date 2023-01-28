import java.time.LocalDate;
import java.util.*;

public class TaskService {

    private final Map<Integer, Task> taskMap;
    private final List<Task> removedTask=new ArrayList<>();

    public TaskService() {
        this.taskMap = new TreeMap<>();

    }

    public void add(Task task) throws IncorrectArgumentException {

            taskMap.put(Task.getId(), task);
            removedTask.add(task);


    }

    public Task remove(Integer id) throws TaskNotFoundException {
        if (!taskMap.containsKey(id) || taskMap.get(id) == null) {
            throw new TaskNotFoundException();
        }

        taskMap.remove(id);
        removedTask.remove(id);
        return taskMap.get(id);
    }

    public List<Task> getAllByDate(LocalDate localDate) {
List <Task> list=new LinkedList<>();
        for (Map.Entry<Integer,Task> itr: taskMap.entrySet() ) {
            if (itr.getValue().getDateTime().equals(localDate)) {
                list.add(itr.getValue());
            }
        }

        return list;
    }

    @Override
    public String toString() {
        return  ""+taskMap;
    }
}
