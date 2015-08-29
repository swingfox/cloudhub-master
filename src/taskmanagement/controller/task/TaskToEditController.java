package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskDto;
import taskmanagement.service.TaskService;

/**
 * Controller to edit task
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/27/2015] 0.01 - Jacquelyn Amaya - Implemented the function to display the details of the task to edit
 */
public class TaskToEditController extends Controller {
    /**
     * The TaskService to use
     * Holds the method updateTask()
     */
    private TaskService service = new TaskService();
    
    @Override
    protected Navigation run() throws Exception {
        TaskDto dto = new TaskDto();
        JSONObject json = null;
        try {
            json = new JSONObject((String)this.requestScope("data"));
            
            dto.setId(json.getLong("id"));
            dto.setTaskName(json.getString("name"));
            dto.setName(json.getString("name"));
            int phase = json.getInt("phase"); 
            switch (phase) {
                case 1:
                    dto.setPhase("Testing");
                    break;
                case 2:
                    dto.setPhase("Coding");
                    break;
                case 3:
                    dto.setPhase("Design");
                    break;
                default:
                    dto.setPhase("Testing");
            }
            dto.setEstHours(json.getDouble("estHours"));
            dto.setStartDate(json.getString("startDate"));
            dto.setDueDate(json.getString("dueDate"));
            //if () {
                //dto.getErrorList().add("Some fields are blank. Please supply them.");
            //} else {
        //        dto = this.service.selectTask(dto);
                //json.
            //}
            
          //  dto = this.service.editTask(dto);
        } catch (Exception e) {
         //   dto.getErrorList().add("Server controller error: " + e.getMessage());
            if (json == null) {
                json = new JSONObject();
            }
        }

        json.put("errorList", dto.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return forward("edit_task.jsp");
    }
}
