package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "html:target/reports/html-reports/default-cucumber-reports.html",//html formatinda rapor almak icin kullanilan plugin
                "rerun:target/failedRerun.txt",
        },
        features = "src/test/resources/features",
        glue = {"stepdefinitions","base_urls"},
        tags = "@End2End",
        dryRun = false

)
public class Runner {}
