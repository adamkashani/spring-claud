package client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//give the service name to get list of this service from eureka
//@FeignClient(name = "${feign.name}", url = "${feign.url}")
@FeignClient(name="a-bootiful-client")
public interface Client {
	
    @RequestMapping(method = RequestMethod.GET, value = "/message")
    String getMessage();
    
    @RequestMapping(method = RequestMethod.GET, value = "/stam")
    String getStam();
    
    @RequestMapping(method = RequestMethod.GET, value = "/random")
    String getRandom();
    
    
}
