package io.loopcamp.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loopcamp.jdbctests.utility.ConfigurationReader;
import io.loopcamp.jdbctests.utility.DB_Util;
import org.apache.hc.core5.http.impl.io.IdentityOutputStream;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class UserInfoStepDefs {
    @Given("Establish teh database connection")
    public void establish_teh_database_connection() {

        System.out.println("Connection is handled in hooks");

    }

    @When("Execute query to get all columns for {string}")
    public void execute_query_to_get_all_columns_for(String string) {
        DB_Util.runQuery("select * from identity."+string);

    }
    @Then("verify the below column sare listed in result for")
    public void verify_the_below_column_sare_listed_in_result_for(List<String> expected) {

      assertEquals(expected, DB_Util.getColumnDataAsList("name"));






    }

}
