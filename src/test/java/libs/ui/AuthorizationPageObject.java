package libs.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {

    private final static String
    LOGIN_BUTTON = "xpath://div[contains(@class, 'drawer')]/a[@type='button']",
    //LOGIN_BUTTON = "xpath://a[normalize-space(span)='Log in']",
    LOGIN_INPUT = "css:input#wpName1",
    PASSWORD_INPUT = "css:input#wpPassword1",
    SUBMIT_BUTTON = "css:button#wpLoginAttempt";


    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickAuthButton() {
        waitForElementPresent(LOGIN_BUTTON, "Cannot find auth button", 7);
        waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click auth button", 7);

    }

    public void enterLoginData(String login, String password) {
        waitForElementAndSendKeys(LOGIN_INPUT, login,
                "Cannot find and enter a login into the login input", 5);
        waitForElementAndSendKeys(PASSWORD_INPUT, password,
                "Cannot find and enter a login into the login input", 5);
    }

    public void submitForm() {
        waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit auth button", 5);
    }


}
