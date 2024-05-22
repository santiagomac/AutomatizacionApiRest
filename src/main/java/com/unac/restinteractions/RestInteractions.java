package com.unac.restinteractions;

import com.unac.UserUpdateRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.junit.Assert.assertEquals;

public class RestInteractions {

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
    }

    private static String baseUrl;
    public static void setBaseUrl(String baseUrl) {
        RestInteractions.baseUrl = baseUrl;
    }

    public static void executionGetToken(String endPoint, String idUser, String token) {
        SerenityRest.given().auth().oauth2(token)
                .contentType(ContentType.JSON).when()
                .get(baseUrl.concat(endPoint).concat(idUser));

        SerenityRest.lastResponse().prettyPeek();
    }

    public static void executionPutMethod(String endpoint, String idUser, String token, UserUpdateRequest userUpdateRequest){
        SerenityRest.given().auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(userUpdateRequest)
                .when()
                .put(baseUrl.concat(endpoint).concat(idUser));

        SerenityRest.lastResponse().prettyPeek();
    }

    public static void validatecode(Integer statusCode) {
        Integer statusActual = SerenityRest.lastResponse().statusCode();
        assertEquals(statusCode, statusActual);
    }

    public static void validateDataResponse(String name, String pathName) {
    Map<String, String> object = SerenityRest.lastResponse()
            .jsonPath()
            .getJsonObject("data");
    String campoEvaluar = object.get(pathName);
    assertEquals(name, campoEvaluar);
    }
}
