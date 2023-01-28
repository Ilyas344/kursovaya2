import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws TaskNotFoundException, IncorrectArgumentException {
        System.out.println("Hello world!");
        TaskService taskService = new TaskService();
        taskService.add(new DailyTask("1", Type.PERSONAL, LocalDate.now().plusDays(15), "Текст 1"));
        taskService.add(new MonthlyTask("2", Type.WORK, LocalDate.now(), "Текст 2"));
        taskService.add(new OneTimeTask("3", Type.PERSONAL, LocalDate.now(), "Текст 3"));
        taskService.add(new WeeklyTask("4", Type.WORK, LocalDate.now(), "Текст 4"));
        taskService.add(new YearlyTask("5", Type.PERSONAL, LocalDate.now(), "Текст 5"));
        System.out.println(taskService);
        System.out.println(taskService.getAllByDate(LocalDate.now()));
        taskService.remove(1);
        System.out.println(taskService);

    }

}