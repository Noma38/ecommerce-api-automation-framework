package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserAPI {

    // CREATE
    public static Response createUser(Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/users/add");
    }

    // GET
    public static Response getUser(int id) {
        return given()
                .when()
                .get("/users/" + id);
    }

    // UPDATE
    public static Response updateUser(int id, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/users/" + id);
    }

    // DELETE
    public static Response deleteUser(int id) {
        return given()
                .when()
                .delete("/users/" + id);
    }
}