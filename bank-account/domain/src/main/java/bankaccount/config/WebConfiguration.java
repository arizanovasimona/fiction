package bankaccount.config;

import bankaccount.adapter.database.BankAccountRepositoryImpl;
import bankaccount.domain.service.BankAccountService;
import bankaccount.port.BankAccountPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

    @Bean
    public BankAccountPort bankAccountPort(){
        return new BankAccountService();
    }

    @Bean
    public BankAccountRepositoryImpl bankAccountRepositoryPort() {
        return new BankAccountRepositoryImpl();
    }
}