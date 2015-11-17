package com.app;

import com.app.common.SampleData;
import com.app.web.dto.AuthorDto;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;

public class AuthorControllerTest extends AbstractControllerTest {

    @Test
    public void testSaveAuthor() {
        // Create author with article
        AuthorDto authorDto = SampleData.createAuthorWithArticle(1);
        Response postResponse = RestAssured.given().contentType(ContentType.JSON).body(authorDto)
                .when().post("/authors");
        postResponse.then().statusCode(200)
                .and().assertThat().body("id", notNullValue())
                .body("articles", notNullValue());

        // Get Author from response
        AuthorDto responseAuthor = postResponse.getBody().as(AuthorDto.class);

        if(CollectionUtils.isEmpty(responseAuthor.getArticles())) {
            Assert.fail("Author.articles should not be empty");
        }
    }
}
