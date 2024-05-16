package com.unac.stepsdefinitions;

import com.unac.apis.GoRestApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetGoRestStepsdefinitions {
    @Given("se establece la base url {string}")
    public void seEstableceLaBaseUrl(String baseUrl) {
        GoRestApi.setBaseUrl(baseUrl);
    }

    @When("se consulta en el endpoint {string}  por id {string}")
    public void seConsultaEnElEndpointPorId(String endPoint, String idUser) {
    GoRestApi.executionGetToken(endPoint,idUser);
    }

    @Then("se valida que el status code {int} y que contenga el nombre {string}")
    public void seValidaQueElStatusCodeYQueContengaElNombre(Integer statusCode, String name) {
        GoRestApi.validateResponse(statusCode,name);
    }
}
