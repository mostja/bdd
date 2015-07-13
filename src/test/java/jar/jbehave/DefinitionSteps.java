package jar.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import jar.steps.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the Sokol home page")
    public void givenTheUserIsOnTheSokolHomePage(){
        endUser.openHomePage();
    }

    @When("the user starts a search for <model> phone")
    public void whenTheUserStartsASearchForThePhone(String model) {
        endUser.searchFor(model);
    }

    @Then("<model> phone is the first one in results list")
    public void thenThePhoneIsTheFirstOneInResultsList(String model) {
        endUser.verifyFirstSearchResult(model);
    }
}
