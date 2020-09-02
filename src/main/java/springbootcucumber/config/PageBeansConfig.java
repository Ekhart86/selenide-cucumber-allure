package springbootcucumber.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import springbootcucumber.pages.LoginPage;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

/**
 * This class describes the application pages which will be used in tests
 * Injection of pages into step classes is done using DI Spring
 * SCOPE_CUCUMBER_GLUE - Tells Cucumber to remove this bean
 * And recreate a new one if necessary after each scenario
 */

@Configuration
public class PageBeansConfig {
    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public LoginPage loginPage() {
        return new LoginPage();
    }
}
