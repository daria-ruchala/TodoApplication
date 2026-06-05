import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Storage implements TaskStorage {
    private final String fileName;

    public Storage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(List<Task> tasks) {
        try {
            FileWriter writer = new FileWriter(fileName);
            //loop through each task and write it to the file
            for (Task task : tasks) {
                writer.write(task.getId() + "," + task.getTitle() + "," + task.getCategory() + "," + task.getStatus() + "\n");
            }
            writer.close();
            System.out.println("Tasks saved successfully!");

        } catch (IOException exception) {
            exception.printStackTrace(); //what and where went wrong
        }
    }

    @Override
    public List<Task> load() {
        //empty list to store tasks
        List<Task> tasks = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            // read one line at a time until end of file
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Task task = new Task(Integer.parseInt(parts[0]), parts[1], parts[2]); // rebuild Task object
                task.setStatus(Boolean.parseBoolean(parts[3])); //set status of task
                tasks.add(task);
            }
            reader.close();
        } catch (FileNotFoundException e) {
           //just return an empty list if the file doesn't exist'
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return tasks; //return all loaded tasks
    }
}

