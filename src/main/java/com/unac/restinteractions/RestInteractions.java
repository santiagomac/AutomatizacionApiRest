package com.unac.restinteractions;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import static org.junit.Assert.assertEquals;

public class RestInteractions {

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

    public static void validatecode(Integer statusCode) {
        Integer statusActual = SerenityRest.lastResponse().statusCode();
        assertEquals(statusActual,statusCode);
    }

    public static void validateDataResponse(String name, String pathName) {
    String nombreActual = SerenityRest.lastResponse()
            .jsonPath().getString(pathName);
    assertEquals(nombreActual, name);
    }
}
