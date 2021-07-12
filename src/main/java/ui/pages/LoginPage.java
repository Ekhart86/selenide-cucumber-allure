package ui.pages;

import annotation.PageUrl;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
@PageUrl(url = "/login")
public class LoginPage extends AbstractPage{

    private final SelenideElement loginField = $("#username");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement signInButton = $("button.radius");
    private final SelenideElement resultMessage = $("#flash");

}
