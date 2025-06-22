package user;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
public class UserResourceTest {

    @Test
    void 一覧取得() {
        given()
            .when().get("/user")
            .then()
            .statusCode(200)
            .body(
                ".", hasSize(3),
                "[0].userId", is(1),
                "[0].userName", is("taro"),
                "[0].email", is("example@yahoo.co.jp"),
                "[1].userId", is(2),
                "[1].userName", is("jiro"),
                "[1].email", is("example@google.com"),
                "[2].userId", is(3),
                "[2].userName", is("saburo"),
                "[2].email", is("example@hoge.com")
                );
    }

    @Test
    void 一件取得() {
        given()
            .when().get("/user/1")
            .then()
            .statusCode(200)
            .body(
                "userId", is(1),
                "userName", is("taro"),
                "email", is("example@yahoo.co.jp")
                );
    }

}
