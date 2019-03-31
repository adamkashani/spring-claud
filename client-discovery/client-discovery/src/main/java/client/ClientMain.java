package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
public class ClientMain {
	
//	@Autowired
//	StoreClient storeClient;

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ClientMain.class, args);
		Client client = applicationContext.getBean(Client.class);
		System.out.println(applicationContext.getId());
		System.out.println(applicationContext.getApplicationName());
//		System.out.println(client.getClass());
		System.out.println(client.getMessage());
		System.out.println(client.getRandom());
		System.out.println(client.getRandom());
		System.out.println(client.getRandom());
		System.out.println(client.getRandom());
		System.out.println(client.getRandom());
		System.out.println(client.getRandom());
		System.out.println(client.getRandom());
	}
	
}

