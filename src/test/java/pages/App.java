package pages;

public class App {
    public LoginPage loginPage;

    public App() {
        loginPage = PageBuilder.buildLoginPage();
    }
}
