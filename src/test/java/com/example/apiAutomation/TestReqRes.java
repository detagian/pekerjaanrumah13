package com.example.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.json.JSONObject;


import java.io.File;

public class TestReqRes {
    private ValidatableResponse Response;
    public TestReqRes(ValidatableResponse Response){
        this.Response = Response;
    }
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    public void setEndpointMethodGet(String url){
         Response = RestAssured
                .given().when()
                .get(url)
                .then().log().all();
    }

    public void setEndpointPOSTForLogin(String url,String Email, String Password){
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("email",Email);
        bodyObj.put("password",Password);
        Response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Äccept", "applicaiton/json")
                .body(bodyObj.toString())
                .when()
                .post("/login")
                .then().log().all();
    }

    public void verifyResponseCode (int responseCode){
        Response.assertThat().statusCode(responseCode);

    }

    public void verifyTotal(int total){
        Response.assertThat().body("total",Matchers.equalTo(total));
    }

    public void verfiyJSONScheme(String filename){
        String location ="src/test/resources/jsonScheme/"+filename ;
        File jsonScheme = new File(location);
        Response.assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonScheme));
    }

}