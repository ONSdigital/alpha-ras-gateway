package rasgateway;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


@RefreshScope
@RestController
public class MainController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }

    /*  write some code here to access the microservice,
    search for the below line:

    String greeting = this.restTemplate.getForObject("http://say-hello/greeting", String.class);

    at this url : https://spring.io/guides/gs/client-side-load-balancing/ */

    
    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

}

