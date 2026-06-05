import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager(new Storage("tasks.txt"));
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Todo: \n ");

        while (running) {
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Delete Task");
            System.out.println("4. List Tasks");
            System.out.println("5. List Tasks by Category");
            System.out.println("6. Exit");
            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter task title: ");
                String title = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                manager.addTask(title, category);
            }
            else if (choice == 4) {
                manager.printTasks();
            }
            else if (choice == 5) {
                System.out.print("Enter category: ");
                manager.printTasksByCategory(scanner.nextLine());
            }
            else if (choice == 2) {
                System.out.print("Enter task id: ");
                int id = scanner.nextInt();
                manager.setTaskStatus(id, true);
            }
            else if (choice == 3) {
                System.out.print("Enter task id: ");
                int id = scanner.nextInt();
                manager.removeTask(id);
            }
            else if (choice == 6) {
                System.out.println("Goodbye! ");
                running = false;
            }
            else {
                System.out.println("Invalid choice ");
            }
        }
        scanner.close();
    }
}
