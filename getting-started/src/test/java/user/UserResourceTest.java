package user;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
public class UserResourceTest {

// [
//   {
//     "userId": 1,
//     "userName": "taro",
//     "email": "example@yahoo.co.jp"
//   },
//   {
//     "userId": 2,
//     "userName": "jiro",
//     "email": "example@google.com"
//   },
//   {
//     "userId": 3,
//     "userName": "saburo",
//     "email": "example@hoge.com"
//   }
// ]



    @Test
    void testHelloEndpoint() {
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
}
