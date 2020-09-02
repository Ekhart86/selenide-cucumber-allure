package steps;

import io.cucumber.java.ru.Когда;
import org.springframework.boot.test.context.SpringBootTest;
import springbootcucumber.config.PageBeansConfig;

import static com.codeborne.selenide.Selenide.open;

/**
 * RunnerTest specifies extraGlue = {"steps", "hooks"}
 * Which indicates this package which should contain
 * at least one class marked with SpringBootTest annotation
 * indicating the configuration class with page bins
 */
@SpringBootTest(classes = PageBeansConfig.class)
public class BaseSteps extends PageSet {

    @Когда("открываем страницу {string}")
    public void открываемСтраницу(String url) {
        open(url);
    }
}
