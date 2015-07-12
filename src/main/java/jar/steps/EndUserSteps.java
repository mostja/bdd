package jar.steps;

import jar.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static ch.lambdaj.Lambda.join;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

    HomePage homePage;

    @Step
    public void enterKey(String keyword) {
        homePage.enterKeywords(keyword);
    }

    @Step
    public void startSearch() {
        homePage.search();
    }

    @Step
    public void verifyFirstSearchResult(String expectedPhoneName) {
        String firstItemName = homePage.getFirstSearchResultName();
        assertTrue("The first search result is not an expected phone", firstItemName.matches(String.format("Смартфон(.*)%s(.*)", expectedPhoneName)));
    }

    @Step
    public void openHomePage() {
        homePage.open();
    }

    @Step
    public void searchFor(String model) {
        enterKey(model);
        startSearch();
    }
}