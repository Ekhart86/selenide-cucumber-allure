package springbootcucumber.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import springbootcucumber.pages.LoginPage;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

/**
 * В этом классе описываются станицы приложения
 * которые будут использованы в тестах
 * Внедрение страниц в step классы происходит с помощью DI Spring
 * SCOPE_CUCUMBER_GLUE - сообщает Cucumber удалить этот bean
 * и воссоздать новый, если необходимо, после каждого сценария
 */

@Configuration
public class PageBeansConfig {
    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public LoginPage loginPage() {
        return new LoginPage();
    }
}
