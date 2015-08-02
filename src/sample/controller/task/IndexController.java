/**
 * 
 */
package sample.controller.task;

//import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

//import sample.model.Tweet;
//import sample.service.TaskService;

/**
 * Initial Controller
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class IndexController extends Controller {

    /**
     * The TwitterService to use.
     * Holds the method for retrieving list of tweets.
     */
    //TwitterService service = new TwitterService();

    @Override
    public Navigation run() throws Exception {
        //List<Tweet> tweetList = service.getTweetList();
        //requestScope("tweetList", tweetList);
        return forward("masterlist.jsp");
    }

}