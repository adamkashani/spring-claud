package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.netflix.discovery.DiscoveryClient;



@SpringBootApplication
@RestController
@RibbonClient(name = "say-hello", configuration = SayHelloConfiguration.class)  // Add for Ribbon 
public class ClientMain {

  @LoadBalanced  // Add for Ribbon 
  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Autowired
  RestTemplate restTemplate;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  ctx =    new AnnotationConfigApplicationContext(ClientMain.class);
//		SpringApplication.run(ClientMain.class, args);
	}



//	private DiscoveryClient discoveryClient;
}


