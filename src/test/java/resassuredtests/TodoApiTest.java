package resassuredtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TodoApiTest {

    @Test
    public void testGetTodos() {
        given()
                .header("Content-Type", "application/json")
                .body("{\"taskTitle\": \"Test Task\", \"assignedTo\": \"Tester\", \"status\": \"Pending\", \"dueDate\": \"2024-10-21\"}")
                .when()
                .post("/todos")
                .then()
                .statusCode(201);  // Перевіряємо, що створення завдання було успішним

        // Тепер викликаємо GET запит, щоб перевірити чи завдання створене
        RestAssured.get("/todos")
                .then()
                .statusCode(200)
                .body("[0].taskTitle", equalTo("Test Task"));
    }
}