package com.coforge;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class ApiHelper
{
    private static String postReqBody = "Request\n" +
            "/api/users\n" +
            "\n" +
            "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";
    private static String putReqBody="{\n" +
            "    \"name\": \"Test\",\n" +
            "    \"job\": \"Manager\"\n" +
            "}";

    public  void getReq(String path)
    {
        Response res=given().when().get(path).then().extract().response();
        res.prettyPrint();
        assertEquals(200, res.statusCode());

    }
    public  void postReq(String path)
    {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(postReqBody)
                .when()
                .post(path)
                .then()
                .extract().response();

        assertEquals(201, response.statusCode());
        assertEquals("morpheus", response.jsonPath().getString("name"));
        assertEquals("leader", response.jsonPath().getString("job"));


    }

    public  void putRequest(String path)
    {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(putReqBody)
                .when()
                .put(path)
                .then()
                .extract().response();


        assertEquals(200, response.statusCode());
        assertEquals("Test", response.jsonPath().getString("name"));
        assertEquals("Manager", response.jsonPath().getString("job"));

    }

    public  void deleteRequest(String path)
    {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete(path)
                .then()
                .extract().response();


       Assert.assertEquals(204, response.statusCode());
    }






}
