package academy.learnprogramming.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 * Initliaze Dispatcher Servlet which is FRONT CONTROLLER OF SPRING MVC
 */

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    // Naming dispatcher servlet
    private static final String DISPATCHER_SERVLET_NAME =   "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        log.info("onStartUp Servlet");

        // create spring application context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        // create dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // register and configure the dispatcher servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

        registration.setLoadOnStartup(1);

        //map to URL pattern
        registration.addMapping("/");

    }
}
