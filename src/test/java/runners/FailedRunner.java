package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //in failed runner just 2 things are required features and glue
        // features we use to provide the path of all the feature files
        features = "@target/failed.txt",
        //glue keyword we use to provide the path of the package where step defs are available
        glue = "steps",

        plugin = {"pretty"}
)
public class FailedRunner {

}
