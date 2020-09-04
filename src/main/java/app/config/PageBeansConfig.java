package app.config;

import app.pages.LoginPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

/**
 * SCOPE_CUCUMBER_GLUE - tells Cucumber to remove this bean
 * and recreate a new one if necessary after each scenario.
 */
@Configuration
public class PageBeansConfig {
    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public LoginPage loginPage() {
        return new LoginPage();
    }
}
