package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {
    private static final String LOGIN = "auth/login/";
    private static final String UPDATE_OR_DELETE = "auth/user/";
    private static final String REGISTER = "auth/register/";

    @Step("Создание пользователя")
    public Response createUser(User user) {
        return (Response) given()
                .spec(getBaseSpecSettings())
                .body(user)
                .when()
                .post(REGISTER)
                .then()
                .extract();
    }

    @Step("Логин пользователя")
    public static Response login(UserCredentials creds) {
        return (Response) given()
                .spec(getBaseSpecSettings())
                .body(creds)
                .when()
                .post(LOGIN)
                .then()
                .extract();
    }

    @Step("Удаление пользователя")
    public void delete(Response response) {
        String accessToken = response.body().jsonPath().getString("accessToken");
        if (accessToken == null) {
            return;
        }
        given()
                .spec(getBaseSpecSettings())
                .header("authorization", accessToken)
                .when()
                .delete(UPDATE_OR_DELETE);
    }
}
