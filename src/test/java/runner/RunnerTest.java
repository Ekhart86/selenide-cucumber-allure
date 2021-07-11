package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        extraGlue = {"api/steps", "database/steps", "ui/steps", "hooks"},
        tags = "@all",
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        strict = true)

public class RunnerTest {
}
