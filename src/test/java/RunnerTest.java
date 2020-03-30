
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",//путь к функциям
        glue = {"StepDefinition"}//путь к функциям
       // tags = {"@run"}//тег для индексации тестов
)

public class RunnerTest {

}
