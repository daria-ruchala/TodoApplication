public class TaskManagerTest {
    public static void main(String[] args) {
        testAddTask();
        testRemoveTask();
        testMarkDone();
        testListByCategory();
        System.out.println("All tests passed!");
    }
    public static void testAddTask() {
        Storage storage = new Storage("test_tasks.txt");
        TaskManager manager = new TaskManager(new Storage("test_tasks.txt"));
        manager.addTask("Test Task", "Work");
        if (manager.getTaskCount() == 1) {
            System.out.println("testAddTask PASSED");
        } else {
            System.out.println("testAddTask FAILED");
        }
        new java.io.File("test_tasks.txt").delete();
    }
    public static void testRemoveTask() {
        TaskManager manager = new TaskManager(new Storage("test_tasks.txt"));
        manager.addTask("Test Task", "Work");
        manager.removeTask(1);
        if (manager.getTaskCount() == 0) {
            System.out.println("testRemoveTask PASSED");
        } else {
            System.out.println("testRemoveTask FAILED");
        }
        new java.io.File("test_tasks.txt").delete();
    }

    public static void testMarkDone() {
        TaskManager manager = new TaskManager(new Storage("test_tasks.txt"));
        manager.addTask("Test Task", "Work");
        manager.setTaskStatus(1, true);
        if (manager.getTaskCount() == 1) {
            System.out.println("testMarkDone PASSED");
        } else {
            System.out.println("testMarkDone FAILED");
        }
        new java.io.File("test_tasks.txt").delete();
    }

    public static void testListByCategory() {
        TaskManager manager = new TaskManager(new Storage("test_tasks.txt"));
        manager.addTask("Test Task 1", "Work");
        manager.addTask("Test Task 2", "Personal");
        manager.addTask("Test Task 3", "Work");
        if (manager.getTaskCount() == 3) {
            System.out.println("testListByCategory PASSED");
        } else {
            System.out.println("testListByCategory FAILED");
        }
        new java.io.File("test_tasks.txt").delete();
    }
}
