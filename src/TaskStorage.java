import java.util.List;

public interface TaskStorage {
    //saves a list of tasks
    void save(List <Task> tasks);
    //returns a list of tasks
    List <Task> load();
}
