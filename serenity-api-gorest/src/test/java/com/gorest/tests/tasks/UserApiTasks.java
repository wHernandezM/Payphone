
package com.gorest.tests.tasks;

import com.gorest.tests.model.UserModel;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApiTasks {

    private static final String TOKEN = "COLOCAR_TOKEN_AQUI";

    public static Response createUser(UserModel user) {
        return given()
                .header("Authorization", TOKEN)
                .contentType("application/json")
                .body(user)
            .when()
                .post("/users");
    }

    public static Response updateUserEmail(int id, String newEmail) {
        return given()
                .header("Authorization", TOKEN)
                .contentType("application/json")
                .body("{\"email\": \"" + newEmail + "\"}")
            .when()
                .put("/users/" + id);
    }

    public static Response getUserById(int id) {
        return given()
                .header("Authorization", TOKEN)
            .when()
                .get("/users/" + id);
    }

    public static Response createUserDuplicate(UserModel user) {
        return createUser(user);
    }
}
