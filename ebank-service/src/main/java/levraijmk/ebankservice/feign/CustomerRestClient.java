package levraijmk.ebankservice.feign;

import levraijmk.ebankservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable Long id);


}
