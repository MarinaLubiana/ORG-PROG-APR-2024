package org.prog.dto;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.devtools.v121.network.model.Response;
import org.testng.Assert;

public class RestTest {
    @Test
    public void restTest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("api/");
        requestSpecification.queryParam("inc", "gender,name,nat");
//TODO: UNCOMMENT >>>> requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");

        Response response = requestSpecification.get();

        response.prettyPrint();

        ValidatableResponse validatableResponse = response.then();
        public void restTest() {
            ResponseDto responseDto = response.as(ResponseDto.class);
            Assert.assertFalse(responseDto.getResults().isEmpty(),
                    "No persons generated! Failing test,");

            // Перевірка, що опис часового поясу не є пустим
            for (PersonDto person : responseDto.getResults()) {
                LocationDto location = person.getLocation();
                Assert.assertNotNull(location.getTimezone().getDescription(),
                        "Timezone description is empty!");
            }
        }

        @Test
        public void prettyTest() {
            RestAssured.given()
                    .baseUri("https://randomuser.me/")
                    .basePath("api/")
                    .queryParam("inc", "gender,name,nat")
                    .queryParam("inc", "gender,name,nat,location")
                    .queryParam("noinfo")
                    .get()
                    .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON);
        }
    }
}
}
