package TestCases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class getPetIdTest {
   int petId;
    private Response response;
    static String url = "https://petstore.swagger.io/v2/pet/";

    @Given("I set the pet id to {int}")
    public void PetIdEndpoint(int id) {
        this.petId = id;
    }

    @When("I send a GET request to the Petstore API")
    public void i_send_a_get_request_to_the_petstore_api() {
        response = RestAssured
                .given()
                .when()
                .get(url + petId);
    }

    @Then("the response should be {int},{string}")
    public void the_response_should_be(int statusCode,String petName) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
        String actualPetName = response.jsonPath().getString("name");
        assertThat(actualPetName, equalTo(petName));
    }
}
