//Autor Kamil Pajączkowski
import java.io.*;
import java.util.List;

public class FileManager {
    public static void saveTasksToFile(String filename, List<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.println(task.isCompleted() + ";" + task.getDescription());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static void loadTasksFromFile(String filename, ToDoList toDoList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                boolean isCompleted = Boolean.parseBoolean(parts[0]);
                String description = parts[1];
                Task task = new Task(description);
                if (isCompleted) {
                    task.markAsCompleted();
                }
                toDoList.addTask(task.getDescription());
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}
