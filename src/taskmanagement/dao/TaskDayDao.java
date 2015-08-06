package taskmanagement.dao;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;

import taskmanagement.meta.TaskMeta;
import taskmanagement.model.Task;
import taskmanagement.model.TaskDay;


/**
 * DAO used to access the datastore for task day transactions
 * @author Jacquelyn Amaya
 * @version 0.01 
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/04/2015] 0.02 - David Ramirez   - 
 */
public class TaskDayDao {
    
    /**
     * Method used to save a task
     * @param taskDayModel - task to be saved
     * @return Boolean - true, if task is saved; otherwise, false.
     */
    public boolean saveTaskDay(TaskDay taskDayModel) {
        boolean result = true;
        try {
            Transaction tx = Datastore.beginTransaction();
            //Manually allocate key
            Key key = Datastore.allocateId(KeyFactory.createKey("Account", "Default"), "TaskDay");
            taskDayModel.setKey(key);
            taskDayModel.setId(key.getId());
            Datastore.put(taskDayModel);
            tx.commit();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    
    /**
     * Method used to update a task
     * @param taskDayModel - task to be updated
     * @return Boolean - true, if task is updated; otherwise, false.
     */
    public boolean updateTaskDay(TaskDay taskDayModel) {
        boolean result = true;
        return result;
    }
    
    /**
     * Method used to delete a task 
     * @param taskDayModel - task to be deleted
     * @return Boolean - true, if task is deleted; otherwise, false.
     */
    public boolean deleteTaskDay(TaskDay taskDayModel) {
        boolean result = true;
        return result;
    }
    
    /**
     * Method used to retrieve all the tasks
     * @return List<Task> - list of all tasks
     */
    public List<Task> getAllTTasks() {
        TaskMeta t = new TaskMeta();
        Key parentKey = KeyFactory.createKey("Account", "Default");
        return Datastore.query(t ,parentKey).asList();
    }
}
