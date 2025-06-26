package com.restbooker.api;

import pojos.CreateTokenResponsePojo;
import pojos.GetBookingResponsePojo;
import pojos.BookingPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class RestBoookerTests {

    public void ServerHealthCheck(){
        int statusCode;
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        Response response = given()
                .baseUri( RestAssured.baseURI )
                .when()
                .get("/ping")
                .then()
                .extract().response();

        statusCode = response.getStatusCode();

        System.out.println("-->"+response.getStatusCode());
        System.out.println("-->"+response.getBody().asString());
        System.out.println("Server is Alive.");

        Assert.assertEquals(statusCode, 201,"Status code mismatch");
        Assert.assertEquals(response.getBody().asString(),"Created", "Body mismatched " );

    }

    public String createToken(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        String requestBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        CreateTokenResponsePojo response =  given()
                .header("Content-Type","application/json")
                .body(requestBody)
        .when()
                .post("/auth")
        .then()
                .extract()
                .response().as(CreateTokenResponsePojo.class);
        return response.getToken();
    }

    public void createBooking(){
        String requestBody = "{\n" +
                "    \"firstname\" : \"Alen9\",\n" +
                "    \"lastname\" : \"Ben9\",\n" +
                "    \"totalprice\" : 9977,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-03-03\",\n" +
                "        \"checkout\" : \"2025-03-05\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"games12345\"\n" +
                "}";

    String token = createToken();
    System.out.println(" ++++++ ----> token is " + token);
        given()
                .baseUri(RestAssured.baseURI)
                .header("Content-Type","application/json")
                .header("Authorization", token)
                .body(requestBody)
        .when()
                .post("/booking")
        .then()
                .extract().response().getBody().prettyPrint();
}

    public void getBooking(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        int bookingId = 1;
        GetBookingResponsePojo response =
            given()
                .baseUri(baseURI)
                .header("Accept", "application/json")
                .pathParams("id",bookingId)
            .when()
                .get("/booking/{id}")
            .then()
                .statusCode(200)
                .extract()
                .response()
                .as(GetBookingResponsePojo.class);
        System.out.println(response.getFirstname());
        System.out.println(response.getLastname());
        System.out.println(response.getBookingdates().getCheckin());
        System.out.println(response.getBookingdates().getCheckout());
    }

    public void deleteBooking(){
        baseURI = "https://restful-booker.herokuapp.com";
       // String authToken="token=792beea3cd921e7";
        int bookingId = 1;
        given()
                .baseUri(baseURI)
                .header("Cookie","token=792beea3cd921e7")
               // .pathParams("bookingId",bookingId)
        .when()
                .delete("/booking/1")
        .then()
                .extract()
                .response()
                .prettyPrint();
    }


    public static void main(String[] args) {
        RestBoookerTests rs = new RestBoookerTests();
        //rs.ServerHealthCheck();
        //rs.createBooking();
        //rs.getBooking();
        rs.deleteBooking();

    }
}
