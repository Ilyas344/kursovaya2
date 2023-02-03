import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Exception.IncorrectArgumentException;
import Exception.TaskNotFoundException;

import static java.time.format.DateTimeFormatter.*;


public class Main {
    private static final TaskService taskService = new TaskService();

    public static void main(String[] args) throws IncorrectArgumentException, TaskNotFoundException {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            removeTask(scanner);
                            break;
                        case 3:
                            printTask(scanner);
                            break;
                        case 0:
                            scanner.close();
                            break;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) throws IncorrectArgumentException {
        System.out.print("Введите название задачи: ");
        String taskTitle = scanner.next();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();
        System.out.print("1- рабочий,2 личный.\nВведите тип задачи: ");
        Type type = null;
        int taskType = scanner.nextInt();
        while (taskType != 1 || taskType != 2) {
            if (taskType == 1) {
                type = Type.WORK;
                break;
            }
            if (taskType == 2) {
                type = Type.PERSONAL;
                break;
            }

            System.out.println("Ошибка!\n1- рабочий,2 личный.\nВведите правильно тип задачи:");
            taskType = scanner.nextInt();
        }

        LocalDateTime taskDateTime = null;

        System.out.println("Введите день:");
        int day = scanner.nextInt();
        System.out.println("Введите месяц:");
        int month = scanner.nextInt();
        System.out.println("Введите год:");
        int year = scanner.nextInt();
        System.out.print("Введите часы: ");
        int hour = scanner.nextInt();
        System.out.print("Введите минуты: ");
        int minute = scanner.nextInt();
        taskDateTime = LocalDateTime.of(year, month, day, hour, minute);
        System.out.println("Вы ввели " + taskDateTime.format(ISO_DATE) + "" +
                " " + taskDateTime.toLocalTime().withNano(0));


        Task task = null;
        System.out.println("Введите повторяемость 1- один раз, 2- ежедневно, 3- еженедельно, 4- ежемесячно, 5- ежегодно");
        int repeat = scanner.nextInt();
        switch (repeat) {
            case 1:
                task = new OneTimeTask(taskTitle, type, taskDateTime, taskDescription);
                break;
            case 2:
                task = new DailyTask(taskTitle, type, taskDateTime, taskDescription);
                break;
            case 3:
                task = new WeeklyTask(taskTitle, type, taskDateTime, taskDescription);
                break;
            case 4:
                task = new MonthlyTask(taskTitle, type, taskDateTime, taskDescription);
                ;
                break;
            case 5:
                task = new YearlyTask(taskTitle, type, taskDateTime, taskDescription);
                break;
            default:
                System.out.println("Повторяемость введена некорректно");
                scanner.close();
        }
        taskService.add(task);
        System.out.println("Задача добавлена");
    }

    private static void printTask(Scanner scanner) {

        LocalDate checkDate = null;

        System.out.println("Введите день :");
        int day = scanner.nextInt();
        System.out.println("Введите месяц:");
        int month = scanner.nextInt();
        System.out.println("Введите год:");
        int year = scanner.nextInt();
        System.out.print("Введите часы: ");
        int hour = scanner.nextInt();
        System.out.print("Введите минуты: ");
        int minute = scanner.nextInt();
        checkDate = LocalDate.of(year, month, day);
        System.out.println("Вы ввели " + checkDate.format(ISO_DATE));

        System.out.println(taskService.getAllByDate(checkDate));
    }

    private static void removeTask(Scanner scanner) throws TaskNotFoundException {
        System.out.println("Введите id");
        int id = scanner.nextInt();
        taskService.remove(id);

    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n0. Выход");
    }

}
