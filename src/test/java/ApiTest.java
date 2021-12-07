import PageObject.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiTest extends BaseTest {


    @BeforeTest
    public void beforeTest() {
        baseURI = "https://catalog.onliner.by";
    }

    @Test()
    public void apiGet() {
        String endpoint = "/sdapi/pogoda/api/now";
        given()
                .get(endpoint)
                .then()
                .statusCode(200);
        given()
                .get(endpoint)
                .then()
                .body("city", is("Минске"));
        Assert.assertTrue(
                given()
                .get(endpoint)
                .then().extract()
                        .response().time()<200);
    }
    @Test()
    public void apiPost() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("login", "wavan2012@gmail.com");
        requestBody.put("password", "32423345345bB");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json;charset=UTF-8");
        request.body(requestBody.toJSONString());
        Response response = request.post("/sdapi/user.api/login");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

}

