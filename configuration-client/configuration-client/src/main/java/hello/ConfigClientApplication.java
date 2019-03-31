package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ConfigClientApplication.class, args);
        //get the generated id from eureka service
        System.out.println(applicationContext.getBean(EurekaClient.class).getApplicationInfoManager().getInfo().getInstanceId());
		System.out.println("id : "+applicationContext.getId());
		System.out.println("name : "+applicationContext.getApplicationName());
		System.out.println("getDisplayName : "+applicationContext.getDisplayName());
//		System.out.println(client.getClass());
    }
}

@RefreshScope
@RestController
@RequestMapping("")
class MessageRestController {
	
	@Autowired
	ApplicationContext applicationContext;

    @Value("${message:Hello default}")
    private String message;
    
    @Value("${stam:Hello default}")
    private String stam;
    
    @Value("${random:Hello default}")
    private String random;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
    @RequestMapping("/stam")
    String getStam() {
    	return this.stam;
    }
    
    @RequestMapping("/random")
    String getRandom() {
    	return this.random;
    }
    
    
    
    @Autowired
    private EurekaClient eurekaClient;
//    @Autowired
//    private DiscoveryClient discoveryClient;
     
    @RequestMapping("/list")
    public List<InstanceInfo> doRequest() {
        Application application 
          = eurekaClient.getApplication("a-bootiful-client");
//        discoveryClient.getInstances("a-bootiful-client")
//        application.getName();
//        InstanceInfo instanceInfo = application.getInstances().get(0);
//        String hostname = instanceInfo.getHostName();
//        int port = instanceInfo.getPort();
//        // ...
//        System.out.println(application.getName());
       return application.getInstances();
    }
    
    
    
}