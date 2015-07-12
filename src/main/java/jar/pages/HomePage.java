package jar.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ch.lambdaj.function.convert.Converter;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://www.sokol.ua")
public class HomePage extends PageObject {

    @FindBy(id="field-input-search")
    private WebElementFacade searchTextField;

    @FindBy(id="btn-search-top")
    private WebElementFacade searchButton;

    @FindBy(xpath=".//*[@id='page']/div/div[1]/div/section/div[2]/div/div[2]/div[1]/div[3]/div[1]/a")
    private WebElementFacade firstElement;

    public void enterKeywords(String keyword) {
        searchTextField.type(keyword);
    }

    public void search() {
        searchButton.click();
    }

    public String getFirstSearchResultName() {
        return firstElement.getText().toString();
    }
}
