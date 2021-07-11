package ui.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LoginPage {

    private final SelenideElement loginField = $("#username");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement signInButton = $("button.radius");
    private final SelenideElement resultMessage = $("#flash");

}
