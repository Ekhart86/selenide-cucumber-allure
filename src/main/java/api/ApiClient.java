package api;

import com.codeborne.selenide.WebDriverRunner;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import properties.Properties;
import util.ContextKey;
import util.TestContext;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;

public class ApiClient {

    private final Gson gson = new Gson();
    private RequestSpecification requestSpecification;
    private final RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
            .setConfig(newConfig().encoderConfig(encoderConfig().defaultContentCharset(StandardCharsets.UTF_8)))
            .setBaseUri(System.getProperty(Properties.BASE_URL))
            .setRelaxedHTTPSValidation()
            .addFilter(new AllureRestAssured())
            .log(LogDetail.ALL);

    public ApiClient build() {
        requestSpecification = requestSpecBuilder.build();
        return this;
    }

    public Response sendRequest(Method method, int expectedStatusCode, String url, Object... params) {
        return sendRequest(method, true, expectedStatusCode, url, params);
    }

    public Response sendRequest(Method method, boolean redirection, int expectedStatusCode, String url, Object... params) {
        Response response;
        switch (method) {
            case GET:
                response = given().spec(requestSpecification)
                        .redirects().follow(redirection).get(url, params)
                        .then().log().all().extract().response();
                break;
            case PUT:
                response = given().spec(requestSpecification).redirects().follow(redirection)
                        .put(url, params).then().log().all().extract().response();
                break;
            case POST:
                response = given().spec(requestSpecification).redirects().follow(redirection)
                        .post(url, params).then().log().all().extract().response();
                break;
            case DELETE:
                response = given().spec(requestSpecification)
                        .redirects().follow(redirection).delete(url, params)
                        .then().log().all().extract().response();
                break;
            default:
                throw new IllegalArgumentException("HTTP method for this request is not implemented!");
        }
        if (expectedStatusCode != -1) {
            response = response.then().statusCode(expectedStatusCode).extract().response();
        }
        return response;
    }

    public ApiClient addCookies(Cookies cookies) {
        requestSpecBuilder.addCookies(cookies);
        return this;
    }

    public ApiClient setBaseURL(String baseUri) {
        requestSpecBuilder.setBaseUri(baseUri);
        return this;
    }

    public ApiClient addCookiesFromContext() {
        Cookies cookies = TestContext.getContext(ContextKey.AUTH_COOKIES);
        if (cookies == null) {
            Cookies seleniumCookies = getSeleniumCookiesFromContext();
            TestContext.setContext(ContextKey.AUTH_COOKIES, seleniumCookies);
            cookies = seleniumCookies;
        }
        requestSpecBuilder.addCookies(cookies);
        return this;
    }

    public ApiClient addQueryParam(String name, String value) {
        requestSpecBuilder.addQueryParam(name, value);
        return this;
    }

    public ApiClient addJsonBody(Object body) {
        requestSpecBuilder.setBody(gson.toJson(body));
        return this;
    }

    public ApiClient addBody(Object body) {
        requestSpecBuilder.setBody(body);
        return this;
    }

    public ApiClient addFormParam(String paramName, String paramValue) {
        requestSpecBuilder.addFormParam(paramName, paramValue);
        return this;
    }

    public ApiClient addFile(File file) {
        requestSpecBuilder.addMultiPart(file);
        return this;
    }

    public ApiClient addJsonContentType() {
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        return this;
    }

    public ApiClient addFormContentType() {
        requestSpecBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
        return this;
    }

    private Cookies getSeleniumCookiesFromContext() {
        List<org.openqa.selenium.Cookie> seleniumCookies =
                Lists.newArrayList(WebDriverRunner.webdriverContainer.getAndCheckWebDriver().manage().getCookies());
        List<Cookie> cookies = new ArrayList<>();
        seleniumCookies.forEach(cookie -> {
            Cookie.Builder cookieToAdd = new Cookie.Builder(cookie.getName(), cookie.getValue());
            cookieToAdd.setDomain(cookie.getDomain());
            cookieToAdd.setPath(cookie.getPath());
            cookieToAdd.setSecured(cookie.isSecure());
            cookies.add(cookieToAdd.build());
        });
        return new Cookies(cookies);
    }

}
