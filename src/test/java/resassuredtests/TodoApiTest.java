package resassuredtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TodoApiTest extends BaseTest{

    @Test
    public void testGetTodos() {
        requestSpec
        //given()
                //.header("Content-Type", "application/json")
                .body("{\"taskTitle\": \"Test Task\", \"assignedTo\": \"Tester\", \"status\": \"Pending\", \"dueDate\": \"2024-10-21\"}")
                .when()
                .post("/todos")
                .then()
                .statusCode(200);  // Перевіряємо, що створення завдання було успішним

        // Тепер викликаємо GET запит, щоб перевірити чи завдання створене
        //RestAssured.get("/todos")
         //       .then()
         //       .statusCode(200)
         //       .body("[0].taskTitle", equalTo("Test Task"));
        requestSpec
                .when()
                .get("/todos")
                .then()
                .statusCode(200)
                .body("[0].taskTitle", equalTo("Test Task"));
    }

    @Test
    public void testGet2Todos() {
        requestSpec
    //given()
                //.header("Content-Type", "application/json")
                .body("{\"taskTitle\": \"Task 1\", \"assignedTo\": \"Tester\", \"status\": \"Pending\", \"dueDate\": \"2025-12-31\"}")
                .when()
                .post("/todos")
                .then()
                .statusCode(200);
        requestSpec
    //given()
                //.header("Content-Type", "application/json")
                .body("{\"taskTitle\": \"Task 2\", \"assignedTo\": \"Tester\", \"status\": \"Done\", \"dueDate\": \"2025-12-31\"}")
                .when()
                .post("/todos")
                .then()
                .statusCode(200);
        // Тепер перевіряємо, що обидва завдання є в списку
        //RestAssured.get("/todos")
         //       .then()
         //       .statusCode(200)
         //       .log().all()
         //       .body("[1].taskTitle", equalTo("Task 1"))
         //       .body("[2].taskTitle", equalTo("Task 2"));
        requestSpec
                .when()
                .get("/todos")
                .then()
                .statusCode(200)
                .body("[1].taskTitle", equalTo("Task 1"))
                .body("[2].taskTitle", equalTo("Task 2"));
    }
}