package resassuredtests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
    //@ExtendWith(SpringExtension.class)
    //@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = com.todoapplication.TODOApplication.class)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @ActiveProfiles("test")
    public abstract class BaseTest {
        private static SpringApplication application;
        @PersistenceContext
        private EntityManager entityManager;
        protected static RequestSpecification requestSpec;
        @BeforeAll
        public static void startApp() {
            // Запускаємо Spring Boot додаток перед усіма тестами
            SpringApplication application = new SpringApplication(com.todoapplication.TODOApplication.class);
            application.run();

            requestSpec = RestAssured.given()
                    .baseUri("http://localhost:8080") // Оскільки DEFINED_PORT, то порт 8080
                    .header("Content-Type", "application/json");
        }
        @BeforeEach
        @Transactional
        public void cleanDatabase() {
            // Очищення бази перед кожним тестом
            entityManager.createQuery("DELETE FROM Todo").executeUpdate();
        }
        @AfterAll
        public static void stopApp() {
            // Зупинка Spring Boot додатку після всіх тестів
            System.exit(0);
        }
    }

