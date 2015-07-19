package jar.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class GoogleAuthenticationPage extends PageObject {

    @FindBy(id="Email")
    private WebElementFacade emailTextField;

    @FindBy(id="next")
    private WebElementFacade nextButton;

    @FindBy(id="Passwd")
    private WebElementFacade passwordTextField;

    @FindBy(id="signIn")
    private WebElementFacade signInButton;

    public void login(String email, String password)  {
        emailTextField.sendKeys(email);
        nextButton.click();
        passwordTextField.sendKeys(password);
        signInButton.click();
    }
}
