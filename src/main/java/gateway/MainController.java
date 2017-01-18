package rasgateway;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@RestController
public class MainController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    /*  write some code here to access the microservice,
    search for the below line:

    String greeting = this.restTemplate.getForObject("http://say-hello/greeting", String.class);

    at this url : https://spring.io/guides/gs/client-side-load-balancing/ */

}

