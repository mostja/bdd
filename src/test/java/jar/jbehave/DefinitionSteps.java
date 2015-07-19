package jar.jbehave;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import jar.steps.EndUserSteps;

public class DefinitionSteps {
    @AfterStory
    public void deleteCookies (){
        WebDriver driver = endUser.getDriver();
        driver.manage().deleteAllCookies();
    }

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the Sokol home page")
    public void givenTheUserIsOnTheSokolHomePage(){
        endUser.openSokolHomePage();
    }

    @When("the user starts a search for <model> phone")
    public void whenTheUserStartsASearchForThePhone(String model) {
        endUser.searchFor(model);
    }

    @Then("<model> phone is the first one in results list")
    public void thenThePhoneIsTheFirstOneInResultsList(String model) {
        endUser.verifyFirstSearchResult(model);
    }

    @Given("Registered user with credentials <email>, <password>")
    public void givenRegisteredUserWithCredentialsemailpassword(String email, String password) {
        Serenity.getCurrentSession().put("email", email);
        Serenity.getCurrentSession().put("password", password);
    }

    @When("The user is on IMDB home page")
    public void whenTheUserIsOnIMDBHomePage() {
        endUser.openIMDBHomePage();
    }

    @Then("The user can log in to the system")
    public void thenTheUserCanLogInToTheSystem() {
        String email = (String)Serenity.getCurrentSession().get("email");
        String password = (String)Serenity.getCurrentSession().get("password");
        endUser.logInToImdb(email,password);
        endUser.verifyUserIsLoggedtoIMDB();
    }
}
