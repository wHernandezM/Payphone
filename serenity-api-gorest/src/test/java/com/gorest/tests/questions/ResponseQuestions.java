
package com.gorest.tests.questions;

import io.restassured.response.Response;

public class ResponseQuestions {

    public static int extractId(Response response) {
        return response.jsonPath().getInt("id");
    }

    public static String extractEmail(Response response) {
        return response.jsonPath().getString("email");
    }

    public static String extractFieldMessage(Response response, String fieldName) {
        return response.jsonPath().getList("field").contains(fieldName) ? "found" : "not_found";
    }
}
