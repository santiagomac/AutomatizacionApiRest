package com.unac.apis;

import com.unac.UserUpdateRequest;
import com.unac.restinteractions.RestInteractions;

public class GoRestApi {

    private static final String TOKEN = "0a5779cb205a4c1f09d6f8629ffe200c4620032c46a062d9a2b3529dd1b8d149";
    private static String pathName = "name";
    private static String pathEmail = "email";

    public static void setBaseUrl(String baseUrl) {
        RestInteractions.setBaseUrl(baseUrl);
    }

    public static void executionGetToken(String endPoint, String idUser){
        RestInteractions.executionGetToken(endPoint,idUser,TOKEN);
    }

    public static void executionPutMethod(String endpoint, String idUser, UserUpdateRequest userUpdateRequest){
        RestInteractions.executionPutMethod(endpoint, idUser, TOKEN, userUpdateRequest);
    }

    public static void validateResponse(Integer statusCode, String name) {
    RestInteractions.validatecode(statusCode);
    RestInteractions.validateDataResponse(name,pathName);
    }

    public static void validateResponse(Integer statusCode, String name, String email){
        RestInteractions.validatecode(statusCode);
        RestInteractions.validateDataResponse(name, pathName);
        RestInteractions.validateDataResponse(email, pathEmail);
    }
}
