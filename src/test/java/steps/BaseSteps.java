package steps;

import io.cucumber.java.ru.Когда;
import org.springframework.boot.test.context.SpringBootTest;
import springbootcucumber.config.PageBeansConfig;

import static com.codeborne.selenide.Selenide.open;

/**
 * В RunnerTest указывается extraGlue = {"steps", "hooks"}
 * Который указывает на этот пакет, в котором должен содержаться
 * хотя бы один класс помеченый аннотацией @SpringBootTest(classes = PageBeansConfig.class)
 * с указанием конфигурационного класса с бинами страниц
 */
@SpringBootTest(classes = PageBeansConfig.class)
public class BaseSteps extends PageSet {

    @Когда("открываем страницу {string}")
    public void открываемСтраницу(String url) {
        open(url);
    }
}
