
package com.gorest.tests.runner;

import com.gorest.tests.model.UserModel;
import com.gorest.tests.questions.ResponseQuestions;
import com.gorest.tests.tasks.UserApiTasks;
import io.restassured.response.Response;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserApiTest {

    static int userId;
    static String originalEmail;
    static String updatedEmail;

    @Test
    @Order(1)
    void CreacionUsuario() {
        originalEmail = "user_" + UUID.randomUUID() + "@mail.com";
        UserModel user = UserModel.builder()
                .name("QA Test")
                .gender("male")
                .email(originalEmail)
                .status("active")
                .build();

        Response response = UserApiTasks.createUser(user);

        response.then().statusCode(201);
        userId = ResponseQuestions.extractId(response);
        assertThat(userId).isGreaterThan(0);
        assertThat(ResponseQuestions.extractEmail(response)).isEqualTo(originalEmail);
    }

    @Test
    @Order(2)
    void ActualizacionEmail() {
        updatedEmail = "updated_" + UUID.randomUUID() + "@mail.com";
        Response response = UserApiTasks.updateUserEmail(userId, updatedEmail);

        response.then().statusCode(200);
        assertThat(ResponseQuestions.extractEmail(response)).isEqualTo(updatedEmail);
    }

    @Test
    @Order(3)
    void ConsultarUsuarioId() {
        Response response = UserApiTasks.getUserById(userId);

        response.then().statusCode(200);
        assertThat(ResponseQuestions.extractEmail(response)).isEqualTo(updatedEmail);
    }

    @Test
    @Order(4)
    void IntentarCrearUsuarioEmailDuplicado() {
        UserModel user = UserModel.builder()
                .name("Duplicate Test")
                .gender("female")
                .email(updatedEmail)
                .status("active")
                .build();

        Response response = UserApiTasks.createUserDuplicate(user);

        response.then().statusCode(422);
        assertThat(ResponseQuestions.extractFieldMessage(response, "email")).isEqualTo("found");
    }
}
