package app.config;

import app.pages.LoginPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Configuration
public class PageBeansConfig {
    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public LoginPage loginPage() {
        return new LoginPage();
    }
}
