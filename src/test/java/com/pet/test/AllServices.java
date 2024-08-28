package com.pet.test;

import com.pet.utility.AllureLogger;
import com.pet.utility.BaseTest;
import com.pet.utility.ReadProperties;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class AllServices extends BaseTest {

    public static String id = ReadProperties.getID();
    public static String petId =ReadProperties.getPetId();
    public static String status=ReadProperties.getStatus();
    public static String quantity=ReadProperties.getQuantity();
    public static String shipDate=ReadProperties.getshipDate();
    public static String complete= ReadProperties.getCompleteStatus();

    @Test
    public void get_findByStatus() {
        AllureLogger.logToAllure("Starting the test to get find by status");
        AllureLogger.logToAllure("Sending the GET request");

        Response response = given()
                .spec(requestSpec)
                .contentType("application/json")
                .when()
                .get("/pet/findByStatus?status="+status)
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        logResponseAsString(response);
    }

    @Test
    public void get_PetsById() {
        AllureLogger.logToAllure("Starting the test to get pets by Id");
        AllureLogger.logToAllure("Sending the GET request");
        Response response = given().
                spec(requestSpec).
                contentType("application/json").
                when().
                get("/pet/"+petId).
                then().
                assertThat().statusCode(404).extract().response();

        logResponseAsString(response);
    }

    @Test
    public void post_Order() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", id);
        requestParams.put("petId",petId);
        requestParams.put("quantity",quantity);
        requestParams.put("shipDate",shipDate);
        requestParams.put("status",status);
        requestParams.put("complete",complete);

        AllureLogger.logToAllure("Starting the test to post order");

        AllureLogger.logToAllure("Sending the post request");
        Response response = given().
                spec(requestSpec).
                contentType("application/json").
                body(requestParams).
                post("/store/order");

        logResponseAsString(response);

    }

}
