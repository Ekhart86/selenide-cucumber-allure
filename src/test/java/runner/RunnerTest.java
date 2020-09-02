package runner;

import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        extraGlue = {"steps", "hooks"},
        tags = {"@all"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"})

public class RunnerTest {

    /**
     * IP of the remote machine. Where is Selenoid deployed
     */
    private static String baseRemoteUrl = "http://192.168.0.109";

    /**
     * Browser and headless values and remote execution ​​are passed from the command line when running tests
     * mvn clean test
     * -Dbrowser=chrome
     * -Dheadless=1
     * -Dremote=true
     * -DremoteUrl=http://192.168.0.110
     * -Dparallel=methods
     * -DthreadCount=2 or -DuseUnlimitedThreads=true
     */

    @BeforeClass
    public static void initSettings() {
        String headless = System.getProperty("headless") == null ? "0" : System.getProperty("headless");
        Configuration.headless = headless.equals("1");
        initRemoteSettings(System.getProperty("remote"), System.getProperty("remoteUrl"));
        Configuration.browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        Configuration.browserSize = "1980x1024";
        Configuration.timeout = 20000;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;
    }

    private static void initRemoteSettings(String remote, String remoteUrl) {
        if (remote != null && remote.equals("true")) {
            baseRemoteUrl = remoteUrl == null ? baseRemoteUrl : remoteUrl;
            Configuration.remote = baseRemoteUrl + ":4444/wd/hub";
        }
    }
}
