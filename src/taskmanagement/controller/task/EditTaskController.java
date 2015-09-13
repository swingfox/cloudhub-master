package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskDto;
import taskmanagement.meta.TaskMeta;
import taskmanagement.model.Task;
import taskmanagement.service.TaskService;

/**
 * Controller to edit task
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/27/2015] 0.02 - Jacquelyn Amaya - Implemented the function for updating the task using JSON
 */
public class EditTaskController extends Controller {
    /**
     * The TaskService to use
     * Holds the method updateTask()
     */
    private TaskService service = new TaskService();
    
    private TaskMeta meta = TaskMeta.get();
    
    @Override
    protected Navigation run() throws Exception {
        response.setContentType("application/json");
        
        TaskDto dto = new TaskDto();
        JSONObject json = null;
        if(isGet()) {
            if(null != requestScope("id")) {
                System.out.println("Id: " + requestScope("id"));
                long taskId = asLong("id");
                Task task = service.getTask(taskId);
                if(null != task) {
                    json = new JSONObject(meta.modelToJson(task));
                    System.out.println("Task Name: " + task.getName());
                }
            }
        } else if(isPut()) {
            try {
                json = new JSONObject((String) this.requestScope("data"));
                dto.setName(json.getString("name"));
                dto.setPhase(json.getString("phase"));
                dto.setEstHours(json.getDouble("estHours"));
                dto.setStartDate(json.getString("startDate"));
                dto.setDueDate(json.getString("dueDate"));
                dto.setId(json.getLong("id"));
                dto = service.updateTask(dto);
            } catch (Exception e) {
                dto.getErrorList().add("Server controller error: " + e.getMessage());
                if (json == null) {
                    json = new JSONObject();
                    json.put("errorList", dto.getErrorList());
                }
            }
            
        }
        
        /*
        try {
            json = new JSONObject((String)this.request.getReader().readLine());
            
            dto.setId(json.getLong("id"));
            dto.setName(json.getString("name"));
            dto.setPhase(json.getString("phase"));
            dto.setEstHours(json.getDouble("estHours"));
            dto.setStartDate(json.getString("startDate"));
            dto.setDueDate(json.getString("dueDate"));
            dto.setSpentHours(json.getDouble("spentHours"));
            if ((dto.getName() == null) || (dto.getPhase() == null) || (dto.getEstHours() == 0.0) || (dto.getStartDate() == null) || (dto.getDueDate() == null) || (dto.getSpentHours() == 0.0)) {
                dto.getErrorList().add("Some fields are blank. Please supply them.");
            } else {
                dto = this.service.updateTask(dto);
            }
        } catch (Exception e) {
            dto.getErrorList().add("Server controller error: " + e.getMessage());
            if (json == null) {
                json = new JSONObject();
            }
        }*/
        
        response.getWriter().write(json.toString());
        return null;
    }

}
