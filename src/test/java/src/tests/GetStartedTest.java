package src.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import libs.CoreTestCase;
import libs.Platform;
import libs.ui.WelcomePageObject;
import libs.ui.factories.WelcomePageFactory;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    @Features(value={@Feature(value="Onboarding")})
    @DisplayName("Skip onboarding")
    @Description("We start app and skip onboard")
    @Step("Starting test testPassThrowWelcome")
    @Severity(value=SeverityLevel.BLOCKER)
    public void testPassThrowWelcome() {
        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMW())) {
            return; }

        WelcomePageObject welcomePageObject = WelcomePageFactory.get(driver);

        welcomePageObject.waitForLearnMoreLink();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForNewWayToExploreText();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForAddOrEditPreferredLangText();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForLearnMoreAboutDataCollectedText();
        welcomePageObject.clickGetStartedButton();
    }
}
