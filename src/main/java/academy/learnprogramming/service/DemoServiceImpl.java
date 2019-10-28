package academy.learnprogramming.service;

import academy.learnprogramming.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {



    @Override
    public String getHelloMessage(String user) {
        log.info("In getHelloMessage and user = " + user);
        return "Hello " + user;
    }

    @Override
    public String getWelcomeMessage() {

        log.info("In getWelcomeMessage");
        return "Welcome to this demo application";
    }
}
