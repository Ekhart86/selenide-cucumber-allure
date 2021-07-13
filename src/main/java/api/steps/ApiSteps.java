package api.steps;

import api.controllers.PostController;
import api.model.Post;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import util.ContextKey;
import util.TestContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ApiSteps {

    @When("get all posts via API call")
    public void getAllPostsViaAPICall() {
        PostController.getPosts();
    }

    @When("get all posts with userId {int} via API call")
    public void getPostsWithUserId(Integer userId) {
        PostController.getPostsWithUserId(userId);
    }

    @Then("posts list has size {int}")
    public void postsListSizeIsMoreThanZero(int size) {
        Response response = TestContext.getContext(ContextKey.API_RESPONSE);
        Post[] posts = response.body().as(Post[].class);
        assertEquals("List size should be "+ size, size, posts.length);
    }

    @Then("all posts have userId {int}")
    public void allPostsHaveUserId(Integer userId) {
        Response response = TestContext.getContext(ContextKey.API_RESPONSE);
        List<Post> posts = Arrays.asList(response.body().as(Post[].class));
        posts.forEach(post -> assertEquals("UserId should be " + userId, userId, post.getUserId()));
    }

}
