package steps;

import io.cucumber.java.ru.Когда;
import org.springframework.boot.test.context.SpringBootTest;
import app.config.PageBeansConfig;

import static com.codeborne.selenide.Selenide.open;

@SpringBootTest(classes = PageBeansConfig.class)
public class BaseSteps extends PageSet {

    @Когда("открываем страницу {string}")
    public void открываемСтраницу(String url) {
        open(url);
    }
}
