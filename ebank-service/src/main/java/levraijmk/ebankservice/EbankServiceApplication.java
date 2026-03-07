package levraijmk.ebankservice;

import levraijmk.ebankservice.entities.BankAccount;
import levraijmk.ebankservice.services.EbankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients //pour activer la communication FeignClient
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EbankService ebankService){
        return args -> {
            for(int i = 1; i <= 3; i++){
                ebankService.saveBankAccount(BankAccount.builder()
                        .type(Math.random() < 0.5 ? "CURRENT-ACCOUNT" : "SAVING-ACCOUNT")
                        .balance(1000 * Math.random() * 6000)
                        .customerId(i)
                        .build());
            }
        };
    }

}
