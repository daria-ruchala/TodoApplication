import java.util.List;

public class TaskManager {
    //private fields
    private TaskStorage storage;
    private List<Task> tasks;

    //constructor
    public TaskManager (TaskStorage storage) {
        this.storage = storage; // store the storage so we can use it later
        this.tasks = storage.load(); // load any existing tasks from the file
    }

    //methods
    public void addTask(String title, String category) {
        int id = tasks.size()+1; //generate a unique id for the new task
        Task task = new Task(id, title, category); //new task object
        tasks.add(task); //add the task to the list
        storage.save(tasks); //save the list to the file
        System.out.println("Task added: " + title + "\n");
    }

    /* finding a task by id */

    private Task findById(int id) {
        for (Task task : tasks) { //loop through all tasks
            if (task.getId() == id) { //if the id matches
                return task; //return the task
            }
        }
        return null; //if no task is found
    }

    public void removeTask(int id){
        Task task = findById(id); //find the task by id
        if (task != null) { //if the task is found
            tasks.remove(task); //remove the task
            storage.save(tasks); //save the updated list
            System.out.println("Task removed: " + task.getTitle()+ "\n" );
        } else {
            System.out.println("Task not found \n");
        }
    }

    public void setTaskStatus(int id, boolean status) {
        Task task= findById(id); //find the task by id
        if (task != null) { //if the task is found
            task.setStatus(status); //set the status
            storage.save(tasks); //save the updated list
            System.out.println("Task \"" + task.getTitle() + "\" marked as " + (status ? "done" : "pending") + "\n"); //print the status
        }
        else {
            System.out.println("Task not found! \n");
        }
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
            return;
        }
        for (Task task : tasks) {
            String status = task.getStatus() ? "[DONE]" : "[PENDING]";
            System.out.println(task.getId() + " - " + status + " - " + task.getTitle() + " - " + task.getCategory()+ "\n");
        }
    }

    public void printTasksByCategory(String category) {
        boolean found = false; // track if we found any tasks
        for (Task task : tasks) {
            if (task.getCategory().equals(category)) {
                String status = task.getStatus() ? "[DONE]" : "[PENDING]";
                System.out.println(task.getId() + " - " + status + " - " + task.getTitle() + " - " + task.getCategory()+ "\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found in category: " + category + "\n");
        }

    }
    public int getTaskCount() {
        return tasks.size();
    }

}
