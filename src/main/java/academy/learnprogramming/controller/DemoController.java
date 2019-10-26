package academy.learnprogramming.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

/*******Handler Mapping*********
 * 1 Request to dispatcher ->
 * 2 dispatcher request to mapper for handler method ->
 * 3. handler method returned to dispatcher ->
 * 4. dispatcher calls handler method ->
 * 5. handler method executes return ("hello" or "welcome" in this case) usually a model to dispatcher->
 * 6. dispatcher sends viewResolver view name("hello" or "welcome") (finds JSP file)
 * 7. view resolver sends back view (sets prefix and suffix) to generate http://localhost:8080/todo-list/WEBINF/view/<returned value from handler>
 * 8. dispatcher sends view
 * 9. view is rendered and content sent back to dispatcher
 * 10. dispatcher sends response
 */

@Slf4j
//@Controller means web controller
@Controller
public class DemoController {


    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello (){

        // prefix + name + suffix (WEB-INF/view/hello.jsp)
        return "hello";
    }

    // http://localhost:8080/todo-list/welcome
    @GetMapping("welcome")
    public String welcome(Model model){

        model.addAttribute("user", "David");
        log.info("model = {}", model);
        // prefix + name + suffix (WEB-INF/view/welcome.jsp)
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){

        log.info("welcomeMessage() called");
        return "Welcome to this Demo App";
    }


    //      Test trying to get index.html to load
//    @ResponseBody
//    @GetMapping("index")
//    public String index (){
//
//        return "index";
//    }
//

    //@GetMapping("test")
//    public String test(Model model){
//
//        model.addAttribute("user", "David");
//        log.info("model = {}", model);
//        // prefix + name + suffix (WEB-INF/view/welcome.jsp)
//        return "test";
//    }
}
