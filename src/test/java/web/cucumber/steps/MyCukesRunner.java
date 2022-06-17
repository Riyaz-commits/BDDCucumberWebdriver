package web.cucumber.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                features = "src/test/resources/features",
                snippets = CucumberOptions.SnippetType.CAMELCASE,plugin = {"html:target/cucumber-reports"},
                dryRun = true
        )
public class MyCukesRunner {
}
