package jar.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://www.imdb.com/")
public class ImdbHomePage extends PageObject {
    GoogleAuthenticationPage googleAuthenticationPage;

    @FindBy(id="navUserMenu")
    private WebElementFacade loginBlock;

    @FindBy(id="nblogin")
    private WebElementFacade loginLink;

    @FindBy(xpath=".//*[@id='navUserMenu']/p/a")
    private WebElementFacade userBlock;

    @FindBy(css=".cboxIframe")
    private WebElementFacade loginFrame;

    @FindBy(xpath="//*[@id='thirdparty']//a[@rel='open_google']")
    private WebElementFacade loginWithGoogle;

    public void login(String email, String password){
        loginBlock.click();
        loginLink.click();
        getDriver().switchTo().frame(loginFrame);
        loginWithGoogle.click();
        getDriver().switchTo().window(getWindowHandler(1));
        googleAuthenticationPage.login(email, password);
    }

    public Boolean isLoggedIn(){
        return userBlock.isDisplayed();
    }

    private String getWindowHandler(int index){
        return getDriver().getWindowHandles().toArray()[index].toString();
    }
}