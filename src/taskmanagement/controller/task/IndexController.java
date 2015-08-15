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
        return forward("masterlist.jsp");
    }

}
