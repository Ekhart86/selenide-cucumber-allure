package api.controllers;

import api.ApiClient;
import io.restassured.http.Method;
import io.restassured.response.Response;
import util.ContextKey;
import util.TestContext;


public class PostController {

    public static void getPosts() {
        Response response = new ApiClient()
                .setBaseURL("https://jsonplaceholder.typicode.com")
                .addJsonContentType()
                .build()
                .sendRequest(Method.GET, 200, "/posts");
        TestContext.setContext(ContextKey.API_RESPONSE, response);
    }

    public static void getPostsWithUserId(Integer userId) {
        Response response = new ApiClient()
                .setBaseURL("https://jsonplaceholder.typicode.com")
                .addJsonContentType()
                .addQueryParam( "userId", userId.toString())
                .build()
                .sendRequest(Method.GET, 200, "/posts");
        TestContext.setContext(ContextKey.API_RESPONSE, response);
    }

}


