package jar.steps;

import jar.pages.ImdbHomePage;
import jar.pages.SokolHomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static ch.lambdaj.Lambda.join;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

    SokolHomePage sokolHomePage;
    ImdbHomePage imdbHomePage;

    @Step
    public void enterKey(String keyword) {
        sokolHomePage.enterKeywords(keyword);
    }

    @Step
    public void startSearch() {
        sokolHomePage.search();
    }

    @Step
    public void verifyFirstSearchResult(String expectedPhoneName) {
        String firstItemName = sokolHomePage.getFirstSearchResultName();
        assertTrue("The first search result is not an expected phone", firstItemName.matches(String.format("Смартфон(.*)%s(.*)", expectedPhoneName)));
    }

    @Step
    public void openSokolHomePage() {
        sokolHomePage.open();
    }

    @Step
    public void searchFor(String model) {
        enterKey(model);
        startSearch();
    }

    @Step
    public void openIMDBHomePage(){
        imdbHomePage.open();
    }

    @Step
    public void logInToImdb(String email, String pasword){
        imdbHomePage.login(email, pasword);
    }

    @Step
    public void verifyUserIsLoggedtoIMDB(){
        assertTrue(imdbHomePage.isLoggedIn());
    }
}