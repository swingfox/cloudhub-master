package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskDto;
import taskmanagement.model.Task;
import taskmanagement.service.TaskService;

/**
 * Controller to display the list of completed tasks
 * @author David Ramirez
 * @version 0.02
 * Version History
 * [08/27/2015] 0.01 - Jacquelyn Amaya - Set finished attribute of task
 * [08/30/2015] 0.02 - David Ramirez   - Finish task function is now working
 * [09/22/2015] 0.03 - Jacquelyn Amaya - Added error if task has zero spent hours
 */
public class CompleteTaskController extends Controller {
    /**
     * The TaskService to use
     * Holds the method updateTask()
     */
    private TaskService service = new TaskService();
    
    @Override
    protected Navigation run() throws Exception {
        response.setContentType("application/json");
        
        TaskDto dto = new TaskDto();
        JSONObject json = null;
        try {
            json = new JSONObject((String)this.request.getReader().readLine());
            dto.setId(json.getLong("id"));
            Task task = service.getTask(dto.getId());
            if(task.getSpentHours() != 0.0) {
                dto = this.service.finishTask(dto);
            } else {
                dto.getErrorList().add("You have not set spent hours for this task.");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            dto.getErrorList().add("Server controller error: " + e.getMessage());
            if (json == null) {
                json = new JSONObject();
            }
        }
        
        json.put("errorList", dto.getErrorList());
        response.getWriter().write(json.toString());
        return null;
    }

}
