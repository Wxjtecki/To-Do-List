//Autor Kamil Pajączkowski
import java.util.Scanner;

public class ToDoApp {
    private static final String FILENAME = "tasks.txt";

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        FileManager.loadTasksFromFile(FILENAME, toDoList);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nTo-Do List:");
            toDoList.printTasks();
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Dodaj zadanie");
            System.out.println("2. Edytuj zadanie");
            System.out.println("3. Usuń zadanie");
            System.out.println("4. Oznacz zadanie jako ukończone");
            System.out.println("5. Zapisz zadania");
            System.out.println("6. Wyjście");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Konsumuj nową linię

            switch (choice) {
                case 1:
                    System.out.print("Podaj opis zadania: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    System.out.print("Podaj numer zadania do edycji: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Podaj nowy opis zadania: ");
                    String newDescription = scanner.nextLine();
                    toDoList.editTask(editIndex, newDescription);
                    break;
                case 3:
                    System.out.print("Podaj numer zadania do usunięcia: ");
                    int removeIndex = scanner.nextInt();
                    toDoList.removeTask(removeIndex);
                    break;
                case 4:
                    System.out.print("Podaj numer zadania do oznaczenia jako ukończone: ");
                    int completeIndex = scanner.nextInt();
                    toDoList.markTaskAsCompleted(completeIndex);
                    break;
                case 5:
                    FileManager.saveTasksToFile(FILENAME, toDoList.getTasks());
                    System.out.println("Zadania zostały zapisane.");
                    break;
                case 6:
                    exit = true;
                    FileManager.saveTasksToFile(FILENAME, toDoList.getTasks());
                    System.out.println("Zakończono aplikację. Zadania zapisane.");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór.");
            }
        }

        scanner.close();
    }
}
