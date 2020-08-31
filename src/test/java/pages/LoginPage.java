package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement loginField = $("#username");
    public SelenideElement passwordField = $("#password");
    public SelenideElement signInButton = $("button.radius");
    public SelenideElement successMessage = $("#flash");
}
