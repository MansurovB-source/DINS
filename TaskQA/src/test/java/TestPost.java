import domain.Post;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class TestPost {
    public static final String baseUri = "https://jsonplaceholder.typicode.com";
    public static final String posts = "/posts";


    @ParameterizedTest
    @DisplayName("Filtering by query parameters")
    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void filter() {
        long userId = 3;
        List<Post> postsByUserId =
                given()
                        .accept(ContentType.JSON)
                        .baseUri(baseUri)
                        .queryParam("userId", userId)
                        .when()
                        .get(posts)
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .contentType(ContentType.JSON)
                        .extract()
                        .response()
                        .body()
                        .jsonPath().getList(".", Post.class);

        for (Post p : postsByUserId) {
            assertEquals(userId, p.getUserId());
        }


    }


    @ParameterizedTest
    @DisplayName("Get resource by id")
    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void getById(long id) {
        Post p =
                given()
                        .accept(ContentType.JSON)
                        .baseUri(baseUri)
                        .pathParam("id", id)
                        .when()
                        .get("posts/{id}")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .contentType(ContentType.JSON)
                        .extract()
                        .response()
                        .body()
                        .as(Post.class);

        assertEquals(id, p.getId());

    }

    @Test
    @DisplayName("Get list of all resources")
    public void getAll() {
        List<Post> all =
                given()
                        .accept(ContentType.JSON)
                        .baseUri(baseUri)
                        .when()
                        .get(posts)
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .contentType(ContentType.JSON)
                        .extract()
                        .response()
                        .body()
                        .jsonPath().getList(".", Post.class);

        assertEquals(100, all.size());
    }
}
