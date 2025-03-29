package src.tests;

import libs.CoreTestCase;
import libs.Platform;
import libs.ui.WelcomePageObject;
import libs.ui.factories.WelcomePageFactory;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
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
