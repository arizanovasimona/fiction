import bankaccount.adapter.API.BankAccountController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@EnableAutoConfiguration
@ComponentScan (basePackages = "bankaccount.port")
@ComponentScan(basePackageClasses = BankAccountController.class)
@RequiredArgsConstructor
public class BankAccountBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountBasicApplication.class, args);
    }
}