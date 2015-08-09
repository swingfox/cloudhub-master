/**
 * 
 */
package taskmanagement.controller.task;


import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskClientDto;
import taskmanagement.service.TaskService;

/**
 * Initial Controller
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/07/2015] 0.02 - Jacquelyn Amaya - Implemented retrieving list of tasks using JSON
 */
public class IndexController extends Controller {

    /**
     * The TwitterService to use.
     * Holds the method for retrieving list of tasks.
     */
    TaskService service = new TaskService();

    @Override
    public Navigation run() throws Exception {
        TaskClientDto taskList = new TaskClientDto();
        JSONObject json = new JSONObject();
        try {
            taskList = service.getTaskList();
        } catch (Exception e) {
            e.printStackTrace();
            taskList.getErrorList().add("Server controller error: " + e.getMessage());
        }
        
        json.put("taskList", taskList.getTaskList());
        json.put("errorList", taskList.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
        /*List<Task> taskList = service.getTaskList();
        requestScope("taskList", taskList);
        return forward("masterlist.jsp");*/
    }

}