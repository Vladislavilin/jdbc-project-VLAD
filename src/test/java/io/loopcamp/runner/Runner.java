package io.loopcamp.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/html-report/cucumber-reports.html",
                "json:target/json-reports/json-report",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features" ,
        glue = "io/loopcamp/steps",
        dryRun = false,
        //tags = "",
        monochrome = true
)

public class Runner {

}
